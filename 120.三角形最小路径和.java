/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (67.05%)
 * Likes:    681
 * Dislikes: 0
 * Total Accepted:    127.3K
 * Total Submissions: 189.9K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1
 * 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * ⁠  2
 * ⁠ 3 4
 * ⁠6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：triangle = [[-10]]
 * 输出：-10
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * 
 * 
 */

// @lc code=start
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i][j] 为 dp[0][0] 到dp[i][j]的最短路径

        int len = triangle.size();
        int[][] dp = new int[len][len];
        // 初始化
        dp[0][0] = triangle.get(0).get(0);
        // 初始化三角形的两条边
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }


        // dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i)(i);
        for (int i = 2; i < len; i++) {
            int size = triangle.get(i).size();
            for (int j = 1; j <= size - 2; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int res = dp[len - 1][0];
        for(int i = 1; i < len; i++){
            res = Math.min(dp[len - 1][i], res);
        }

        return res;
    }

    public int tijie_minimumTotal(List<List<Integer>> triangle) {
        /***
         * dp[i][j] 为 到底边的最小路径和 底边是d[len][len] 从下往上递推
         */

        int len = triangle.size();
        int[][] dp = new int[len + 1][len + 1];

        // dp[10] 假设底边(自己舍得d[11][0].....等于0)为d[11]
        // for( int i = 0; i < dp[10].length; i++){
        // dp[10][i] = Math.min(dp[11][i], dp[11][i + 1]) + triangle.get(10).get(i);

        // }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }

        }

        return dp[0][0];

    }
}
// @lc code=end
