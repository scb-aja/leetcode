//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 430 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> hashMap1 = new HashMap<>();
//        Map<Integer, Integer> hashMap2 = new HashMap<>();
//
//        for(int index = 0; index < nums1.length; index++){
//            if(hashMap1.containsKey(nums1[index])){
//                hashMap1.put(nums1[index], hashMap1.get(nums1[index]) + 1);
//            }else
//                hashMap1.put(nums1[index], 1);
//        }
//
//        for(int index = 0; index < nums2.length; index++){
//            if(hashMap2.containsKey(nums2[index])){
//                hashMap2.put(nums2[index], hashMap2.get(nums2[index]) + 1);
//            }else
//                hashMap2.put(nums2[index], 1);
//        }
//
//        List<Integer> list = new ArrayList<>();
//        Set<Map.Entry<Integer, Integer>> entrySet = hashMap1.entrySet();
//        for(Map.Entry<Integer, Integer> entry : entrySet){
//            if(hashMap2.containsKey(entry.getKey())){
//                int nums1_count = entry.getValue();
//                int nums2_count = hashMap2.get(entry.getKey());
//                int min = 0;
//                if(nums1_count < nums2_count)
//                    min = nums1_count;
//                else
//                    min = nums2_count;
//                for(int index = 0; index < min; index++)
//                    list.add(entry.getKey());
//            }
//        }
//
//        int[] array = new int[list.size()];
//        for(int index = 0; index < list.size(); index++)
//            array[index] = list.get(index);
//        return array;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1_index = 0;
        int nums2_index = 0;
        List<Integer> list = new ArrayList<>();
        int temp_index = 0;
        while (nums1_index < nums1.length && nums2_index < nums2.length) {
            if (nums1[nums1_index] == nums2[nums2_index]) {
                list.add(nums1[nums1_index]);
                nums1_index++;
                nums2_index++;
            }else if(nums1[nums1_index] > nums2[nums2_index]){
                nums2_index++;
            }else if(nums2[nums2_index] > nums1[nums1_index]){
                nums1_index++;
            }

            temp_index++;
        }
        int[] result = new int[list.size()];
        for(int index = 0; index < result.length; index++)
            result[index] = list.get(index);
        return result;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
