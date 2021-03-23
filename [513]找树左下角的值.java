//给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 149 👎 0


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
    List<Integer> list = new ArrayList<>(); //每一层的最左面的值
    int maxLevel = 0;
    int mostLeft = 0;
    public int findBottomLeftValue(TreeNode root) {
        findBlf(root, 1);
        return mostLeft;
    }
    //level 从 1 开始
    public void findBlf(TreeNode root, int level){
        if(root == null){
            return ;
        }

        // maxLevel 已经遍历的多少层
        //当前层还没有遍历 就把 当前层的第一左值 放进去
        //若没执行 说明 当前层数的第一个左值 已经在里面呢
        if( level > maxLevel){
            mostLeft = root.val;
            maxLevel = level;
        }
        findBlf(root.left, level + 1);
        findBlf(root.right, level + 1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
