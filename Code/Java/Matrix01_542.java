/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-10 20:24:13
 * @LastEditTime: 2022-07-10 22:54:08
 * @LastEditors: Zeping Zhu
 * @Description: 先从左上到右下dp，然后从右下到左上dp，从而实现四方向搜索
 * 假如距离(i,j)最近的点在(i-a,j+b) a>0,b>0，则距离(i,j+b)最近的点在(i-a,j+b)
 * 用反证法证明： 如果距离(i,j+b)最近的点(x,y)不在(i-a,j+b)，则(i,j+b)和(x,y)距离d<a
 * 这时点(i,j)和(x,y)的距离d'<=b+d<a+b,与假设矛盾。
 * 利用这个性质，如果距离(i,j)最近的点在(i-a,j+b) a>0,b>0，在第一个dp时(i,j)没有取得最优值
 * 但在第二个dp时由于(i,j+b)的最优值已经取得(因为这个最优值在他正上方)，所以(i,j)也能取得最优值。
 * @FilePath: /Code/Java/Matrix01_542.java
 */
public class Matrix01_542 {
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int rol = mat.length, col = mat[0].length;
            int[][] dp = new int[rol][col];
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    // 错误原因：最大值加一直接越限变为-inf！其实最大距离不会超过rol + col的
                    // dp[i][j] = Integer.MAX_VALUE;
                    // dp[i][j] = Integer.MAX_VALUE - 1;
                    dp[i][j] = rol + col;
                }
            }
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        if (j > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                        }
                        if (i > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                        }
                    }
                }
            }
            for (int i = rol - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    if (j < col - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                    if (i < rol - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                }
            }
            return dp;
        }
    }
}
