import java.util.Stack;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (68.98%)
 * Likes:    807
 * Dislikes: 0
 * Total Accepted:    219.3K
 * Total Submissions: 317.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 
 * 
 * 
 * 
 * 
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swapPairsByRecu(head);
    }

    /**
     * 迭代方法
     * @param head
     * @return
    */
    public ListNode swapPairsByStack(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        ListNode resultHead = new ListNode(-1);
        /**
         * 偶数节点全存里面 奇数节点的话 node会指向剩一个的节点
         */

        // 一个地方存两个节点
        while (node != null && node.next != null) {
            stack.push(node);
            node = node.next.next;
        }
        boolean isOneNode = node == null ? false : true;
        ListNode temp = null;
        ListNode tempNext = null;
        while (!stack.isEmpty()) {
            /**
             * swap
             */
            temp = stack.pop();
            tempNext = temp.next;
            tempNext.next = temp;
            /**
             * 是否是还有个节点没压入栈里面
             */
            if (isOneNode) {
                temp.next = node;
                temp = node;
                isOneNode = false;
            }
            // 头插法
            temp.next = resultHead.next;
            resultHead.next = tempNext;
        }
        return resultHead.next;

    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairsByRecu(ListNode head){
        /***
         * head == null 是偶数节点
         * head.next == null 奇数节点
         */
        if(head == null || head.next == null){
            return head;
        }

        ListNode result = swapPairs(head.next.next);
        ListNode temp = head;
        ListNode tempNext = head.next;
        tempNext.next = temp;
        temp.next = result;
        return tempNext;
    }
}   
// @lc code=end
