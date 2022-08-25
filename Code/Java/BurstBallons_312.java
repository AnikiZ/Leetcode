/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-27 14:23:47
 * @LastEditTime: 2022-07-27 15:02:08
 * @LastEditors: Zeping Zhu
 * @Description: 
 
 * @FilePath: /Code/Java/BurstBallons_312.java
 */
public class BurstBallons_312 {
    class Solution {
        int[] val;
        int[][] memo;
        public int maxCoins(int[] nums) {
            int len = nums.length;
            val = new int[len + 2];
            for (int i = 1; i < len + 1; i++) {
                val[i] = nums[i - 1];
            }
            val[0] = 1; val[len + 1] = 1;
            memo = new int[len + 2][len + 2];
            // for (int i = 0; i < len + 2; i++) {
            //     Arrays.fill(memo[i], -1);
            // }

            return coin(0, len + 1);
        }
        public int coin(int l, int r) {
            if (l >= r - 1) {
                return 0;
            }
            // if (memo[l][r] != -1) {
            //     return memo[l][r];
            // }
            if (memo[l][r] != 0) {
                return memo[l][r];
            }
            for (int i = l + 1; i < r; i++) {
                int sum = val[l] * val[i] * val[r];
                sum += coin(l, i) + coin(i, r);
                memo[l][r] = Math.max(memo[l][r], sum);
            }
            return memo[l][r];
        }
    }
    class Solution_DP {
    //  * dp版本代码，最外层的循环，i为什么是n-1 -> 0，而不能反过来？
    //  * (i,j) 0 1  2   3   4   ...   n-2   n-1   n   n+1
    //  * 0     0 1  2   3   4   ...                   n+1
    //  * 1       1  2   3   4   ...                   n+1
    //  * 2          2   3   4   ...                   n+1
    //  * 3              3   4   ...                   n+1
    //  * 4                  4                         n+1
    //  * .                      .                     .
    //  * .                         .                  .
    //  * n-2                          n-2   n-1   n   n+1
    //  * n-1                                n-1   n   n+1
    //  * n+1
    //  *
    //  * 须从下往上算，即先算dp[n-1][n+1]：
    //  * 根据递推关系，算dp[i][j]时依赖的dp[i][k]和dp[k][j]，其中i<k<j。
    //  * 1、如果从上往下计算，依赖的dp[k][j]根本就还未算出（k比i大），比如算dp[0][3]时，依赖的dp[1][3]还是个未知数。
    //  * 2、从下往上就不一样，算dp[i][j]时，依赖的dp[i][k]，位于同一行左侧，已计算过；
    //  *    依赖的dp[k][j]，因为k>i，位于更下面的行，也已计算过。
        public int maxCoins(int[] nums) {
            int len = nums.length;
            int[] val = new int[len + 2];
            for (int i = 1; i < len + 1; i++) {
                val[i] = nums[i - 1];
            }
            val[0] = 1; val[len + 1] = 1;
            int[][] dp = new int[len + 2][len + 2];
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i + 2; j <= len + 1; j++) {
                    for (int k = i + 1; k < j; k++) {
                        int sum = val[i] * val[k] * val[j];
                        sum += dp[i][k] + dp[k][j];
                        dp[i][j] = Math.max(dp[i][j], sum);
                    }
                }
            }
            return dp[0][len + 1];
        }
    }
}