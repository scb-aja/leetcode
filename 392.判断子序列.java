/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        /***
         * dp[i][j] 代表的是0........i 是 0.....j 的子序列
         * 
         * 
         * 
         */
        
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[ m + 1 ][ n + 1];    
        //初始化 第一行是空字符串 所以空字符串是任意字符串的子序列
        for( int j = 0; j < dp[0].length; j++)
            dp[0][j] = true;
        
        for ( int i = 1; i <= m ; i++){
            char ch1 = s.charAt(i - 1);
            for ( int j = 1; j <= n; j++){
                 char ch2 = t.charAt(j - 1);
                // /**
                //  * ch1 字符 和 ch2 字符相等
                //  * 如果前一串 是 前一串的子序列
                //  * 则当前也是子序列
                //  *
                //  * dp[i][j] = dp[i - 1][ j - 1]
                //  */
                // if(ch1 == ch2)
                //     dp[i][j] = dp[i - 1][j - 1];
                // else if( dp[i][j - 1]) //ab 是abc 的子序列 ab 也是abcd的子序列
                //     dp[i][j] = true;
                // else
                //     dp[i][j] = false;
            
                if( ch1 == ch2)
                    dp[i][j] = dp[i - 1][j - 1];
                else if (dp[i][ j - 1])
                    dp[i][j] = true;
            
                else if ( ch1 != ch2 && !dp[i][ j - 1])
                    dp[i][j] = false;
            }

        }
        return dp[m][n];
    
    
    }


    public boolean isSubsequenceTwoPointer(String s, String t){
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        while(sIndex < sChars.length && tIndex < tChars.length){
            if (sChars[sIndex] == tChars[tIndex]){
                sIndex++;    
                tIndex++;
            }else{
                tIndex++;
            }            

        }

        if ( sIndex == sChars.length)
            return true;
        else
            return false;


    }
}
// @lc code=end

