//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 726 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int nums1_index = 0;
        int nums2_index = 0;
        int result_index = 0;
        while (nums1_index < m && nums2_index < n){
            if(nums1[nums1_index] <= nums2[nums2_index]){
                result[result_index] = nums1[nums1_index];
                nums1_index++;
            }else{
                result[result_index] = nums2[nums2_index];
                nums2_index++;
            }
            result_index++;
        }

        //nums2 还有剩余
        while (nums2_index < n){
            result[result_index] = nums2[nums2_index];
            result_index++;
            nums2_index++;
        }

        //nums1 还有剩余
        while (nums1_index < m){
            result[result_index] = nums1[nums1_index];
            result_index++;
            nums1_index++;
        }


        //copy nums1
        for(int index = 0; index < result.length; index++){
            nums1[index] = result[index];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
