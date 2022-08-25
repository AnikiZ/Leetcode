/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-10 19:56:21
 * @LastEditTime: 2022-07-10 20:02:49
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MinimumPathSum_64.java
 */
public class MinimumPathSum_64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int rol = grid.length, col = grid[0].length;
            int[] dp = new int[col];
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0 && j == 0) {
                        dp[j] = grid[i][j];
                    } else if (i == 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp[j] = dp[j] + grid[i][j];
                    } else {
                        dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                    }
                }
            }
            return dp[col - 1];
        }
    }
}
