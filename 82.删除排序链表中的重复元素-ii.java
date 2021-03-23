/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (50.08%)
 * Likes:    447
 * Dislikes: 0
 * Total Accepted:    84.7K
 * Total Submissions: 168.6K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode resultHead = new ListNode(0);// 头节点
        ListNode resultEndPre = resultHead; //尾节点的前一个
        resultEndPre.next = head;
        ListNode current = head.next; //当前遍历的节点
        ListNode resultEnd = null;
        boolean isRepeat = false; // 判断end节点是否有重复节点
        while (current != null) {
            resultEnd = resultEndPre.next; //得到end节点
            if (current.val != resultEnd.val) {
                if (!isRepeat) { //end节点没有重复节点
                    resultEnd.next = current;
                    resultEndPre = resultEnd;
                }else{
                    resultEndPre.next = current;
                    isRepeat = false; //设置当前end节点是否是重复元素
                }
            }else{
                isRepeat = true;
            }
            current = current.next;
        }

        //最后也得判断一下 例如[*****1,1]
        if(isRepeat){
            resultEndPre.next = null;
        }else{
            resultEndPre.next.next = null;
        }
        
        return resultHead.next;
    }
}
// @lc code=end
