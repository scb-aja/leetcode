/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (41.60%)
 * Likes:    1029
 * Dislikes: 0
 * Total Accepted:    190.5K
 * Total Submissions: 457.7K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        /**
         * dp[i] 表示从0 位置 能否跳到 i 位置
         * 
         * 最后一步dp[10]---->从0位置能否跳到10位置
         * dp[10]:只要dp[0]-->dp[9] + 适当的对应的步伐 其中一个能跳到10 就可以
         
         */
        boolean[] dp = new boolean[len];
        //初始化
        dp[0] = true;
        //设计状态方程
        for( int i = 1; i < len; i++){
            for( int j = 0; j < i; j++){
                if(dp[j]&&( j + nums[j]) >= i ){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[ len - 1];
    }
}
// @lc code=end

