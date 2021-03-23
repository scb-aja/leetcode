/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (51.91%)
 * Likes:    464
 * Dislikes: 0
 * Total Accepted:    180.7K
 * Total Submissions: 347.6K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
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
        if( head == null)
            return null;
        return deleteDuplicatesByRecur(head);
    }

    public ListNode deleteDuplicatesByIter(ListNode head){
        if( head == null)
            return null;
        ListNode end = head;
        ListNode current = head.next;
        while(current != null){
            if(current.val != end.val){
                end.next = current;
                end = current;
            }
            current = current.next;
        }
        end.next = null;
        return head;
    }

    public ListNode deleteDuplicatesByRecur(ListNode head){
        if(head.next == null ){
            return head;
        }
        //将head.next 以后链表去重
        ListNode res = deleteDuplicatesByRecur(head.next);
        if(res.val == head.val){
            return res;
        }else{
            head.next = res;
        }

        return head;
    }
}
// @lc code=end
