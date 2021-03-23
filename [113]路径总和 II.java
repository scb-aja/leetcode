//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 426 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathsList = new ArrayList<>();
        //base case
        if(root == null){
            return pathsList;
        }
        //base case
        if(root.left == null && root.right == null && root.val == targetSum){
            List<Integer> path = new LinkedList<>();
            path.add(root.val);
            pathsList.add(path);
            return pathsList;
        }
        //得到 左右子树 的路径
        List<List<Integer>> leftPathsList = pathSum(root.left, targetSum - root.val);
        List<List<Integer>> rightPathsList = pathSum(root.right, targetSum - root.val);
        for(List<Integer> list : leftPathsList){
            if(!list.isEmpty()){
                list.add(0, root.val);
            }
            pathsList.add(list);
        }

        for(List<Integer> list : rightPathsList){
            if(!list.isEmpty()){
                list.add(0, root.val);
            }
            pathsList.add(list);
        }

        return pathsList;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
