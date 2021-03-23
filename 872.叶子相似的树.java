import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
 *
 * https://leetcode-cn.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (62.75%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    23.7K
 * Total Submissions: 37.8K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n' +
  '[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 
 * 
 * 
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 =
 * [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 
 * 
 * 示例 4：
 * 
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 
 * 
 * 示例 5：
 * 
 * 
 * 
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
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
    public Queue<Integer> leafQue;
    public boolean isSame;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        isSame = true;
        leafQue = new LinkedList<Integer>();
        dfs(root1);
        isSimilar(root2);
        if(isSame){
            isSame = (leafQue.isEmpty());
        }
        return isSame;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            leafQue.offer(root.val);
        }else{
            dfs(root.left);
            dfs(root.right);
        }   
    
    }

    public void isSimilar(TreeNode root){
        if(root == null || !isSame){
            return;
        }
        if(leafQue.isEmpty()){
            isSame = false;
            return;
        }
        if(root.left == null && root.right == null){
            int num = leafQue.poll();
            if( root.val != num){
                isSame = false;
                return;
            }
        }else{
            isSimilar(root.left);
            isSimilar(root.right);
        }
    
    }
}
// @lc code=end

