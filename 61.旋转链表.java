import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (40.61%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    111.7K
 * Total Submissions: 274.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null)
            return null;
        if( head.next == null)
            return head;
        ListNode resultHead = null;
        ListNode resultEnd = null;
        ListNode node = head;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
    
        node = head;
        //找出旋转后的head 和 end
        for( int index = 0; index < len ; index++){
            if( (index + k) % len == 0){
                resultHead = node;
            }

            if( (index + k) % len == ( len - 1)){
                resultEnd = node;
            }
           
            //将原先的链表连城环 
           if( index == ( len - 1)){
               node.next = head;
               break;
            }
           node = node.next;
        }

        /***
         * 找出 旋转后的head 和 end 之间切一刀 
         * 就是新的结果
         * 在 end 和 head切一刀
         */
        resultEnd.next = null;
        return resultHead;


    }

    public ListNode rotateRightByHash(ListNode head, int k){
        if( head == null)
        return null;
    int count = 0;
    ListNode node = head;
    //得到链表的长度
    while(node != null){
        count++;
        node = node.next;
    }
    
    
    Map<Integer, ListNode> map = new HashMap<>();
    node = head;
    //建立对应关系 新位置-->node 的关系
    for( int index = 0; index < count; index++){
        map.put((index + k) % count, node); 
        node = node.next;
    }
    ListNode resultEnd = new ListNode(-1);
    ListNode resultHead = resultEnd;
    ListNode temp = null;
    for(int index = 0; index < count; index ++){
        temp = map.get(index);
        //尾插法
        resultEnd.next = temp;
        resultEnd = temp;
    }
    resultEnd.next = null;
    return resultHead.next;
    }
}
// @lc code=end

