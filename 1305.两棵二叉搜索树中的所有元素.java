/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
 *
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/description/
 *
 * algorithms
 * Medium (74.34%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    11.6K
 * Total Submissions: 15.6K
 * Testcase Example:  '[2,1,4]\r\n[1,0,3]\r'
 *
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 
 * 
 * 示例 2：
 * 
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 * 
 * 
 * 示例 3：
 * 
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 * 
 * 
 * 示例 4：
 * 
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 每棵树最多有 5000 个节点。
 * 每个节点的值在 [-10^5, 10^5] 之间。
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
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();     
        List<Integer> root2List = new ArrayList<>();     
        //得到两个中序遍历
        inOrder(root1, root1List);
        inOrder(root2, root2List);
        //merge
        return merge(root1List, root2List);
    }

    public void inOrder(TreeNode root1, List<Integer> list){
        if(root1 == null){
            return;
        }
        inOrder(root1.left, list);
        list.add(root1.val);
        inOrder(root1.right, list);
    }
   
    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int len1 = list1.size();
        int len2 = list2.size();
        while((index1 < len1) && (index2 < len2)){
            if(list1.get(index1) < list2.get(index2)){
                result.add(list1.get(index1));
                index1++;
            }else{
                result.add(list2.get(index2));
                index2++;
            }
        }
        while(index1 < len1){
            result.add(list1.get(index1));
            index1++;
        }
        while(index2 < len2){
            result.add(list2.get(index2));
            index2++;
        }
        return result;
    }

}
// @lc code=end

