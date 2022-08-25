import java.util.HashMap;
import java.util.Map;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-15 18:09:09
 * @LastEditTime: 2022-06-15 18:19:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /LeetCode/Code/Java/MinimumWindowSubstring_76.java
 */
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
// such that every character in t (including duplicates) is included in the window. 
// If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.
// Constraints:
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
public class MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String ans = Solution.minWindow("asd", "a");
        System.out.println(ans);
    }
    class Solution {
        public static String minWindow(String s, String t) {
            Map<Character, Integer> tMap = new HashMap<Character, Integer>();
            Map<Character, Integer> sMap = new HashMap<Character, Integer>();
            for (char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }
            int cnt = 0;
            int len = s.length() + 1;
            String ans = "";
            int right = 0, left = 0;
            for (; right < s.length(); right++) {
                char c = s.charAt(right);
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (tMap.containsKey(c) && sMap.get(c) <= tMap.get(c)) {
                    cnt++;
                }
                if (cnt == t.length()) {
                    char cLeft = s.charAt(left);
                    while (!tMap.containsKey(cLeft) || tMap.get(cLeft) < sMap.get(cLeft)) {
                        sMap.put(cLeft, sMap.get(cLeft) - 1);
                        left++;
                        cLeft = s.charAt(left);
                    }
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        ans = s.substring(left, right + 1);
                    }
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                    left++;
                    cnt--;
                }
            }
            return ans;
        }
    }
}
