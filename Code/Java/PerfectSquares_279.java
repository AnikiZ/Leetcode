import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-11 16:06:09
 * @LastEditTime: 2022-07-11 16:31:45
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/PerfectSquares_279.java
 */
public class PerfectSquares_279 {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, n);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                // k * k <= i! 等于别忘了！
                for (int k = 1; k * k <= i; k++) {
                    dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
                }
            }
            return dp[n];
        }
    }
}
