/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-14 22:18:25
 * @LastEditTime: 2022-07-14 22:39:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/TwoKeysKeyboard_650.java
 */
public class TwoKeysKeyboard_650 {
    class Solution {
        public int minSteps(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        dp[i] = Math.min(dp[i], dp[j] + i / j);
                    }
                }
            }
            return dp[n];
        }
    }
    class Solution_Opt {
        public int minSteps(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        dp[i] = Math.min(dp[i], dp[j] + dp[i / j]);
                    }
                }
            }
            return dp[n];
        }
    }
}
