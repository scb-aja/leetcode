import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 *
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (59.66%)
 * Likes:    482
 * Dislikes: 0
 * Total Accepted:    59.2K
 * Total Submissions: 98.9K
 * Testcase Example:  '[[7,null],[13,0],[11,4],[10,2],[1,0]]'
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 
 * 要求返回这个链表的 深拷贝。 
 * 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * 
 * 
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 
 * 
 * 示例 4：
 * 
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * 
 * 
 */

import org.w3c.dom.Node;

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        //return copyRandomListByHash(head);
        return copyRandomListByNoExtra(head);
    }

    /***
     * 用 map 存放 原Node 和 copy Node 一一对应关系 例子： 1---> 1~ 2---> 2~ 3---> 3~
     * 
     * @param head
     * @return
     */
    public Node copyRandomListByHash(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        /*
         * 建立 node----copyNode 的对应关系
         */
        while (node != null) {
            Node copyNode = new Node(node.val);
            map.put(node, copyNode);
            node = node.next;
        }

        /**
         * 为 copyNode 建立对应的关系
         */

        node = head;
        while (node != null) {
            Node currentCopyNode = map.get(node);
            Node curretCopyNextNode = map.get(node.next);
            Node currentCopyRandomNode = map.get(node.random);
            currentCopyNode.next = curretCopyNextNode;
            currentCopyNode.random = currentCopyRandomNode;
            node = node.next;
        }

        return map.get(head);
    }

    /**
     * 不使用额外空间
     * 自己做了一个映射的关系 node--->copyNode 很快能找到对应的copyNode
     * node1-->copyNode1-->node2-->copyNode2...
     * @param head
     * @return
     */
    public  Node copyRandomListByNoExtra(Node head){
        Node node = head;
        //copy 链表
        while(node != null){
            Node copyNode = new Node(node.val);
            Node nodeNext = node.next;
            copyNode.next = nodeNext;
            node.next = copyNode;
            node = nodeNext;
        }
        //copyNode 建立 random
        node = head;
        while(node != null){
            Node copyNode = node.next;
            Node nodeNext = copyNode.next;
            copyNode.random = node.random == null ? null: node.random.next;
            node = nodeNext;
        }
        // 将copyNode 和原先node分开
        node = head;
        Node copyNodeHead = head.next;
        Node  copyNode = head.next;
        while(node != null){
            Node nodeNext = copyNode.next;
            Node copyNodeNext = nodeNext == null ? null : nodeNext.next;
            copyNode.next = copyNodeNext;
            node.next = nodeNext;
            node = nodeNext;
            copyNode = copyNodeNext;
        }

        return copyNodeHead;
    }
}
// @lc code=end
