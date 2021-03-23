//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 
// 👍 47 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null){
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        List<ListNode> list = new ArrayList<>();
        TreeNode node = null;
        ListNode head = new ListNode(-1);
        ListNode end = head;
        queue.offer(tree);
        while (!queue.isEmpty()){
            node = queue.poll();
            ListNode listNode = new ListNode(node.val);
            end.next = listNode;
            end = listNode;
            if(node.left != null){
                helper.offer(node.left);
            }
            if(node.right != null){
                helper.offer(node.right);
            }
            if(queue.isEmpty()){
                Queue<TreeNode> temp = queue;
                queue = helper;
                helper = temp;
                list.add(head.next);
                head.next = null;
                end = head;
            }
        }
        ListNode[] result = new ListNode[list.size()];
        for(int index = 0; index < result.length; index++){
            result[index] = list.get(index);
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
