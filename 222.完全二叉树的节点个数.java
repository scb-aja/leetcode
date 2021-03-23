import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 *
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (76.82%)
 * Likes:    434
 * Dislikes: 0
 * Total Accepted:    78.8K
 * Total Submissions: 102.6K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 
 * 完全二叉树
 * 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h
 * 层，则该层包含 1~ 2^h 个节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 
 * 题目数据保证输入的树是 完全二叉树
 * 
 * 
 * 
 * 
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
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
    /**
     * 如何求一个完全二叉树的节点数呢
     * 完全二叉树可以这么理解
     * 由满二叉树 和一个完全二叉树组成
     * 
     * 
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        //左子树的节点高度
        int leftLevel = leftMostLevel(root.left);
        //右子树的节点高度
        int rightLevel = leftMostLevel(root.right);
        //左子树是满二叉树
        if(leftLevel == rightLevel){
            int res = (1 << leftLevel) + countNodes(root.right);
            return res;
        }else{
            //右子树是满二叉树
            int res = (1 << rightLevel) + countNodes(root.left);
            return res;

        }
    }

    //得到树的最大深度  currentLevel 当前节点的层数     
    // 则当前节点的高度
    public int leftMostLevel(TreeNode node){
          int level = 0;
          while(node != null){
              level++;
              node = node.left;
          }
          return level;
    }

   


}
// @lc code=end

