/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (68.06%)
 * Likes:    774
 * Dislikes: 0
 * Total Accepted:    176.5K
 * Total Submissions: 259.3K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        //dp[i][j] 为 0 0 到 i, j 的总和最小
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int [row][col];

        dp[0][0] = grid[0][0];
        //初始化 最左边 和 最上边 都比较单一 只能一直走 不能拐弯 所以先初始化
        for( int i = 1; i < row; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for( int j = 1; j < col; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for( int i = 1; i < row; i ++){
            for( int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[ row - 1 ][col - 1];



    }
}
// @lc code=end

