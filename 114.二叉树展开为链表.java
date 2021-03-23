
/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (71.81%)
 * Likes:    730
 * Dislikes: 0
 * Total Accepted:    112.1K
 * Total Submissions: 156K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
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
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 2000] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
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
import java.util.Stack;



class Solution {
    public static class ReturnData{
        TreeNode head;
        TreeNode end;
        public ReturnData(TreeNode head, TreeNode end){
            this.head = head;
            this.end = end;
        }
    }


    public void flatten(TreeNode root) { 
        if(root == null){
            return;
        }
        
        traverse(root);
    }

  
    public ReturnData traverse(TreeNode node){
        if( node == null){
            return new ReturnData(null, null);
        }
        //得到反转后的左右子树信息
        ReturnData leftData =  traverse(node.left);
        ReturnData rightData = traverse(node.right);

        //左右子树 没有
        if( leftData.head == null && rightData.head == null){
            return new ReturnData(node, node);
        }
        
        //左子树没有
        if(leftData.head == null){
            node.right = rightData.head;
            node.left = null;
            return new ReturnData(node, rightData.end);
        }
        //右子树没有
        if(rightData.head == null){
            node.right = leftData.head;
            node.left = null;
            return new ReturnData(node, leftData.end);
        }

        //左右子树都有
        node.right = leftData.head;
        node.left = null;
        leftData.end.right = rightData.head;
        return new ReturnData(node, rightData.end);
    }




    //先序遍历 非递归
    public void preOrder(TreeNode root){
        if( root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); 
        TreeNode node = null;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode end = new TreeNode(1);
        while(!stack.isEmpty()){
            node = stack.pop();
            left = node.left;
            right = node.right;
            end.right = node;
            end = node;
            end.left = null;
            if(right != null){
                stack.push(right);
            }
            if(left != null){
                stack.push(left);
            }

        }        
    
    }

}
// @lc code=end

