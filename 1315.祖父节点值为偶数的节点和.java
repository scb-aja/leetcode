/*
 * @lc app=leetcode.cn id=1315 lang=java
 *
 * [1315] 祖父节点值为偶数的节点和
 *
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
 *
 * algorithms
 * Medium (81.08%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    10.3K
 * Total Submissions: 12.7K
 * Testcase Example:  '[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]'
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * 
 * 
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 
 * 
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
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
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return res;
    }
    public void dfs(TreeNode root , TreeNode parent, TreeNode grandFather){
        if(root == null){
            return;
        }
        
        if(grandFather != null && grandFather.val % 2 == 0){
            res += root.val;
        }

        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    
    }
}
// @lc code=end

