/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 *
 * https://leetcode-cn.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (81.64%)
 * Likes:    242
 * Dislikes: 0
 * Total Accepted:    32.9K
 * Total Submissions: 40.3K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 
 * 
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 
 * 
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * ⁠   - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * ⁠       - 空数组，无子节点。
 * ⁠       - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * ⁠           - 空数组，无子节点。
 * ⁠           - 只有一个元素，所以子节点是一个值为 1 的节点。
 * ⁠   - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * ⁠       - 只有一个元素，所以子节点是一个值为 0 的节点。
 * ⁠       - 空数组，无子节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * nums 中的所有整数 互不相同
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
        int val;
        int index;
        public ReturnData(int index, int val){
            this.index = index;
            this.val = val;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructTree(int[] nums, int left, int right){
        //base case
        if(left > right){
            return null;
        }

        //构建头节点
        int maxIndex = getMaxIndex(nums, left, right);
        TreeNode node = new TreeNode(nums[maxIndex]);
        //构建左树
        TreeNode nodeLeft = constructTree(nums, left, maxIndex - 1);
        //构建右树
        TreeNode nodeRight = constructTree(nums, maxIndex + 1, right);
        if(nodeLeft != null){
            node.left = nodeLeft;
        }

        if(nodeRight != null){
            node.right = nodeRight;
        }
        return node;
    }


    public int getMaxIndex(int[] nums, int left, int right){
        int res = nums[left];
        int index = left;
        for(int i = left + 1; i <= right; i++){
            if( nums[i] > res){
                res = nums[i];
                index = i;
            }

        }
        return index;
    }
}
// @lc code=end

