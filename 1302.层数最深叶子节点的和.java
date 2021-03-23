/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] 层数最深叶子节点的和
 *
 * https://leetcode-cn.com/problems/deepest-leaves-sum/description/
 *
 * algorithms
 * Medium (81.19%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 17.2K
 * Testcase Example:  '[1,2,3,4,5,null,6,7,null,null,null,null,8]'
 *
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        return getDeepestLeavesSum(root).leafSum;

    }

    public static class ReturnData {
        int mostHeight;
        int leafSum;

        public ReturnData(int mostHeight, int leafSum) {
            this.mostHeight = mostHeight;
            this.leafSum = leafSum;
        }
    }

    public ReturnData getDeepestLeavesSum(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }
        // 得到左子树 右子树的信息
        ReturnData leftData = getDeepestLeavesSum(root.left);
        ReturnData rightData = getDeepestLeavesSum(root.right);
        // 看左右子树 哪个高度高
        if (leftData.mostHeight > rightData.mostHeight) {
            return new ReturnData(leftData.mostHeight + 1, leftData.leafSum);
        }
        if (leftData.mostHeight < rightData.mostHeight) {
            return new ReturnData(rightData.mostHeight + 1, rightData.leafSum);
        }
        // 如果是叶子得返回当前叶子的值
        if (leftData.mostHeight == 0 && rightData.mostHeight == 0) {
            return new ReturnData(1, root.val);
        }

        // 一样高的话
        return new ReturnData(rightData.mostHeight + 1, rightData.leafSum + leftData.leafSum);
    }

}
// @lc code=end
