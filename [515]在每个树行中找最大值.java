//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 125 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        findLargestInEveryLevel(root, 1);
        return list;
    }

    public void findLargestInEveryLevel(TreeNode root, int level){
        if( root == null){
            return ;
        }
        //已经遍历的层数
        int len = list.size();
        //当前层还没有遍历 则 放进去
        if( level > len){
            list.add(root.val);
        }else{
            // 当前层已经遍历到了 则 更换最大值
            list.set((level - 1), Math.max(root.val, list.get(level - 1)));
        }
        findLargestInEveryLevel(root.left, level + 1);
        findLargestInEveryLevel(root.right, level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
