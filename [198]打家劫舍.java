//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1255 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        /**
         * dp[i][0] 为 截止到第i个房间 所偷窃的最高金额 且 不偷第i个房间
         * dp[i][0] = max(dp[i - 1][0], dp[ i - 1][1]);
         * dp[i][1] 为 截止到第i个房间 所偷窃的最高金额 且 偷第i个房间
         *  dp[i][1] = dp[ i - 1 ][1] + nums[i];
         * */

        if ( nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for( int index = 1; index < nums.length; index++){
            dp[index][0] = Math.max(dp[index - 1][0], dp[index - 1][1]);
            dp[index][1] = dp[index - 1][0] + nums[index];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
