import java.util.Stack;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (39.38%)
 * Likes:    5583
 * Dislikes: 0
 * Total Accepted:    699.7K
 * Total Submissions: 1.8M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 
 * 题目数据保证列表表示的数字不含前导零
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 == null && l2 == null){
            return null;
        }
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode resultEnd = new ListNode(0);
        ListNode resultHead = resultEnd;
        boolean isCarry = false;
        int sum = 0;
        while(node1 != null && node2!=null){
            sum = node1.val + node2.val;
            //看看上次是否有进位
            if( isCarry){
                sum +=1;
            }
            //记录这次是否有进位
            isCarry = (sum % 10) == sum ? false : true; 
            node1.val = (sum % 10);
            resultEnd.next = node1;
            resultEnd = node1;
            node1 = node1.next;
            node2 = node2.next;
        }

        while(node1 != null){
            sum = node1.val;
            if(isCarry){
                sum += 1;
            }
            isCarry = (sum % 10) == sum ? false : true;
            node1.val = (sum % 10);
            resultEnd.next = node1;
            resultEnd = node1;
            node1 = node1.next;
        }
        while(node2 != null){
            sum = node2.val;
            if(isCarry){
                sum += 1;
            }
            isCarry = (sum % 10) == sum ? false : true;
            node2.val = (sum % 10);
            resultEnd.next = node2;
            resultEnd = node2;
            node2 = node2.next;
        }

        if( isCarry){
            ListNode node = new ListNode(1);
            resultEnd.next = node;
            resultEnd = node;
        }
        return resultHead.next;
    }
}
// @lc code=end
