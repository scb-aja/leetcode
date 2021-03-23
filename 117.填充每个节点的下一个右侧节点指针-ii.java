import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (59.43%)
 * Likes:    366
 * Dislikes: 0
 * Total Accepted:    63.5K
 * Total Submissions: 106.8K
 * Testcase Example:  '[1,2,3,4,5,null,7]'
 *
 * 给定一个二叉树
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        
        if(root.left != null){
            if(root.right != null){
                /**
                 * 左右子树均不空
                 */
                root.left.next = root.right;
            }else{
                /**
                 * 左不空 右空的话
                 * 左树的next节点 就是根节点一路向右走 直到 其左节点和右节点又有个不空的节点
                 */
                root.left.next = nextNode(root.next);
            }
        }

        //处理右树的时候 就是根节点一路向右走 直到 其左节点和右节点又有个不空的节点
        if( root.right != null){
            root.right.next = nextNode(root.next);
        }

        //先右子树 后 左子树
        connect(root.right);
        connect(root.left);
        return root;

    }


    //一路向右找到有子节点的根节点
    public Node nextNode(Node node){
        if( node != null){
            while( node != null){
                if(node.left != null){
                    return node.left;
                }
                if(node.right != null){
                    return node.right;
                }
                node = node.next;
            }

        }
        return null;

    }


     

    public Node connectByLevel(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> helper = new LinkedList<>();
        queue.offer(root);
        Node node = null;
        Node helpEnd = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (helpEnd != null) {
                helpEnd.next = node;
                helpEnd = node;
            } else {
                helpEnd = node;
            }
            if (node.left != null) {
                helper.offer(node.left);
            }
            if (node.right != null) {
                helper.offer(node.right);
            }
            if (queue.isEmpty()) {
                Queue<Node> temp = queue;
                queue = helper;
                helper = temp;
                helpEnd = null;
            }
        }
        return root;

    }

}
// @lc code=end
