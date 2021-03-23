
/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.08%)
 * Likes:    396
 * Dislikes: 0
 * Total Accepted:    116K
 * Total Submissions: 203.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层序遍历如下：
 * 
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if( root == null){
            return resultList;
        }
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> helper = new Stack();
        TreeNode node = null;
        boolean isLeft = false; //从左是 true 从右开始 是false
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            if(isLeft){
                //下一层 从左开始
                if(node.right != null){
                    helper.push(node.right);
                }
                if(node.left != null){
                    helper.push(node.left);
                }

            }else{
                // 下一层从右开始
                if(node.left != null){
                    helper.push(node.left);
                }
                if(node.right != null){
                    helper.push(node.right);
                }
            }

            if( stack.isEmpty()){
                //更改下层遍历的顺序
                isLeft = !isLeft;
                //交换引用
                Stack<TreeNode> temp = stack;
                stack = helper;
                helper = temp;
                resultList.add(list);

                list = new ArrayList<>();
            }
        }

        return resultList;
    }

}
// @lc code=end

