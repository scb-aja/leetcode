//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 765 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
//            int m = k % nums.length;
//            revise(nums,nums.length - m, nums.length - 1);
//            revise(nums, 0, nums.length - m - 1);
//            revise(nums, 0, nums.length - 1);


        /**
         * 笨比解法 两层循环
         *
         * */

        for (int count = 0; count < k; count++) {
            int temp = nums[nums.length - 1];
            for (int index = nums.length - 1; index > 0; index--) {
                nums[index] = nums[index - 1];

            }
            nums[0] = temp;
        }

    }

    public void revise(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
