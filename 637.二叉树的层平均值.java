
/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 *
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (68.76%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    55.9K
 * Total Submissions: 81.3K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 节点值的范围在32位有符号整数范围内。
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

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> levelsCounts = new ArrayList<>(); //每层 节点个数
        List<Double> levelsSum = new ArrayList<>(); // 每层节点的总和
        average(root, 0, levelsCounts, levelsSum);
        //计算平均值
        for(int index = 0; index < levelsSum.size(); index++){
            double avg = levelsSum.get(index) / levelsCounts.get(index);
            levelsSum.set(index, avg);
        }
        return levelsSum;
    }
    public void average(TreeNode root, int level, List<Integer> levelsCounts, List<Double> levelsSum){
        if(root == null){
            return ;
        }
        //当前遍历到的层数
        int len = levelsCounts.size();
        //当前层数还没有遍历
        if( level >= len){
            levelsCounts.add(1);
            levelsSum.add(1.0*root.val);
        }else{
            //当前层数已经遍历到了 当前层数的节点数 ++
            levelsCounts.set(level, levelsCounts.get(level) + 1);
            //当前的节点 加入到当前层数节点和里面
            levelsSum.set(level, root.val + levelsSum.get(level));
        }
        average(root.left, level + 1, levelsCounts, levelsSum);
        average(root.right, level + 1, levelsCounts, levelsSum);
    }


}
// @lc code=end

