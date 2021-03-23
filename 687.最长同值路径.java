/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Medium (42.64%)
 * Likes:    425
 * Dislikes: 0
 * Total Accepted:    28.9K
 * Total Submissions: 67.8K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * 
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
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
import java.util.Map;
import java.util.HashMap;
class Solution {
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, root.val);
        return max;
    }

    
    public void dfs(TreeNode root, int target){
        if(root == null){
            return;
        }
        //找到路径 最长左路径 最长右路径
        int leftPath = getSameValpath(root.left, target);
        int rightPath = getSameValpath(root.right, target);
        if(leftPath != -1 && rightPath != -1){
            max = Math.max(max, leftPath + rightPath + 2);
        }else if(leftPath == - 1 && rightPath != -1){
            max = Math.max(max, rightPath + 1);
        }else if(leftPath != -1 && rightPath == -1){
            max = Math.max(max, leftPath + 1);
        }
        int leftNextNode = root.left == null ? 0 : root.left.val;
        int rightNextNode = root.right == null ? 0 : root.right.val;
        dfs(root.left, leftNextNode);
        dfs(root.right, rightNextNode);
    }
    /**
     * 以root 为根节点 找到和root.val 相同值的最长路径个数 必须紧挨着的
     */
    public int getSameValpath(TreeNode root, int target){
        if(root == null || root.val != target){
            return -1;
        }
        int leftPath = getSameValpath(root.left, target);
        int rightPath = getSameValpath(root.right, target);
        if(leftPath == -1 && rightPath == -1){
            return 0;
        }
        if(leftPath == -1){
            return rightPath + 1;
        }
        if(rightPath == -1){
            return leftPath + 1;
        }
        return Math.max(leftPath, rightPath) + 1;
    }


}
// @lc code=end

