import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (42.39%)
 * Likes:    599
 * Dislikes: 0
 * Total Accepted:    101.2K
 * Total Submissions: 238K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * -100 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultsList = new ArrayList<>();
        int leftRow = 0;
        int leftCol = 0;
        int rightRow = matrix.length - 1;
        int rightCol = matrix[0].length - 1;
        while ( leftRow <= rightRow && leftCol <= rightCol){
            getPath(leftRow, leftCol, rightRow, rightCol, resultsList, matrix);
            leftRow++;
            leftCol++;
            rightRow--;
            rightCol--;
        }
        return resultsList;
    }

    /***
     * 给你两个点 画出以这个两个点围成的长方形 并且得到他们的边
     * 
     * @param leftRow  左边界的点1
     * @param leftCol  左边界的点2
     * @param rightRow 右边界的点1
     * @param rightCol 右边界的点2
     */
    public void getPath(int leftRow, int leftCol, int rightRow, int rightCol, List<Integer> resultsList,
            int[][] matrix) {
        // 同一行的情况
        if (leftRow == rightRow) {
            for (int j = leftCol; j <= rightCol; j++) {
                resultsList.add(matrix[leftRow][j]);
            }
            // 同一列的情况
        } else if (leftCol == rightCol) {
            for (int i = leftRow; i <= rightRow; i++) {
                resultsList.add(matrix[i][leftCol]);
            }
        } else {
            // 打印上边
            for (int j = leftCol; j < rightCol; j++) {
                resultsList.add(matrix[leftRow][j]);
            }
            // 打印右边
            for (int i = leftRow; i < rightRow; i++) {
                resultsList.add(matrix[i][rightCol]);
            }

            // 打印下边
            for (int j = rightCol; j > leftCol; j--) {
                resultsList.add(matrix[rightRow][j]);
            }
            // 打印左边
            for (int i = rightRow; i > leftRow; i--) {
                resultsList.add(matrix[i][leftCol]);
            }

        }
    }
}
// @lc code=end
