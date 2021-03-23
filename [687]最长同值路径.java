//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 425 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        getLongestPath(root);
        return max;
    }
    public int getLongestPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftPath = getLongestPath(root.left);
        int rightPath = getLongestPath(root.right);
        int left = 0;
        int right = 0;
        if(root.left != null && root.left.val == root.val){
            leftPath++;
            left += leftPath;
        }
        if(root.right != null && root.right.val == root.val){
            rightPath++;
            right += rightPath;
        }
        max = Math.max(max,(left + right));
        return Math.max(left, right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
