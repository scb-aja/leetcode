/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (53.55%)
 * Likes:    1239
 * Dislikes: 0
 * Total Accepted:    265.8K
 * Total Submissions: 496.3K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * 
 */

// @lc code=start
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetry(root.left, root.right);
    }

    public boolean isSymmetry(TreeNode root1, TreeNode root2){
        if( root1 == null && root2 == null){
            return true;
        }
        if(root1 == null && root2 != null){
            return false;
        }
        if(root1 != null && root2 == null){
            return false;
        }
        /**
         * root1左树 和 root2右树 是否是对称
         * root1右树 和 root2左树 是否是对称
         * 根节点的是是否是相等的
         * 
         * 同时满足 三个条件 才是对称的
         */
        boolean isSymmetric1 = isSymmetry(root1.left, root2.right);
        boolean isSymmetric2 = isSymmetry(root1.right, root2.left);
        return isSymmetric1&&isSymmetric2&&(root1.val == root2.val);
    }
}
// @lc code=end

