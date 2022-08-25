/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-18 18:04:03
 * @LastEditTime: 2022-08-18 18:25:31
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/LongestSubstringWithoutRepeatingCharacters_3.java
 */
package String;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int start = 0, max = 0, len = s.length();
            for (int end = 0; end < len; end++) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    // this ensures that the sustring doesn't contain duplicates
                    // also, the elements before start also are in the map! compare the index!
                    start = Math.max(start, map.get(c) + 1);
                }
                max = Math.max(max, end - start + 1);
                map.put(c, end);
            }
            return max;
        }
    }
}
