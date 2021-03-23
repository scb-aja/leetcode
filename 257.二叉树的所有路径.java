/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (66.57%)
 * Likes:    443
 * Dislikes: 0
 * Total Accepted:    96.5K
 * Total Submissions: 145K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
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
    List<String> pathsList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 得到左右子树到节点的路径
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        // 右size为0的时候 添加才不会成功 会为false
        boolean flag = leftPaths.addAll(rightPaths);
        if (flag) {
            for (int index = 0; index < leftPaths.size(); index++) {
                leftPaths.set(index, root.val + "->" + leftPaths.get(index));
            }
            return leftPaths;

        } else {
            if (leftPaths.size() == 0) {
                List<String> list = new ArrayList<>();
                list.add(root.val + "");
                return list;
            } else {
                for (int index = 0; index < leftPaths.size(); index++) {
                    leftPaths.set(index, root.val + "->" + leftPaths.get(index));
                }
                return leftPaths;

            }
        }

    }

    public void dfs(TreeNode root, String path){
        if(root == null){
            return;
        }
        path = path + root.val;
        if(root.left == null && root.right == null){
            pathsList.add(path);
        }else{
            path = path + "->";
            dfs(root.left, path);
            dfs(root.right, path);

        }


    }

}
// @lc code=end
