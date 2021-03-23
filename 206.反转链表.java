/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (71.31%)
 * Likes:    1486
 * Dislikes: 0
 * Total Accepted:    426.6K
 * Total Submissions: 597.8K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // return reverseListByIter(head);
        if (head == null)
            return null;
        ListNode reverseHead = new ListNode(0) ;
        ListNode temp = reverseListByRecu(head, reverseHead);
        temp.next = null;
        return reverseHead.next;
    }

    public ListNode reverseListByIter(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            // 处理最后一步
            if (temp == null)
                break;
            current = temp;
        }
        return current;
    }

    /***
     * 
     * 
     * @param head
     * @param reverseHead 存放反转过后的头节点
     * @return
     */
    public ListNode reverseListByRecu(ListNode head, ListNode reverseHead) {
        if (head.next == null) {
            reverseHead.next = head;
            return head;
        }

        ListNode pre = head.next;
        reverseListByRecu(pre, reverseHead).next = head;
        return head;
    }

}
// @lc code=end
