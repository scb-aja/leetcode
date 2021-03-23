/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 *
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (55.99%)
 * Likes:    241
 * Dislikes: 0
 * Total Accepted:    19.6K
 * Total Submissions: 35K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * 
 * 示例 1：
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * 下面是两个重复的子树：
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * 和
 * 
 * ⁠   4
 * 
 * 
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
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
import java.util.Map;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preOrder(root);
        return list;
    }

    /**
     * 
     * 将每个子树先序序列序列化存在Map里面
     * key(序列化结果) val(出现的次数)
     */
    public String preOrder(TreeNode root){
        if(root == null){
            return "#";
        }
        String leftPre = preOrder(root.left);
        String rightPre = preOrder(root.right);
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(String.valueOf(root.val));
        sBuilder.append("!" + leftPre);
        sBuilder.append("!" + rightPre);
        String res = sBuilder.toString();
        map.put(res, map.getOrDefault(res, 0) + 1);
        if(map.get(res) == 2){
            list.add(root);
        }
        return res;
    }
}
// @lc code=end

