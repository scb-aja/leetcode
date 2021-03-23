/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        /***
         * 存放到 dp[i] [j] 的路径条数
         * 根据题意 机器人只能往下和往右走
         * 
         * d[i][j] = d[i - 1][j] + d[i][ j - 1]
                        (往下走)      (往右走)
        
           1. 确定dp数组的含义： 存放的是到该点的路径条数             
           2. 确定递推公式:   d[i][j] = d[i - 1][j] + d[i][ j - 1]
                                        (往下走)      (往右走)

           3. 确定遍历的方向 
                从左到右一层层遍历
            4. 初始化
                由题意可知 dp[i][0] = 1 
                          dp[0][j] = 1   
            5. 查看db table 数组的预期 和自己的预期是否一样
         */           

        int[][] dp = new int[m][n];

        for( int i = 0; i < m; i++)
            dp[i][0] = 1;

        for ( int j = 0; j < n; j++)
            dp[0][j] = 1;

        for( int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1 ];
        
        return dp[ m - 1 ][ n - 1 ];
    }
}
// @lc code=end

