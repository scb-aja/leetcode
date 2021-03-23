import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 *
 * https://leetcode-cn.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (42.98%)
 * Likes:    168
 * Dislikes: 0
 * Total Accepted:    29.7K
 * Total Submissions: 69.2K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * 
 * 解释:
 * 
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 给定矩阵中的元素总数不会超过 100000 。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null)
            return null;

        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        /**
         * 定义两个游走的指针 (upRow, upCol) -->往右走碰到最后一列往下走 (downRow, downCol)--> 往下走碰到最后一行往右走
         */
        int upCol = 0;
        int upRow = 0;
        int downCol = 0;
        int downRow = 0;
        int matrixMaxRow = matrix.length - 1;
        int matrixMaxCol = matrix[0].length - 1;
        boolean isUp = false;
        while (upRow < matrix.length) {
            diagonal(upRow, upCol, downRow, downCol, isUp, matrix, list);
            // 是不是走到最后一列， 若走到最后一列 往下走 否则 继续往右走
            upRow = upCol == matrixMaxCol ? upRow + 1 : upRow;
            upCol = upCol == matrixMaxCol ? upCol : upCol + 1;
            // 是不是走到最后一行, 若走到最后一行就往右走 否则 继续往下走
            downCol = downRow == matrixMaxRow ? downCol + 1 : downCol;
            downRow = downRow == matrixMaxRow ? downRow : downRow + 1;
            isUp = !isUp; // 控制输出顺序
        }
        int[] res = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            res[index] = list.get(index);
        }
        return res;

    }

    // 获取对角线上的元素
    public void diagonal(int upRow, int upCol, int downRow, int downCol, boolean isUp, int[][] matrix,
            List<Integer> list) {

        // 顺序从上到下
        if (isUp) {
            while (upRow <= downRow) {
                list.add(matrix[upRow++][upCol--]);
            }

        } else {
            // 顺序从下到上
            while (downRow >= upRow) {
                list.add(matrix[downRow--][downCol++]);
            }
        }
    }
}
// @lc code=end
