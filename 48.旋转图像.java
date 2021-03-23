/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 *
 * https://leetcode-cn.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (72.15%)
 * Likes:    777
 * Dislikes: 0
 * Total Accepted:    141.5K
 * Total Submissions: 196K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * matrix.length == n
 * matrix[i].length == n
 * 1 
 * -1000 
 * 
 * 
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix.length - 1;
        while( a <= c && b <= d){
            rotate(a++, b++, c--, d--, matrix);

        }
    }

    /***
     * 一层一层旋转 当最后一层完事以后 就结束了
     * 
     * @param (a,b) 左上顶点
     * @param (c,d) 右下顶点 以(a,b), (c,d) 围成的正方形的四条边旋转90°
     */

    public void rotate(int a, int b, int c, int d, int[][] matrix) {
        int times = d - b;
        /***
         * 每4个点为一组
         * 翻转一组中的四个点
         */
        for( int i = 0; i < times; i++){
            int first = matrix[a][ b + i]; //第一个点
            int second = matrix[a+i][d]; //第二个点
            int third = matrix[c][d-i]; //第三个点
            int fourth = matrix[c-i][b]; // 第四个点
            matrix[a][b + i] = fourth;
            matrix[a + i][d] = first;
            matrix[c][d-i] = second;
            matrix[c - i][b] = third;
        }
    
    }
}
// @lc code=end
