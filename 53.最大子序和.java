import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        /***
         * f(i)代表的是以第i个数为结尾的【连续子数组的最大和】 所求的答案就是max f(i) 只需要求出每个位置的f(i), 然后返回f数组中的最大值
         * f(i)如何求出呢 a[i] = num[i] 可以考虑a[i]单独成为一段还是加入到f(i-1)对应的那一段 这取决于ai和f(i-1) + ai
         * 的大小, 我们希望获得比较大的 f(i) = max{ f(i-1) + ai, ai}
         * 
         * 
         */
        int[] f = new int[nums.length]; // 存储以index数为结尾的最大字数和
        int maxAns = nums[0]; //存储最大的以index为结尾的子续之和
        for (int index = 0; index < nums.length; index++) {
            if (index == 0)
                f[index] = nums[index];
            else {
                f[index] = Math.max(f[index - 1] + nums[index], nums[index]);
            }
            maxAns = Math.max(maxAns, f[index]);
        }

        return maxAns;

    }
}
// @lc code=end
