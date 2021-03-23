/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 存放结果的
        int[] array = new int[n];

        /**
         * 递推公式 x是当前的阶数 爬到f(x) 爬到x阶数的方案 f(x) = f(x-1) + f(x - 2)
         * 
         */

        for (int index = 0; index < n; index++) {
            if (index == 0)
                array[index] = 1;
            else if (index == 1)
                array[index] = array[0] + 1;
            else 
                array[index] = array[index - 1] + array[index - 2];

        }

        return array[n - 1];
    }
}
// @lc code=end
