import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 *
 * https://leetcode-cn.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (65.84%)
 * Likes:    632
 * Dislikes: 0
 * Total Accepted:    131.8K
 * Total Submissions: 199.8K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0
 * 来代替。
 * 
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4,
 * 2, 1, 1, 0, 0]。
 * 
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * 
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        //从栈底到栈顶递减
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] results = new int[len];
        for(int index = 0; index < len; index++){
            int temp = T[index];
            while( !stack.isEmpty() && T[stack.peek()] < temp){
                int result_index = stack.pop();
                results[result_index] = ( index - result_index);
            }
            stack.push(index);
        }
        return results;

    }
}
// @lc code=end

