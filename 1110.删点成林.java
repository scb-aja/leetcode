import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1110 lang=java
 *
 * [1110] 删点成林
 *
 * https://leetcode-cn.com/problems/delete-nodes-and-return-forest/description/
 *
 * algorithms
 * Medium (61.55%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    7.5K
 * Total Submissions: 12.2K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n[3,5]'
 *
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * 
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * 
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
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
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<TreeNode> list;
    Set<Integer> set;
    public Set<TreeNode> oneNodeSet;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        oneNodeSet = new HashSet<>();
        set = new HashSet<>();
        list = new LinkedList<>();
        for (int num : to_delete) {
            set.add(num);
        }
        if(!set.contains(root.val)){
            list.add(root);
        }
    
        dfs(root, null);
        deleteOneNode();
        return list;
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        if(set.contains(root.val)){
            if(parent == null){
                oneNodeSet.add(root);
            }else{
                if(parent.left == root){
                    parent.left = null;
                }
                if(parent.right == root){
                    parent.right = null;
                }
            }
            if(root.left != null){
                list.add(root.left);
            }
            if(root.right != null){
                list.add(root.right);
            }
        }
        parent = set.contains(root.val) ? null : root;
        dfs(root.left, parent);
        dfs(root.right, parent);
    
    }

    public void deleteOneNode(){
        int index = 0;
        while(index < list.size() && !oneNodeSet.isEmpty()){
            if(oneNodeSet.contains(list.get(index))){
                oneNodeSet.remove(list.get(index));
                list.remove(index);
            }else{
                index++;
            }
        }
    
    }
}
// @lc code=end
