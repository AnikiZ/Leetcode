import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-14 16:37:53
 * @LastEditTime: 2022-07-14 17:03:24
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/CoinChange_322.java
 */

public class CoinChange_322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // int[i] represents fewest amount of coins needed to make up the amount i
            int[] dp = new int[amount + 1];
            // because most amount will be all 1, which is amount, so amount + 1 will be an impossible number
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin) {
                        // because of min, cannot use -1, or add extra ifs
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
