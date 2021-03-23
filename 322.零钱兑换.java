import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (42.39%)
 * Likes:    1038
 * Dislikes: 0
 * Total Accepted:    175.7K
 * Total Submissions: 414.4K
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：coins = [1], amount = 2
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        /**
         * dp[i] ---> i金额 的所需要的最少的硬币个数
         * 
         * dp[i] = min(dp[i-coin1] , dp[i-coin2], dp[i-coin3]...) + 1
         */
        // 初始化 最多有amount 个 1 组成 所以次数设置amount + 1 为无穷大
        int[] dp = new int[amount + 1];
        for (int index = 1; index <= amount; index++)
            dp[index] = index + 1;

        // dp[10]

        for (int i = 1; i <= amount; i++) {
            for (int temp : coins) {
                int targetCoin = i - temp;
                if (targetCoin < 0)
                    continue;
                if (dp[targetCoin] != -1) 
                    dp[i] = Math.min(dp[targetCoin] + 1, dp[i]);
            }
            dp[i] = (dp[i] == (i + 1)) ? -1 : dp[i];
        }

        return dp[amount];

    }

    public int coinChange_timeLimitExceeded(int[] coins, int amount) {
        /***
         * dp[i] 当前i金额 所需要的最少硬币个数
         * 
         *
         * dp[10]--> 当前10金额, 所需要的最少硬币个数 dp[10] = min(dp[9] + 1, dp[8] + 2, dp[7] + 3,
         * ....) (1, 2, 3..)是coins存放的金额 如果都没有则 dp[10] = -1;
         */

        int[] dp = new int[amount + 1];
        // 初始化
        for (int index = 1; index < dp.length; index++) {
            dp[index] = index + 1;
        }

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < i; j++) {
                int targetCoin = i - j;
                if (isCoinExit(coins, targetCoin) && dp[j] != -1) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            dp[i] = (dp[i] == i + 1) ? -1 : dp[i];
        }

        return dp[amount];

    }

    public boolean isCoinExit(int[] coins, int targetCoin) {
        for (int index = 0; index < coins.length; index++) {
            if (targetCoin == coins[index])
                return true;
        }

        return false;

    }

}

// @lc code=end
