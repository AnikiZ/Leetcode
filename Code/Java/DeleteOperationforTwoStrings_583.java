/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-23 15:15:31
 * @LastEditTime: 2022-07-23 15:15:31
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/DeleteOperationforTwoStrings_583.java
 */
public class DeleteOperationforTwoStrings_583 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j -1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
    class Solution_LCS {
        // 找最长子字符串
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= m; i++) {
                // j = 0时候最长子字符串肯定都是0，这个last表示最开始dp[i - 1][0]
                int last = 0;
                for (int j = 1; j <= n; j++) {
                    // 旧值，表示上一行的dp[j],也即dp[i - 1][j]
                    int old = dp[j];
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        // 这里使用的是之前的j，也就是j-1，即dp[j-1]的旧值
                        dp[j] = last + 1;
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                    // last记录的是旧值，表示上一行的dp[j]
                    // 此时保存dp[i - 1][j], 之后j + 1, 相当于是dp[i - 1][j - 1]
                    last = old;
                }
            }
            return m + n - 2 * dp[n];
        }
    }
}
