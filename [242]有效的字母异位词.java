//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 326 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * 字母异位词 相同的字母不同的顺序位置
         *
         * */
       int[] positon = new int[26];
       if(s.length() != t.length())
           return false;
       else{
           for(int index = 0; index < s.length();index++){
               positon[s.charAt(index) - 'a']++;
               positon[t.charAt(index) - 'a']--;

           }

           for(int index = 0; index < positon.length; index++){
               if(positon[index] != 0)
                   return false;

           }
           return true;
       }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
