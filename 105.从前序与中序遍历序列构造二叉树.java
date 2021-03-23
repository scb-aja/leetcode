/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.34%)
 * Likes:    944
 * Dislikes: 0
 * Total Accepted:    168.6K
 * Total Submissions: 242.8K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, Integer> map;
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.map = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    //子树的中序遍历和先序遍历的节点数目是一样的
    public TreeNode buildTree(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if(preorderLeft > preorderRight){
            return null;
        }
        //得到 中序遍历的索引位置
        int index = map.get(this.preorder[preorderLeft]);
        TreeNode node = new TreeNode(this.preorder[preorderLeft]);
        //左子树的中序遍历的节点数
        int left_subTree = index - inorderLeft;
        node.left = buildTree(preorderLeft + 1, preorderLeft + left_subTree, inorderLeft, index - 1);
        node.right = buildTree(preorderLeft + left_subTree + 1, preorderRight, index + 1, inorderRight) ;
        return node;
    }
}
// @lc code=end
