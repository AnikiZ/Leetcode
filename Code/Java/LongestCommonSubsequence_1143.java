/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-12 14:06:39
 * @LastEditTime: 2022-07-12 15:02:56
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LongestCommonSubsequence_1143.java
 */
public class LongestCommonSubsequence_1143 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            // dp[0][0] = 0作为初始状态， dp[i][j]对应text1第i个字符，text2第j个字符时最长相同子串长度
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // charAt这边是i - 1! 仔细！
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
