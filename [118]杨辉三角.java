//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 434 👎 0


import java.util.ArrayList;
import java.util.List;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resutLists = new ArrayList<>();
        for(int row = 0; row < numRows; row++){
            List<Integer> list = new ArrayList<>();
            if(row == 0){
                list.add(1);
            }else if(row == 1){
                list.add(1);
                list.add(1);
            }else{
                List<Integer> pre_list = resutLists.get(row - 1);
                list.add(1);
                for(int index = 0; index < pre_list.size(); index++){
                    if (index == pre_list.size() - 1)
                        list.add(1);
                    else
                        list.add(pre_list.get(index) + pre_list.get(index + 1));
                }

            }
            resutLists.add(list);

        }
        return resutLists;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
