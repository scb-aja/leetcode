/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (64.94%)
 * Likes:    412
 * Dislikes: 0
 * Total Accepted:    86.6K
 * Total Submissions: 133.3K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
import java.util.List;
import java.util.ArrayList;
class Solution {
    public static class ReturnData{
        int height;
        List<Integer> list ;

        public ReturnData(int height, List<Integer> list) {
            this.height = height;
            this.list = list;
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        ReturnData result  = rightSide(root);
        return result.list == null ? new ArrayList<Integer>() : result.list; 
    }

    public  ReturnData rightSide(TreeNode root){
        if(root == null){
            return new ReturnData(0, null);
        }

        ReturnData leftData = rightSide(root.left);
        ReturnData rightData = rightSide(root.right);
        //左右子树都为空 能从右侧看到的 只有是头节点
        if( leftData.list == null && rightData.list == null){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            return new ReturnData(0,list);
        }
        //左子树为空 右子树所看到的右侧不为空 能从右侧看到的 头节点 + 右侧子树看到的节点
        if(leftData.list == null && rightData.list != null){
            rightData.list.add(0, root.val);
            return new ReturnData(rightData.height + 1, rightData.list);
        }
        //左子树所看到的右侧不为空 右子树所看到的右侧为空 则 从右侧看到的就是 头节点 + 左子树所看到的右侧;
        if(leftData.list != null && rightData.list == null){
            leftData.list.add(0, root.val);
            return new ReturnData(leftData.height + 1, leftData.list);
        }
        //左子树看到的右侧 和 右子树看到的右侧
        //右侧高度 大于= 左侧高度 从右侧看到的就是 右数所看到的节点 + 头节点
        if( rightData.height >= leftData.height){
            rightData.list.add(0, root.val);
            return new ReturnData(rightData.height + 1, rightData.list);
        }else{
            /**
             * 右侧高度小于左侧高度 开始整合
             * 先把重叠部分的高度 的右子树所能看到的右侧写入
             * 再把剩下的左子树从右侧看到的再写入 
             */
            List<Integer> currentList = new ArrayList<>();
            currentList.add(root.val);
            for(int index = 0; index <= rightData.height; index++){
                currentList.add(rightData.list.get(index));
            }
            for( int j = rightData.height + 1; j <= leftData.height; j++){
                currentList.add(leftData.list.get(j));
            }
            return new ReturnData(leftData.height + 1, currentList);
        }

    }   
}
// @lc code=end

