/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (56.59%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    69.7K
 * Total Submissions: 123.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, null);
        return res;
    }

    public void dfs(TreeNode node, TreeNode partent){
        if(node == null){
            return;
        }

        if(partent != null && partent.left == node && node.left == null && node.right == null){
            res += node.val;
        }else{
            dfs(node.left, node);
            dfs(node.right, node);

        }
    }
}
// @lc code=end

