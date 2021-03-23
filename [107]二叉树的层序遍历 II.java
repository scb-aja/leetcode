//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 410 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        lob(root, 0);
        Collections.reverse(resultList);
        return resultList;
    }
    public void lob(TreeNode root, int level){
        if(root == null){
            return;
        }
        int len = resultList.size();
        if(level >= len){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            resultList.add(list);
        }else{
            resultList.get(level).add(root.val);
        }
        lob(root.left, level + 1);
        lob(root.right, level + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
