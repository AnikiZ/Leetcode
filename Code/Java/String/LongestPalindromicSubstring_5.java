/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-19 01:19:05
 * @LastEditTime: 2022-08-19 01:36:29
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/LongestPalindromicSubstring_5.java
 */
package String;

public class LongestPalindromicSubstring_5 {
    class Solution {
        // dp O(n^2)
        public String longestPalindrome(String s) {
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            int max = 0;
            String ans = "";
            for (int j = 0; j < len; j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && ((j - i) <= 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        // 这两行，其实不用每次更新，记录起点终点就行了，最后substring
                        ans = max < j - i + 1 ? s.substring(i, j + 1) : ans;
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
            return ans;
        }
    }
    class Solution_Manacher {
        // O(n)
        public String longestPalindrome(String s) {
            StringBuilder ss = new StringBuilder();
            ss.append("?#");
            for (char c : s.toCharArray()) {
                ss.append(c);
                ss.append("#");
            }
            int len = ss.length(), maxLen = 1, start = 1, end = 0;
            // 头尾都要加保证不会越界
            ss.append("!");
            int rmax = 1, imax = 1;
            int[] next = new int[len];
            for (int i = 1; i < len; i++) {
                next[i] = i <= rmax ? Math.min(next[2 * imax - i], rmax - i + 1) : 1;

                while (ss.charAt(i + next[i]) == ss.charAt(i - next[i])) {
                    next[i]++;
                }

                if (i + next[i] - 1 > rmax) {
                    rmax = i + next[i] - 1;
                    imax = i;
                }

                if (2 * next[i] - 1 > maxLen) {
                    maxLen = 2 * next[i] - 1;
                    start = i - next[i] + 1;
                    end = i + next[i] - 1;
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = start; i <= end; i++) {
                if (ss.charAt(i) != '#') {
                    ans.append(ss.charAt(i));
                }
            }
            return ans.toString();
        }
    }
}
