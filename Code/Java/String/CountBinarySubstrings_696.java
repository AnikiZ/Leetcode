/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-17 19:34:12
 * @LastEditTime: 2022-08-17 19:49:53
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/CountBinarySubstrings_696.java
 */
package String;

public class CountBinarySubstrings_696 {
    class Solution {
        public int countBinarySubstrings(String s) {
            int pre = 0, cur = 1, count = 0, len = s.length();
            for (int i = 1; i < len; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    cur++;
                } else {
                    pre = cur;
                    cur = 1;
                }
                if (pre >= cur) {
                    count++;
                }
            }
            return count;
        }
    }
    // only need to count consecutive 0 and 1 adjacent groups and the smaller one is the same count
    class Solution_E {
        public int countBinarySubstrings(String s) {
            int index = 0, len = s.length(), pre = 0, ans = 0;
            while (index < len) {
                char c = s.charAt(index);
                int count = 0;
                while (index < len && c == s.charAt(index)) {
                    index++;
                    count++;
                }
                ans += Math.min(pre, count);
                pre = count;
            }
            return ans;
        }
    }
}
