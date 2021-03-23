/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 *
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (54.21%)
 * Likes:    245
 * Dislikes: 0
 * Total Accepted:    11.1K
 * Total Submissions: 20.4K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * 
 * 
 * 
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
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
    public List<Integer> resultList = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        find(root, target, K);
        return resultList;
    }

    public void find(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) {
            return;
        }
        if (root == target) {
            findWayExceptTarget(root, k, 0);
        } else {
            // 看左子树 和 右子树 哪个包含target
            int leftDistance = distance(root.left, target);
            int rightDistance = distance(root.right, target);
            // System.out.println("left :" + leftDistance);
            // System.out.println("right :" + rightDistance);
            //左树包含target
            if(leftDistance != -1){
                if((leftDistance + 1) == k){
                    resultList.add(root.val);
                }
    
                findWayExceptTarget(root.right, k, leftDistance + 2);
                find(root.left, target, k);
            }
            //右数包含target
            if(rightDistance != -1){
                if((rightDistance + 1) == k){
                    resultList.add(root.val);
                }    
                findWayExceptTarget(root.left, k, rightDistance + 2);
                find(root.right, target, k);
            }
        
        }

    }

    /**
     * 
     * 找不包含target的树 中的节点到target的路径
     *
     */
    public void findWayExceptTarget(TreeNode root, int k, int front) {
        if (root == null || front > k) {
            return;
        }
        if (front == k) {
            resultList.add(root.val);
        } else {
            findWayExceptTarget(root.left, k, front + 1);
            findWayExceptTarget(root.right, k, front + 1);
        }
    }

    /**
     * root 与 target 的 距离 没找到返回 -1
     */
    public int distance(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return 0;
        }
        int leftDis = distance(root.left, target);
        int rightDis = distance(root.right, target);
        if (leftDis == -1 && rightDis == -1) {
            return -1;
        } else {
            return leftDis == -1 ? rightDis + 1 : leftDis + 1;
        }
    }

}
// @lc code=end
