import java.lang.annotation.Target;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (64.70%)
 * Likes:    874
 * Dislikes: 0
 * Total Accepted:    254.3K
 * Total Submissions: 392.9K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        for( int index = 0; index < nums.length; index++){
            heapInsert(nums, index);
        }
        int len = nums.length - 1;
        int res = 0;
        for( int i = 1; i <= k; i++){
            res = nums[0];
            swap(nums, 0, len);
            heapfy(nums, --len, 0);
        }
        return res;
    }

    /**
     * 大根堆
     * 
     */
    public void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    /**
     * 
     * @param nums
     * @param len  heap 长度
     * @param k    第k个节点发生了变化 以k父节点调整大根堆
     */
    public void heapfy(int[] nums, int len, int k) {
        int leftChild = 2 * k + 1;
        while (leftChild < len) {
            int largest = (leftChild + 1) < len && nums[leftChild + 1] > nums[leftChild] ? leftChild + 1 : leftChild;
            largest = nums[largest] > nums[k] ? largest : k;
            //最大的就是本身 不用向下换
            if ( largest == k){
                break;
            }
            swap(nums, largest, k);
            k = largest;
            leftChild = 2*k + 1;
        }

    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
// @lc code=end
