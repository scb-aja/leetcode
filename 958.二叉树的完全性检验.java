import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
 *
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (51.39%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    12.3K
 * Total Submissions: 24K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 
 * 百度百科中对完全二叉树的定义如下：
 * 
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h
 * 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2^h 个节点。）
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中将会有 1 到 100 个结点。
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
    public boolean isCompleteTree(TreeNode root) {
        /**
         * 如何判断是否是完全二叉树呢
         *  1. 如果一个节点没有左子树 有右子树 则 一定不是完全二叉树 
         *  2. 如果一个节点有左子树 没有右子树 或者 左右子树均没有
         *      从这个节点以后均是叶子节点 则他是完全二叉树
         */
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.offer(node);
        //第二个规则是否满足 满足的话 剩下的节点只需要判断是否都是叶子节点就可以
        boolean flag = false; 
        while(!queue.isEmpty()){
            node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            //左孩子空 右孩子不空
            if(!flag && left == null && right != null){
                return false;
            }
            
            //在满足第二个规则以后 如果不是叶节点则 就不是完全二叉树 
            if(flag && (left != null || right != null)){
                return false;
            }
             
            /**
             * 第二个条件 如果一个节点有左子树 没有右子树 或者 左右子树均没有
                从这个节点以后均是叶子节点 则他是完全二叉树
             */
            if(!flag && ((left != null && right == null) || (left == null && right == null))){
                flag = true;
            }
            if(left != null){
                queue.offer(left);
            }
            if(right != null){
                queue.offer(right);
            }
        }
    
        return true;
    
    
    }
}
// @leetcode
