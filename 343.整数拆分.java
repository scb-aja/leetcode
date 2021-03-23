/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        /***
         * dp[i]  分解i 并且求出i的最大乘机
         * 
         * 列子：
         *  求6的 分解后最大乘机
         *    1, 5, 2, 4  3, 3 ,4, 2  5 , 1   
         *    max(1*5、1*dp[5]、dp[1]*dp[5], 2*4、 2*dp[4]、dp[2]*dp[4].....)  
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for( int i = 3; i <= n; i++){
            for( int j = 1 ; j <= i / 2 ; j++){
                //dp[i] = Math.max(Math.max(dp[i], dp[j]*dp[i - j]), Math.max(j*(i-j), j*dp[i - j]));
               
               int temp1 =  Math.max(dp[j]*(i-j), j*dp[i - j]);
               int temp2 = Math.max(dp[j]*dp[i-j], j*(i -j));
               dp[i] = Math.max(dp[i], Math.max(temp1, temp2));     
            }      
        }
    
        return dp[n];
    }


}
// @lc code=end

