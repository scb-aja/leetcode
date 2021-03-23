import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (69.00%)
 * Likes:    513
 * Dislikes: 0
 * Total Accepted:    259K
 * Total Submissions: 375K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //preorder(root, list);
        preorderByStack(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list){
        if( root == null){
            return ;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void preorderByStack(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        if( root != null){
            stack.push(root);
            while( !stack.isEmpty()){
                node = stack.pop();
                if( node != null){
                    list.add(node.val);
                    if( node.right != null){
                        stack.push(node.right);
                    }
                    if( node.left != null){
                        stack.push(node.left);
                    }
                }
            }

        }


    }
}
// @lc code=end

