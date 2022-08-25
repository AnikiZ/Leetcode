/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-18 16:59:04
 * @LastEditTime: 2022-07-18 21:18:21
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/RegularExpressionMatching_10.java
 */
public class RegularExpressionMatching_10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int lenS = s.length(), lenP = p.length();
            boolean[][] dp = new boolean[lenS + 1][lenP + 1];
            dp[0][0] = true;
            for (int i = 2; i <= lenP; i++) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }
            for (int i = 1; i <= lenS; i++) {
                for (int j = 1; j <= lenP; j++) {
                    if (p.charAt(j - 1) != '*') {
                        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            // 对于“*”情况且前一个character匹配，这时候有以下几种可能：
                            // ".*"相当于它可以作为0个或者无数个“.”字符，注意可以为空！一个都没有
                            // 1. dp[i][j] = dp[i - 1][j] 相当于dp[i]对应“.*”中其中一个，可以把dp[i]去掉也不影响
                            // 2. dp[i][j] = dp[i][j - 2] 相当于".*"作为0个字符，可删去，dp[i]对应".*"前面那个字符
                            // 3. dp[i][j] = dp[i][j - 1]其实可以去掉，因为这相当于dp[i]代表了".*"中第一个字符，是1的子问题，无需加上
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2]; // || dp[i][j - 1];
                        } else {
                            // "*"情况且前面一个character不能匹配，只能去匹配在前面那个
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[lenS][lenP];
        }
    }
}