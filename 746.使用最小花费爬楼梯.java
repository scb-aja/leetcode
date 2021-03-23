/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * 找出状态方程
         * i为当前台阶 f(i) 为 爬到这个台阶花费的最低值
         * f(i) = min(f(i-1) + cost[i - 1], f(i-2) + cost[ i - 2])
         * 
         */
        int[] f = new int[cost.length];

        for( int index = 0; index < cost.length; index++){
            if ( index == 0)
                f[index] = 0;
            else if ( index == 1)
                f[index] = Math.min(0, f[index - 1] + cost[index - 1]);
            else
                f[index] = Math.min(f[index - 1] + cost[index - 1], f[index - 2] + cost[index - 2]);
        }
        int index_1 = cost.length - 1;
        int index_2 = cost.length - 2;
        return Math.min(f[index_1] + cost[index_1],  f[index_2] + cost[index_2]);
    

    }
}
// @lc code=end

