import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * algorithms
 * Medium (68.83%)
 * Likes:    400
 * Dislikes: 0
 * Total Accepted:    99.1K
 * Total Submissions: 144K
 * Testcase Example:  '[1,2,3,4,5,6,7]'
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * 
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
 * 
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B
 * 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数量少于 4096
 * -1000 
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
        if(root.left == null && root.right == null){
            return root;
        }
        Node leftNode = connect(root.left);  //左子树连接好
        Node rightNode = connect(root.right); // 右子树连接好
        Node left = leftNode;
        Node right = rightNode;
        //左子树和右子树之间的缝隙也连接好
        while(left != null && right != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        return root;
    }

    /**
     * 层次遍历
     * 
     */
    public Node connectByLevel(Node root){
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> helper = new LinkedList<>();
        queue.offer(root);
        Node node = null;
        Node helpEnd = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if( helpEnd != null){
                helpEnd.next = node;
                helpEnd = node;
            }else{
                helpEnd = node;
            }
            if(node.left != null){
                helper.offer(node.left);
            }
            if(node.right != null){
                helper.offer(node.right);
            }
            if(queue.isEmpty()){
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

