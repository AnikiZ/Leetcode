/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-23 15:04:36
 * @LastEditTime: 2022-07-23 15:11:28
 * @LastEditors: Zeping Zhu
 * @Description: 
 
 * @FilePath: /Code/Java/IntegerBreak_343.java
 */
public class IntegerBreak_343 {
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(Math.max(2 * (i - 2), 3 * (i - 3)), Math.max(2 * dp[i - 2], 3 * dp[i - 3]));
            }
            return dp[n];
        }
    }
}