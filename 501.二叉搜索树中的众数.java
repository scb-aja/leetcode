
/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (50.06%)
 * Likes:    278
 * Dislikes: 0
 * Total Accepted:    48.9K
 * Total Submissions: 97.8K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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

    List<Integer> list = new ArrayList<>();
    int pre, count, maxCount;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            res[index] = list.get(index);
        }
        return res;
    }

    public void inOrder(TreeNode node) {
        if(node == null){
            return ;
        }
        inOrder(node.left);
        update(node.val);
        inOrder(node.right);
    }
    public void update(int x){
        if(x == pre){
            count++;
        }else{
            pre = x;
            count = 1;
        }
        if(count == maxCount){
            list.add(pre);
        }
        if( count > maxCount){
            list.clear();
            list.add(pre);
            maxCount = count;
        }

    }

}
// @lc code=end
