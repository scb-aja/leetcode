import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以nums[i] 为最后 递增子序列的长度
        int len = nums.length;
        int[] dp = new int[len];
        int result = 1;
        // 初始化
        Arrays.fill(dp, 1);

        /**
         * 
         * 最后一步 dp[10] 0=<j<=9 ,满足nums[10] > (nums[j1], nums[j2]...) max(dp[j1] + 1,
         * dp[j2] + 1, dp[j3] + 1)
         * 
         */
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);

            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
// @lc code=end
