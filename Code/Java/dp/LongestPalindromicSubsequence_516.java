/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-29 18:26:51
 * @LastEditTime: 2022-11-29 18:26:51
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/dp/LongestPalindromicSubsequence_516.java
 */
package dp;

public class LongestPalindromicSubsequence_516 {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int len = s.length();
            if (len <= 1) {
                return 1;
            }
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
            }
            for (int cn = 2; cn <= len; cn++) {
                for (int i = 0; i < len - cn + 1; i++) {
                    int j = i + cn - 1;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
}
