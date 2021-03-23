/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
 *
 * https://leetcode-cn.com/problems/univalued-binary-tree/description/
 *
 * algorithms
 * Easy (68.62%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    25.4K
 * Total Submissions: 37.1K
 * Testcase Example:  '[1,1,1,1,1,null,1]'
 *
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[2,2,2,5,2]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
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
    public static class ReturnData{
        int val;
        boolean flag;
        public ReturnData(int val, boolean flag){
            this.val = val;
            this.flag = flag;
        }
    }
    
    public boolean isUnivalTree(TreeNode root) {
        return isSingle(root).flag;
    }

    public ReturnData isSingle(TreeNode root){
        if(root == null){
            return null;
        }

        ReturnData leftData = isSingle(root.left);
        ReturnData rightData = isSingle(root.right);
        if(leftData == null){
            if(rightData == null){
                return new ReturnData(root.val, true);
            }else{
                return new ReturnData(root.val, (rightData.flag&&(root.val == rightData.val)));

            }
        } else{
            if(rightData == null){
                return new ReturnData(root.val,(leftData.flag&&(root.val == leftData.val)));
            }else{
                return new ReturnData(root.val, (leftData.flag&&rightData.flag&&(root.val == leftData.val)&&(root.val == rightData.val)));
            }
        
        } 

    
    
    }

}
// @lc code=end

