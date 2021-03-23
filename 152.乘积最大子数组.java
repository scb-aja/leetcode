/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (40.92%)
 * Likes:    923
 * Dislikes: 0
 * Total Accepted:    114.9K
 * Total Submissions: 280.8K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len  = nums.length;
        int[][] dp = new int [len][2];
        // dp[i][0] 是 以nums[i]为结尾的子序列乘机最大值
        // dp[i][1] 是 以nums[i]为结尾的子序列乘机最小值
        /**为什么要保存最大值和最小值呢
         * 当nums[i]等于负数时 nums[i]*最小值 就是最大的
         * 同理nums[i]等于正数 nums[i]*最大值 就是最大的
         */
        //初始化
        dp[0][0] = dp[0][1] = nums[0];
       
        /**
         * 状态转移方程
         * dp[i][0] = max(nums[i], max(nums[i]*dp[i - 1][0], nums[i]*dp[i][1]))
         * 
         * dp[i][1] = min(nums[i], min(nums[i]*dp[i - 1][0], nums[i]*dp[i- 1][1]))
         */
        int res = nums[0];
        for( int i = 1; i < len; i++){
            dp[i][0] = Math.max(nums[i], Math.max(nums[i]*dp[i - 1][0], nums[i]*dp[i - 1][1]));

            dp[i][1] = Math.min(nums[i], Math.min(nums[i]*dp[i - 1][0], nums[i]*dp[i - 1][1]));
            res = Math.max(dp[i][0], res);
        }

        return res;

    }
}
// @lc code=end

