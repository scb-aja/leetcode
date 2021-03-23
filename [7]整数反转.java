//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 
//
// 注意： 
//
// 
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {

        /**
         * 笨比方法
         * 转化成字符串进行翻转
         *
         * */
//        String abs_x = x + "";
//        int start = 0;
//        if(abs_x.contains("-")){
//            start = 1;
//        }
//        String result = reviseString(abs_x, start);
//        long reuslt_long = Long.parseLong(result);
//        if(reuslt_long > Integer.MAX_VALUE || reuslt_long < Integer.MIN_VALUE)
//            return 0;
//        else
//            return (int)reuslt_long;

        /**
         * 移除判断
         *[-2147483648, 2147483647]
         * y = y*10 + x % 10
         * 当y > 214748364时溢出
         *  因为 （x的长度为最长）输入的时候x是不溢出的 所以x的最高位一定是1或2，
         *  变成最低位一定不溢出 所以 判断 > 214748364就行
         *  同理最低范围也是如此
         *
         *
         * */
        int y = 0;
        while (x != 0) {
            if (y > 214748364 | y < -214748364)
                return 0;
            else {
                y = y * 10 + x % 10;
                x = x / 10;
            }
        }
        return y;


    }

    public String reviseString(String str, int start) {
        char[] chars = str.toCharArray();
        int left = start;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
