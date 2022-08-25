/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-11 14:38:06
 * @LastEditTime: 2022-07-11 14:53:31
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaximalSquare_221.java
 */
public class MaximalSquare_221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rol = matrix.length, col = matrix[0].length;
            // dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            // 如果从0开始遍历，-1就会越界需要分类讨论判断，但dp[-1]其实为0，因此用dp[i + 1][j + 1]来表示matrix[i][j]的area值，
            // dp从1开始遍历，0就相当于matrix[-1]的值，初始化就是0
            int[][] dp = new int[rol + 1][col + 1];
            int ans = 0;
            for (int i = 1; i <= rol; i++) {
                for (int j = 1; j <= col; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
            // 最后求的是面积！
            return ans * ans;
        }
    }
}
