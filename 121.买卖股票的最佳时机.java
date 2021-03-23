/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /**
         *
         * f(i) 为第i天能获得的最大利润 f(i) = max[f[i-1] + price[i] - price[i - 1], 0]
         */

        int[] f = new int[prices.length];
        int maxProfit = 0; //找到最大的利润
        for (int index = 0; index < prices.length; index++) {
            if (index == 0) {
                f[index] = 0;
            } else {
                f[index] = Math.max(f[index - 1] + prices[index] - prices[index - 1], 0);

            }
            maxProfit = Math.max(maxProfit, f[index]);
        }

        return maxProfit;

    }
}
// @lc code=end
