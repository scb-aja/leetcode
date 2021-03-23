/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (52.09%)
 * Likes:    665
 * Dislikes: 0
 * Total Accepted:    100.5K
 * Total Submissions: 192.6K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // return reverseBetweenByIter(head, m, n);
        if (head == null) {
            return null;
        }

        if (head.next == null)
            return head;
        return reverseBetweenRecu(head, m, n);
    }

    public ListNode reverseBetweenByIter(ListNode head, int m, int n) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        int position = 1;
        ListNode node = head;
        ListNode beforeInsert = null;
        while (node != null) {
            if (m == 1) {
                break;
            }
            // 反转以后的头节点应该插入到哪里
            if (m != 1 && (position + 1) == m) {
                beforeInsert = node;
                break;
            }

            node = node.next;
            position++;
        }
        ListNode pre = m == 1 ? node : node.next;
        ListNode reverseEnd = pre;
        ListNode reverseBegin = null;
        node = pre.next;
        position = m == 1 ? position + 1 : position + 2;
        // 要旋转的只有一个点
        if (position > n) {
            reverseBegin = pre;
        }
        while (node != null && position <= n) {
            if (position == n) {
                reverseBegin = node;
            }
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
            position++;

        }
        if (m == 1) {
            head = reverseBegin;
        } else {
            beforeInsert.next = reverseBegin;
        }

        reverseEnd.next = node;

        return head;
    }

    public static ListNode reverseBetweenRecu(ListNode head, int m, int n) {
        // 寻找插入点的起始位置
        int position = 1;
        ListNode node = head;
        ListNode beforeInsert = null;
        while (node != null) {
            if (m == 1) {
                break;
            }
            // 找到之前插入的位置
            if (position == (m - 1)) {
                beforeInsert = node;
                break;
            }
            position++;
            node = node.next;
        }
        // 得到要反转的第一个的位置
        node = m == 1 ? node : node.next;
        ListNode nodeEndNext = new ListNode(0); // 反转以后的链表 下一个位置
        ListNode nodeEnd = new ListNode(0); // 存反转以后头节点
        ListNode reverseEnd = reverseBetweenByRecu(node, nodeEnd, nodeEndNext, m, n);
        if (m == 1) {
            head = nodeEnd.next;
        } else {
            beforeInsert.next = nodeEnd.next;
        }
        reverseEnd.next = nodeEndNext.next;

        return head;
    }

    // 递归
    public static ListNode reverseBetweenByRecu(ListNode head, ListNode nodeEnd, ListNode nodeEndNext, int m, int n) {
        if (m == n) {
            nodeEndNext.next = head.next;
            nodeEnd.next = head;
            return head;
        }
        reverseBetweenByRecu(head.next, nodeEnd, nodeEndNext, m + 1, n).next = head;
        return head;
    }
}
// @lc code=end
