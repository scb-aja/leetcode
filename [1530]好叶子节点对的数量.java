//给你二叉树的根节点 root 和一个整数 distance 。 
//
// 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。 
//
// 返回树中 好叶子节点对的数量 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 输入：root = [1,2,3,null,4], distance = 3
//输出：1
//解释：树的叶节点是 3 和 4 ，它们之间的最短路径的长度是 3 。这是唯一的好叶子节点对。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,2,3,4,5,6,7], distance = 3
//输出：2
//解释：好叶子节点对为 [4,5] 和 [6,7] ，最短路径长度都是 2 。但是叶子节点对 [4,6] 不满足要求，因为它们之间的最短路径长度为 4 。
// 
//
// 示例 3： 
//
// 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
//输出：1
//解释：唯一的好叶子节点对是 [2,5] 。
// 
//
// 示例 4： 
//
// 输入：root = [100], distance = 1
//输出：0
// 
//
// 示例 5： 
//
// 输入：root = [1,1,1], distance = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// tree 的节点数在 [1, 2^10] 范围内。 
// 每个节点的值都在 [1, 100] 之间。 
// 1 <= distance <= 10 
// 
// Related Topics 树 深度优先搜索 
// 👍 69 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    /**
     * depths depths[i] 到最近p的公共祖先的路径为i的叶子节点个数
     * count 为好叶子节点对
     * */
    public class ReturnData{
        int[] depths;
        int count;
        public ReturnData(int[] depths, int count){
            this.depths = depths;
            this.count = count;
        }
    }
    public int countPairs(TreeNode root, int distance) {
        ReturnData returnData = inOrder(root, distance);
        return  returnData.count;
    }
    public ReturnData inOrder(TreeNode root, int distance){
        int[] dps = new int[distance + 1];
        if(root == null){
            return null;
        }
        ReturnData leftReturnData = inOrder(root.left, distance);
        ReturnData rightReturnData = inOrder(root.right, distance);
        //叶子节点返回值
        if(leftReturnData == null && rightReturnData == null){
            dps[0] = 1;
            return new ReturnData(dps, 0);
        }
        int[] leftDps = new int[distance + 1];
        int[] rightDps = new int[distance + 1];
        int leftCounts = 0;
        int rightCounts = 0;
        if(leftReturnData != null){
            leftDps = leftReturnData.depths;
            leftCounts = leftReturnData.count;
        }
        if(rightReturnData != null){
            rightDps = rightReturnData.depths;
            rightCounts = rightReturnData.count;
        }
        for(int index = 0; index < distance; index++){
            dps[index + 1] += leftDps[index];
            dps[index + 1] += rightDps[index];
        }
        int cnt = 0;
        for(int i = 0; i <= distance; i++){
            for(int j = 0; j + i + 2 <= distance; j++){
                cnt += leftDps[i] * rightDps[j];
            }
        }
        /**
         * 好叶子对包括三种:
         *  1. 左子树的好叶子对
         *  2. 右子树的好叶子对
         *  3. 左右子树的好叶子对
         * */
        return new ReturnData(dps, cnt + leftCounts + rightCounts);


    }

}
//leetcode submit region end(Prohibit modification and deletion)
