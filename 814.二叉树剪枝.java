/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 *
 * https://leetcode-cn.com/problems/binary-tree-pruning/description/
 *
 * algorithms
 * Medium (70.64%)
 * Likes:    143
 * Dislikes: 0
 * Total Accepted:    17.3K
 * Total Submissions: 24.5K
 * Testcase Example:  '[1,null,0,0,1]'
 *
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * 
 * 
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * ⁠
 * 解释: 
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * 
 * 
 * 
 * 
 * 
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 * 
 * 
 * 
 * 
 * 
 * 说明: 
 * 
 * 
 * 给定的二叉树最多有 100 个节点。
 * 每个节点的值只会为 0 或 1 。
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

    public static class ReturnData{
        boolean isContainOne;
        TreeNode root;
        public ReturnData(boolean isContainOne, TreeNode root){
            this.isContainOne = isContainOne;
            this.root = root;
        }
    }
    public TreeNode pruneTree(TreeNode root) {    
        ReturnData data  =  prune(root);
        return data.isContainOne ? data.root : null;
    }

    public ReturnData prune(TreeNode root){
        if(root == null){
            return new ReturnData(false, root);
        }
        ReturnData leftData = prune(root.left);
        ReturnData rightData = prune(root.right);
        if(leftData.isContainOne && rightData.isContainOne){
            return new ReturnData(true, root);
        }else if(!leftData.isContainOne && rightData.isContainOne ){
            root.left = null;
            return new ReturnData(true, root);
        } else if(leftData.isContainOne && !rightData.isContainOne ){
            root.right = null;
            return new ReturnData(true, root);
        }else{
            root.left = null;
            root.right = null;
            return new ReturnData(root.val == 1, root);
        }    

    }
}
// @lc code=end

