//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 213 👎 0

import java.util.ArrayList;
import java.util.List;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //得逆序
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0)
            return list;
        list.add(1);
        if(rowIndex == 1)
            return list;

        //从3处理
        for(int row = 3; row <= rowIndex + 1; row++){
            //
            for(int j = row - 2; j >= 1; j--){
                list.set(j, list.get(j) + list.get(j - 1));
            }
            list.add(1);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
