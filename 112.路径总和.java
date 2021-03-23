
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 *
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (51.81%)
 * Likes:    513
 * Dislikes: 0
 * Total Accepted:    174K
 * Total Submissions: 335.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点
 * 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 
 * -1000 
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
import java.util.List;
import java.util.ArrayList;
class Solution {
    List<Integer> list = new ArrayList<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root == null){
           return false;
       }
       if(root.left == null && root.right == null && root.val == targetSum){
           return true;
       }
       boolean isLeft = hasPathSum(root.left, targetSum - root.val);
       boolean isRight = hasPathSum(root.right, targetSum - root.val);
       return isLeft || isRight;
    }

    public boolean hasPathSumByDfs(TreeNode root, int targetSum){
        dfs(root, targetSum, 0);
        return list.size() == 0 ? false : true;
    }

    public void dfs(TreeNode node, int targetSum, int sum){
        if(node == null){
            return;
        }
        sum += node.val;
        if(node.left == null && node.right == null && sum == targetSum){
            list.add(sum);
        }else{
            dfs(node.left, targetSum, sum);
            dfs(node.right,targetSum, sum);
        }
    }
}
// @lc code=end

