import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 *
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/description/
 *
 * algorithms
 * Medium (38.89%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    15.8K
 * Total Submissions: 40.6K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary
 * tree）结构相同，但一些节点为空。
 * 
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * 
 * ⁠          1
 * ⁠        /   \
 * ⁠       3     2
 * ⁠      / \     \  
 * ⁠     5   3     9 
 * 
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        /  
 * ⁠       3    
 * ⁠      / \       
 * ⁠     5   3     
 * 
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2 
 * ⁠      /        
 * ⁠     5      
 * 
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 
 * 
 * 示例 4:
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      /     \  
 * ⁠     5       9 
 * ⁠    /         \
 * ⁠   6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 
 * 
 * 注意: 答案在32位有符号整数的表示范围内。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       
    
    }


    //测试用例108没通过
    public int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        double max = -1;
        long currentLevel = 1;
        Map<TreeNode, Double> map = new HashMap<>(); // 节点和序号对应关系
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, Double.parseDouble(1 + ""));
        double currentLevelStartNodeIndex = 0;
        double currentLevelEndNodeIndex = 0;
        boolean isStart = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            double currentNodeIndex = map.get(node); // 得到当前的序号
            // 判断当前遍历的节点是否属于这一层
            if (currentNodeIndex >= (1 << (currentLevel - 1)) && currentNodeIndex < (1 << currentLevel)) {
                if (!isStart) {
                    currentLevelStartNodeIndex = currentNodeIndex;
                    isStart = true;
                }

                currentLevelEndNodeIndex = currentNodeIndex;
            } else {
                double currentLevelNodes = currentLevelEndNodeIndex - currentLevelStartNodeIndex + 1;
                max = Math.max(max, currentLevelNodes);

                currentLevelStartNodeIndex = currentNodeIndex;
                currentLevelEndNodeIndex = currentNodeIndex;
                isStart = true;
                currentLevel++; // 层数加一
            }

            if (node.left != null) {
                map.put(node.left, 2 * currentNodeIndex); // 标记节点序号
                queue.offer(node.left);
            }

            if (node.right != null) {
                map.put(node.right, 2 * currentNodeIndex + 1); // 标记节点序号
                queue.offer(node.right);
            }

        }

        max = Math.max(max, currentLevelEndNodeIndex - currentLevelStartNodeIndex + 1);
        return (int) max;
    }

    public int widthOfBinaryTreeByDequeue(TreeNode root){
        if(root == null){
            return 0;
        }
        Deque<TreeNode> qDeque = new LinkedList<>();
        Deque<TreeNode> hDeque = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        int ans = 1;
        qDeque.offer(root);
        while(!qDeque.isEmpty()){
            TreeNode node = qDeque.poll();
            int index = map.get(node);
            if(node.left != null){
                hDeque.offer(node.left);
                map.put(node.left, 2*index);
            }
            if(node.right != null){
                hDeque.offer(node.right);
                map.put(node.right, 2*index + 1);
            }

            if(qDeque.isEmpty()){
                if(!hDeque.isEmpty()){
                    int leftIndex = map.get(hDeque.getFirst());
                    int rightIndex = map.get(hDeque.getLast());
                    ans = Math.max(ans, (rightIndex - leftIndex ) + 1);
                }

                Deque<TreeNode> temp = hDeque;
                hDeque = qDeque;
                qDeque = temp;
            }
        }
        return ans;
    }
}
// @lc code=end
