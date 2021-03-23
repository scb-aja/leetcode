import java.util.Stack;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (58.25%)
 * Likes:    331
 * Dislikes: 0
 * Total Accepted:    61.3K
 * Total Submissions: 105.1K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 
 * 
 * 进阶：
 * 
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if ( l1 == null && l2 == null)
            return null;
        
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(node1 != null){
            stack1.push(node1);
            node1 = node1.next;
        }
        while ( node2 != null){
            stack2.push(node2);
            node2 = node2.next;
        }

        //stack1 较长的  stack2较短的
        Stack<ListNode> temp = stack1;
        stack1 = stack2.size() > stack1.size() ? stack2 : stack1;
        stack2 = stack1 == temp ? stack2 : temp;
        int sum = 0;
        ListNode resultHead = new ListNode(1); //结果的头节点
        boolean isCarry = false;
        while(!stack2.isEmpty()){
            sum = stack1.pop().val + stack2.pop().val;
            if( isCarry){
                sum += 1;
            }
            //记录这次是否进位
            isCarry = (sum % 10) == sum ? false : true;
            ListNode node = new ListNode((sum % 10));
            //头插法
            node.next = resultHead.next;
            resultHead.next = node;
        }

        while(!stack1.isEmpty()){
            sum = stack1.pop().val;
            if ( isCarry){
                sum += 1;
            }
            isCarry = ( sum % 10) == sum ? false : true; // 判断这次是否进位
            ListNode node = new ListNode(( sum % 10));
            node.next = resultHead.next;
            resultHead.next = node;
        }
        if( isCarry){
            ListNode node = new ListNode(1);
            node.next = resultHead.next;
            resultHead.next = node;
        }
        return resultHead.next;
    }

}
// @lc code=end
