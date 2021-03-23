/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 *
 * https://leetcode-cn.com/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (59.56%)
 * Likes:    208
 * Dislikes: 0
 * Total Accepted:    107.1K
 * Total Submissions: 179.9K
 * Testcase Example:  '[5,2,3,1]'
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        if ( nums == null )
            return null;
        if ( nums.length == 1)
            return nums;
        for( int index = 0; index < nums.length; index++){
            heapInsert(nums, index);
        }
        int size = nums.length;
        swap(nums, 0, size - 1);
        size -= 1;
        while ( size > 0){
            heapify(nums, 0, size);
            swap(nums, 0, --size);
        }

        return nums;

    }

    public void heapInsert(int[] nums, int index){
        while ( nums[index] > nums[ (index - 1)/2]){
            swap(nums, index, (index - 1)/2);
            index = (index - 1)/2;
        }
    }

    public void heapify(int[] nums, int index, int size){
        int leftChild = 2*index + 1;
        while (leftChild < size){
            int largest = (leftChild + 1) < size && nums[leftChild + 1] > nums[leftChild]? leftChild + 1 : leftChild;
            largest = nums[largest] > nums[index] ? largest : index;
            if ( largest == index)
                break;
            swap(nums, largest, index);
            index = largest;
            leftChild = 2*index + 1;
        }

    }


    public void swap(int[] nums, int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
// @lc code=end

