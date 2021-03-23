//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 746 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
//        int[][] temp = new int[matrix.length][matrix.length];
//        for (int row = 0; row < matrix.length; row++) {
//            int row_place = matrix.length - 1 - row;
//            for (int row_numIndex = matrix.length - 1; row_numIndex >= 0; row_numIndex--) {
//                temp[row_numIndex][row_place] = matrix[row][row_numIndex];
//            }
//
//        }
//
//        int n = matrix.length;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                matrix[i][j] = temp[i][j];
//            }
//        }

        /**
         * 矩阵旋转90° = 矩阵先转置 + 每行左右翻转
         * */

        //数组转置
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix.length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }

        }

        //数组翻转--> 每行逆序
        for(int row = 0; row < matrix.length; row++){
            int left = 0;
            int right = matrix[row].length - 1;
            while(left < right){
                int temp  = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }



    }


}
//leetcode submit region end(Prohibit modification and deletion)
