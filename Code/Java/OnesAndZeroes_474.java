/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-14 16:12:37
 * @LastEditTime: 2022-07-14 16:25:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/OnesAndZeroes_474.java
 */
public class OnesAndZeroes_474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String str : strs) {
                int[] count = getCounts(str);
                for (int i = m; i >= count[0]; i--) {
                    for (int j = n; j >= count[1]; j--) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count[0]][j - count[1]]);
                        
                    }
                }
            }
            return dp[m][n];
        }
        public int[] getCounts(String str) {
            int count0 = 0, count1 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            return new int[]{count0, count1};
        }
    }
}

