/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /***
         * i为 到第i天获得最大的利润
         * dp[i][0]  当前位置获得最大的利润 且 手里无股票
         * dp[i][1]  截止到i 获得最大的利润 且 手里有股票
         * 
         * 
         */
        if (prices.length == 0)
            return 0;
            
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int index = 1; index < prices.length; index++) {
            /**
             * 当前dp[index][0] 有两种情况:
             * dp[index - 1][0]--->前一天就没有股票
             * dp[index - 1][1] + prices[index] -------> 前一天有股票，今天给卖了
               取最大
             

               当前dp[index][1] 有两种情况:
                dp[index - 1][1]----> 前一天就有股票
                dp[index - 1][0] - prices[index] -----> 前一天有股票 但是今天买了股票
             */


            dp[index][0] = Math.max(dp[index - 1][0], dp[index - 1][1] + prices[index]);
            dp[index][1] = Math.max(dp[index - 1][1], dp[index - 1][0] - prices[index]);   

        }

        return Math.max(dp[len - 1][0], dp[len - 1][1]);

    }
}
// @lc code=end
