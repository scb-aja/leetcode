/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
 *
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 *
 * algorithms
 * Easy (68.90%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    14.8K
 * Total Submissions: 21.5K
 * Testcase Example:  '[1,0,1,0,1,0,1]'
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1
 * -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [0]
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
 * 示例 4：
 * 
 * 
 * 输入：root = [1,1]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的结点数介于 1 和 1000 之间。
 * Node.val 为 0 或 1 。
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
    
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        dfs(root, sum);
        return ans;
    }


    public void dfs(TreeNode root, int sum){
        if(root == null){
            return ;
        }
        sum = sum*2 + root.val;
        if(root.left == null && root.right == null){
            ans += sum;
        }else{
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    
       
    }
    public List<String> getRootToLeafPath(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> leftPaths = getRootToLeafPath(root.left);
        List<String> rightPaths = getRootToLeafPath(root.right);
        if (leftPaths == null && rightPaths == null) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(root.val));
            return list;
        } else if (leftPaths != null && rightPaths == null) {
            for (int index = 0; index < leftPaths.size(); index++) {
                leftPaths.set(index, root.val + leftPaths.get(index));
            }
            return leftPaths;
        } else if (leftPaths == null && rightPaths != null) {
            for (int index = 0; index < rightPaths.size(); index++) {
                rightPaths.set(index, root.val + rightPaths.get(index));
            }
            return rightPaths;
        } else {
            leftPaths.addAll(rightPaths);
            for (int index = 0; index < leftPaths.size(); index++) {
                leftPaths.set(index, root.val + leftPaths.get(index));
            }
            return leftPaths;
        }

    }

    public int getNumber(List<String> list) {
        if (list != null) {
            int res = 0;
            for (int index = 0; index < list.size(); index++) {
                String str = list.get(index);
                int len = str.length();
                for (int j = 0; j < len; j++) {
                    res += Integer.valueOf("" + str.charAt(len - 1 - j)) << j;

                }
            }
            return res;
        }
        return 0;
    }

}
// @lc code=end
