//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 905 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
//        int left = 0;
//        int right = 0;
//        while (right < nums.length){
//            if(nums[right] != 0){
//                swap(nums, left, right);
//                left++;
//            }
//            right++;
//        }



        int first_zero_index = -1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                first_zero_index = index;
                break;
            }
        }

        /**
         * 将非0元素覆盖
         * */
        if (first_zero_index != nums.length - 1 && first_zero_index != -1) {
            int cover_index = first_zero_index;
            for (int j = first_zero_index + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[cover_index] = nums[j];
                    cover_index++;
                }

            }

            while(cover_index < nums.length){
                nums[cover_index++] = 0;
            }
        }


    }

    public void swap(int[] nums, int begin, int end) {
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
