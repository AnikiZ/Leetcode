/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-31 18:06:11
 * @LastEditTime: 2022-07-31 18:06:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/CountingBits_338.java
 */
public class CountingBits_338 {
    class Solution {
        public int[] countBits(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = (i & 1) == 0 ? dp[i >> 1] : dp[i - 1] + 1;
            }
            return dp;
        }
    }
}
