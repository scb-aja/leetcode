import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (59.49%)
 * Likes:    515
 * Dislikes: 0
 * Total Accepted:    79.6K
 * Total Submissions: 133.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while( node!= null){
            list.add(node);
            node = node.next;
        }
        int begin = 0;
        int end = list.size() - 1;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode resultHead = new ListNode(-1);
        ListNode resultEnd = resultHead;
        while( begin < end){
            node1 = list.get(begin);
            node2 = list.get(end);
            node1.next = node2;
            resultEnd.next = node1;
            resultEnd = node2;
            begin++;
            end--;
        }

        //奇数节点
        if( begin == end){
            resultEnd.next = list.get(begin);
            resultEnd = resultEnd.next;
        }

        //处理下尾节点
        resultEnd.next = null;
        head = resultHead.next;
    }
}
// @lc code=end

