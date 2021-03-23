import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=617 lang=java
 *
 * [617] 合并二叉树
 *
 * https://leetcode-cn.com/problems/merge-two-binary-trees/description/
 *
 * algorithms
 * Easy (78.73%)
 * Likes:    619
 * Dislikes: 0
 * Total Accepted:    122.5K
 * Total Submissions: 155.5K
 * Testcase Example:  '[1,3,2,5]\n[2,1,3,null,4,null,7]'
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL
 * 的节点将直接作为新二叉树的节点。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * Tree 1                     Tree 2                  
 * ⁠         1                         2                             
 * ⁠        / \                       / \                            
 * ⁠       3   2                     1   3                        
 * ⁠      /                           \   \                      
 * ⁠     5                             4   7                  
 * 输出: 
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \ 
 * 5   4   7
 * 
 * 
 * 注意: 合并必须从两个树的根节点开始。
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //base case
        if(root1 == null && root2 == null){
            return null;
        }
        TreeNode root1Left = root1 == null ? null : root1.left;
        TreeNode root1Right = root1 == null ? null : root1.right;
        TreeNode root2Left = root2 == null ? null : root2.left;
        TreeNode root2Right = root2 == null ? null : root2.right;
        //合并左子树
        TreeNode newLeft = mergeTrees(root1Left, root2Left);
        //合并右子树
        TreeNode newRight = mergeTrees(root1Right, root2Right);
        //合并当前节点
        TreeNode node = null;
        if(root1 == null){
            node = new TreeNode(root2.val);
        }else if(root2 == null){
            node = new TreeNode(root1.val);
        }else{
            node = new TreeNode(root1.val + root2.val);
        }
        if( newLeft != null){
            node.left = newLeft;
        }
        if( newRight != null){
            node.right = newRight;
        }
        return node;
    }
}
// @lc code=end

