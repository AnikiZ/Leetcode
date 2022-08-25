/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-14 17:42:00
 * @LastEditTime: 2022-07-14 18:00:42
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/EditDistance_72.java
 */
public class EditDistance_72 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else if (j == 0) {
                        dp[i][j] = i;
                    } else {
                        // 括号；string的index记得减一！
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + ((word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1),
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
