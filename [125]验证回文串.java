//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 311 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if("".equals(s))
            return true;

        String s_upper = s.toUpperCase();
        int left = 0;
        int right = s_upper.length() - 1;
        while (left < right) {
            while (!isStrNum(s_upper.charAt(left)) && left < right) {
                left++;

            }

            while (!isStrNum(s_upper.charAt(right)) && left < right) {
                right--;
            }


            if (s_upper.charAt(left) != s_upper.charAt(right) && left < right)
                return false;
            left++;
            right--;
        }

        return true;


    }

    public boolean isStrNum(char c){
        return (c >= '0' && c <= '9') || ( c >= 'A' && c <= 'Z');

    }
}
//leetcode submit region end(Prohibit modification and deletion)
