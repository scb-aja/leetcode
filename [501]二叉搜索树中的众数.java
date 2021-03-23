//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 278 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    int pre = 0;
    int count = 1;
    int maxCount = 0;
    Map<Integer, String> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        String str = map.get(maxCount);
        return getArray(str);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        update(root.val);
        inOrder(root.right);
    }

    public void update(int x){
        if(x == pre){
            count++;
        }else{
            count = 1;
            pre = x;
        }
        if(count >= maxCount){
            maxCount = count;
            map.put(maxCount, map.getOrDefault(maxCount, "") + "!" + x);
        }
    }

    public  int[] getArray(String str){
        String[] vals = str.split("!");
        int[] res = new int[vals.length - 1];
        for(int index = 1; index < vals.length ; index ++){
            String s = vals[index];
            if(!"".equals(s)){
                res[index - 1] = Integer.parseInt(s);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
