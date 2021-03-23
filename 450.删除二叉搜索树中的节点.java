/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 *
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (46.33%)
 * Likes:    408
 * Dislikes: 0
 * Total Accepted:    35.5K
 * Total Submissions: 76.6K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key
 * 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 
 * 一般来说，删除节点可分为两个步骤：
 * 
 * 
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 
 * 
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * 
 * 示例:
 * 
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 * 
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    class Node {
        TreeNode node;
        Node left;
        Node right;
        Node parent;

        public Node(TreeNode node) {
            this.node = node;
        }
    }

    Node head = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        makeBSTClew(root, null);
        Node keyNode = getKeyNode(head, key);
        // 没找到
        if (keyNode == null) {
            return root;
        }
        /**
         * 制造头节点 方便不用判断
         * 
         */
        Node tempNode = new Node(new TreeNode(-1));
        tempNode.left = head;
        head.parent = tempNode;
        tempNode.node.left = head.node;
        // 前驱 和 后继
        Node preNode = findPreNode(keyNode);
        Node postNode = findPreNode(keyNode);
        // 既没有前驱 也没有后继 只存在删除的节点
        if (preNode == null && postNode == null) {
            return null;
        }
        // 叶子节点
        if (keyNode.left == null && keyNode.right == null) {
            if (keyNode.parent.left == keyNode) {
                keyNode.parent.node.left = null;
            }
            if (keyNode.parent.right == keyNode) {
                keyNode.parent.node.right = null;

            }
        }
        /**
         * 如果有前驱 若有左子树 左子树的最右边的节点, 最右边的节点可以是叶节点 或者是 存在左子树的节点 没有左子树 则 就是祖父节点
         */
        if (keyNode.left != null && preNode != null) {
            // 先把前驱节点父亲节点指向为空
            if (preNode.parent.left == preNode) {
                preNode.parent.left = null;
                preNode.parent.node.left = null;
            }
            if (preNode.parent.right == preNode) {
                preNode.parent.right = null;
                preNode.parent.node.right = null;
            }
            // 替换当前节点
            if (keyNode.parent.left == keyNode) {
                keyNode.parent.left = preNode;
                keyNode.parent.node.left = preNode.node;
            }
            if (keyNode.parent.left == keyNode) {
                keyNode.parent.right = keyNode;
                keyNode.parent.node.right = keyNode.node;
            }
            // 合并剩余的节点 合并右树
            preNode.right = keyNode.right;
            preNode.node.right = keyNode.node.right;
            // 合并左树
            while (preNode != null && preNode.left != null) {
                preNode = preNode.left;
            }

            preNode.left = keyNode.left;
            preNode.node.left = keyNode.node.left;
        } else if (keyNode.left == null && preNode != null) {
           
        
        
        
        }

    }

    public void makeBSTClew(TreeNode root, Node parent) {
        if (root == null) {
            return;
        }
        Node node = new Node(root);
        if (parent == null) {
            head = node;
        }
        if (parent != null && parent.node != null && parent.node.left == root) {
            parent.left = node;
        }
        if (parent != null && parent.node != null && parent.node.right == root) {
            parent.right = node;
        }
        node.parent = parent;
        makeBSTClew(root.left, node);
        makeBSTClew(root.right, node);

    }

    // 如何找到一个节点的前驱节点
    public Node findPreNode(Node node) {
        // 找到该节点的前驱
        if (node.left != null) {
            // 如果有左子树 左子树最右边的节点就是前驱节点
            node = node.left;
            while (node != null && node.right != null) {
                node = node.right;
            }
            return node;
        } else {
            /**
             * 没有左子树 找到第一个祖父节点 该节点在祖父节点的右子树上
             */
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // 后继节点
    public Node findPostNode(Node node) {
        if (node.right != null) {
            // 如果有右子树 则右子树最左边的节点就是后继借鉴
            node = node.right;
            while (node != null && node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            /**
             * 没有左子树 找到第一个祖父节点 该节点在祖父节点的左子树上
             */
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public Node getKeyNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.node.val == key) {
            return root;
        } else if (root.node.val > key) {
            return getKeyNode(root.left, key);
        } else {
            return getKeyNode(root.right, key);
        }

    }
}
// @lc code=end
