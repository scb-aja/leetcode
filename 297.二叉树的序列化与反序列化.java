import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

import java.util.List;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (53.45%)
 * Likes:    471
 * Dislikes: 0
 * Total Accepted:    66.6K
 * Total Submissions: 124K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 10^4] 内
 * -1000 
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
public class Codec {
    
    /**
     * 
     * 
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrder(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("!");
        // Queue<String> queue = new LinkedList<>();
        // for( int index = 0; index < values.length; index++){
        //     queue.offer(values[index]);
        // }
        // return deserializeByQueue(queue);
        List<Integer> list = new ArrayList<>();
        list.add(-1);//占位用
        return deserializeByArray(values, 0, list);
    
    }

    /**
     * 
     * 先序序列 序列化
     * 以!为分隔符
     * #代表null节点
     * @param root
     * @return
     */
    public String preOrder(TreeNode root){
        if(root == null){
            return "#!";
        }
        String res = root.val + "!";
        res += preOrder(root.left);
        res += preOrder(root.right);
        return res;
    }

    public TreeNode deserializeByQueue(Queue<String> queue){
        String val = queue.poll();
        if("#".equals(val)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeByQueue(queue);
        node.right = deserializeByQueue(queue);
        return node;
    }

    public TreeNode deserializeByArray(String[] values, int index, List<Integer> visit){
        if(index >= values.length){
            return null;
        }        
        String val = values[index];
        if("#".equals(val)){
            visit.set(0, index + 1);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeByArray(values, index + 1, visit);
        node.right = deserializeByArray(values, visit.get(0), visit);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

