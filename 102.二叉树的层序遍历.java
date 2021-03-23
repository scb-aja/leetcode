import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.01%)
 * Likes:    771
 * Dislikes: 0
 * Total Accepted:    251K
 * Total Submissions: 391.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层序遍历结果：
 * 
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if( root == null){
            return list;
        }else{
            TreeNode node = root;
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> help = new LinkedList<>();
            queue.offer(node);
            List<Integer> floorList = new ArrayList<>();
          
            while(!queue.isEmpty()){
                node = queue.poll();
                floorList.add(node.val);
                if( node.left != null){
                    help.offer(node.left);
                }
                if(node.right != null){
                    help.offer(node.right);
                }
                if( queue.isEmpty()){
                    //交换两个引用
                    Queue<TreeNode> temp = help;
                    help = queue;
                    queue = temp;
                    
                    list.add(floorList);
                    floorList = new ArrayList<>();
                }

            }

            return list;
        }
    }

 
}
// @lc code=end

