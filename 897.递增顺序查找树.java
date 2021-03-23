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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode leftNode = increasingBST(root.left);    
        TreeNode head = leftNode;
        if(leftNode != null){
            while(leftNode.right != null){
                leftNode = leftNode.right;
            }
            leftNode.right = root;
        }
        root.left = null;
        root.right = increasingBST(root.right);
        return head == null ? root : head;
    }
}