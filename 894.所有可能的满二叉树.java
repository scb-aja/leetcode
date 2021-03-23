/*
 * @lc app=leetcode.cn id=894 lang=java
 *
 * [894] 所有可能的满二叉树
 *
 * https://leetcode-cn.com/problems/all-possible-full-binary-trees/description/
 *
 * algorithms
 * Medium (77.13%)
 * Likes:    179
 * Dislikes: 0
 * Total Accepted:    10.4K
 * Total Submissions: 13.5K
 * Testcase Example:  '7'
 *
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 
 * 你可以按任何顺序返回树的最终列表。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：7
 * 
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 20
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
    // 偶节点 形成不了满二叉树
    public List<TreeNode> allPossibleFBT(int num) {
        List<TreeNode> resultList = new ArrayList<>();
        // 偶节点 不存在满二叉树
        if (num % 2 == 0) {
            return resultList;
        }
        // base case
        if (num == 1) {
            resultList.add(new TreeNode(0));
            return resultList;
        }

        int mid = (num - 1) / 2; // 得到mid
        for (int index = 1; index <= mid; index++) {
            List<TreeNode> list1 = allPossibleFBT(index);
            List<TreeNode> list2 = allPossibleFBT(num - 1 - index);
            if (list1.size() == 0 || list2.size() == 0) {
                continue;
            }
            if (index == mid) {
                mergeTree(list1, list2, resultList);
            } else {
                mergeTree(list1, list2, resultList);
                mergeTree(list2, list1, resultList);

            }
        }

        return resultList;
    }

    public void mergeTree(List<TreeNode> list1, List<TreeNode> list2, List<TreeNode> resultList) {

        for (int index = 0; index < list1.size(); index++) {
            TreeNode nodeLeft = list1.get(index);
            for (int j = 0; j < list2.size(); j++) {
                TreeNode node = new TreeNode(0);
                node.left = nodeLeft;
                node.right = list2.get(j);
                resultList.add(node);
            }
            
        }

    }

}
// @lc code=end
