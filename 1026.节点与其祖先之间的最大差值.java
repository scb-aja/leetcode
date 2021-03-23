/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] 节点与其祖先之间的最大差值
 *
 * https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/description/
 *
 * algorithms
 * Medium (65.38%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    8.1K
 * Total Submissions: 12.4K
 * Testcase Example:  '[8,3,10,1,6,null,14,null,null,4,7,13]'
 *
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B
 * 的祖先。
 * 
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释： 
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数在 2 到 5000 之间。
 * 0 
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
    int res;
    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        dfs(root, root.val, root.val);
        return res;
    }

    public void dfs(TreeNode root, int grandMax, int grandMin){
        if( root == null){
            return;
        }
        int abs1 = Math.abs(grandMax - root.val);
        int abs2 = Math.abs(grandMin - root.val);
        res = Math.max(Math.max(abs1, abs2), res);
        grandMax = Math.max(grandMax, root.val);
        grandMin = Math.min(grandMin, root.val);
        dfs(root.left, grandMax, grandMin);
        dfs(root.right, grandMax, grandMin);
    }
}
// @lc code=end

