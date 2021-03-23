import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;



/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (33.52%)
 * Likes:    922
 * Dislikes: 0
 * Total Accepted:    221.9K
 * Total Submissions: 662K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
class Solution {
    public static class ReturnData{
        boolean isSearch; //是否是搜索二叉树
        List<Integer> inOrderList; //中序遍历的结果
        public ReturnData(boolean isSearch, List<Integer> list){
            this.isSearch = isSearch;
            this.inOrderList = list;
        }

    }

    public boolean isValidBST(TreeNode root) {
        //return isValidBSTByInorder(root);
        return isSearch(root).isSearch;
    }


    //非递归中序遍历 如果是递增顺序则 就是搜索二叉树
    public boolean isValidBSTByInorder(TreeNode root){
        if(root == null){
            return true;
        }
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            if(node!= null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                /**
                 * 判断是否是升序
                 */
                if( pre >= node.val){ 
                    return false;
                }else{
                    pre = (long)node.val;
                }
    
                node = node.right;
            }

        }

        //特殊处理case
        return true;
    }
    public  ReturnData isSearch(TreeNode node) {
        if (node == null) {
            return new ReturnData(true, null);
        }
        //得到左右子树是否是搜索二叉树
        ReturnData leftData = isSearch(node.left);
        ReturnData rightData = isSearch(node.right);
        //左右子树其中不是搜索二叉树 择 该结点的树也不是搜索二叉树
        if (!leftData.isSearch || !rightData.isSearch) {
            return new ReturnData(false, null);
        }
        //得到左右子树中序遍历结果
        List<Integer> leftList = leftData.inOrderList;
        List<Integer> rightList = rightData.inOrderList;
        //左子树中序遍历为空的境况下
        if (leftList == null) {
            //左右子树为空
            if (rightList == null) {
                List<Integer> list = new LinkedList<>();
                list.add(node.val);
                return new ReturnData(true, list);
            } else {
                //左空 右不空
                if (node.val >= rightList.get(0)) {
                    return new ReturnData(false, null);
                } else {
                    rightList.add(0, node.val);
                    return new ReturnData(true, rightList);
                }
            }
        } else {
            //左不空 右空
            if (rightList == null) {
                if(node.val <= leftList.get(leftList.size() - 1)){
                    return new ReturnData(false, null);
                }else{
                    leftList.add(node.val);
                    return new ReturnData(true, leftList);
                }
            } else {
                //左不空右不空
                int leftLast = leftList.get(leftList.size() - 1);
                int rightFirst = rightList.get(0);
                if (node.val <= leftLast || node.val >= rightFirst) {
                    return new ReturnData(false, null);
                }
                leftList.add(node.val);
                leftList.addAll(rightList);
                return new ReturnData(true, leftList);
            }
        }

    }

}
// @lc code=end

