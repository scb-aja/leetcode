/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 1. dp[i][j]: 从(0, 0) 到 (i, j) 多少个路径
         * 
         * 2. dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
         * 
         * 多了个条件: 从(0, 0) 到障碍物的路径 应该是0
         * 
         * 3. 初始化 dp[i][0] = 1; dp[0][j] = 1; 如果有路障则应该为0 没有路径能达到这个障碍物
         * 
         * 
         * 4.确定遍历顺序 从左往右遍历
         * 
         * 5. 看看dp table 是否一样
         */

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        // 障碍物 和 障碍物后面的 路径 为0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else if (obstacleGrid[i][0] == 1)
                break;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0)
                dp[0][j] = 1;

            else if (obstacleGrid[0][j] == 1)
                break;    
        
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 判断ij 是否是障碍物
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }

        }
        return dp[m - 1][n - 1];

    }
}
// @lc code=end
