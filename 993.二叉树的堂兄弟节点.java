/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
 *
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/description/
 *
 * algorithms
 * Easy (52.33%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    17.3K
 * Total Submissions: 33.1K
 * Testcase Example:  '[1,2,3,4]\n4\n3'
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * 
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
    public class ReturnData{
        int depth;
        TreeNode parent;
        public ReturnData(int depth, TreeNode partent){
            this.depth = depth;
            this.parent = partent;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        ReturnData xData = findData(root, x, 0, null);   
        ReturnData yData = findData(root, y, 0, null);   
        if(xData.parent == yData.parent || xData.depth != yData.depth){
            return false;
        }
        return true;
    }
    public ReturnData findData(TreeNode root, int x, int depth, TreeNode parent){
        if( root == null){
            return null;
        }
    
        ReturnData leftData = findData(root.left, x, depth + 1, root);
        ReturnData rightData = findData(root.right, x, depth + 1, root);
        if(root.val == x){
            return new ReturnData(depth, parent);
        }
       return leftData == null ? rightData : leftData;
    
    }
}
// @lc code=end

