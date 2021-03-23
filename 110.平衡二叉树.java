/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (55.11%)
 * Likes:    591
 * Dislikes: 0
 * Total Accepted:    173.2K
 * Total Submissions: 313.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 
 * 
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

    public boolean isBalanced(TreeNode root) {
        int res = treeHeight(root);
        return res != -1;
    }

    public int treeHeight(TreeNode root){
        if( root == null){
            return 0;
        }
        //求出左右字数高度 (自己规定) -1 代表当前子树不是平衡二叉树
        int leftHeight = treeHeight(root.left);    
        int rightHeight = treeHeight(root.right);
        if( leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        //左右子树高度差值绝对值大于-1也不是平衡二叉树
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// @lc code=end

