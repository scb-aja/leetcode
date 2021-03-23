import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
 *
 * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/description/
 *
 * algorithms
 * Medium (57.96%)
 * Likes:    139
 * Dislikes: 0
 * Total Accepted:    15K
 * Total Submissions: 25.9K
 * Testcase Example:  '[2,1,5]'
 *
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * 
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是
 * node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的
 * j，那么下一个更大值为 0 。
 * 
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * 
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5
 * 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 
 * 
 * 示例 2：
 * 
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 
 * 
 * 示例 3：
 * 
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        /***
         * 使用单调栈
         * 单调栈内的元素具有单调性
         * 可能是递增递减 
         * 每次入栈 都得重新做调整使栈满足单调
         */
        
        //从栈底到栈顶一次递减
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        //将节点值存入到list里面
        while( node != null){
            list.add(node.val);
            node = node.next;
        }
        int len = list.size();
        int[] results = new int[len];
        //设计递减栈 并且维护  list.get(index)是递减的
        for( int index = 0; index < len; index++){
            int num = list.get(index);
            /**
             * 一次弹出index对应的list.get(index) 小于num
             * 并且更新results[index] = num;
             * 相当于给你一个数 找出左边都小于这个数
             * 
             */
            while(!stack.isEmpty() && list.get(stack.peek())< num){
                results[stack.pop()] = num;
            }
            stack.push(index);
        }

        return results;

    }
}
// @lc code=end

