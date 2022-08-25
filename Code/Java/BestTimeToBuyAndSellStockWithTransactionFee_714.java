/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-25 00:46:06
 * @LastEditTime: 2022-07-25 01:41:18
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/BestTimeToBuyAndSellStockWithTransactionFee_714.java
 */
public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[] buy = new int[n];
            int[] sell = new int[n];
            buy[0] = -prices[0];
            for (int i = 1; i < n; i++) {
                // sell 写在 buy 前面！这样才能更新到最新一天能够卖的最大值！
                // sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
                // buy[i] = Math.max(buy[i - 1], sell[i] - prices[i]);

                // 这么写也对，效率还更高 why？？？
                // 观察buy[i]中的sell[i] - prices[i]，把sell[i]带进去发现就是Math.max(sell[i - 1]  - prices[i], buy[i - 1] - fee),
                // buy[i - 1] - fee比buy[i - 1]小，不考虑，还是化成了昨天的状态，所以今天不用考虑进去，对最终结果无影响
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
                
            }
            return sell[n - 1];
        }
    }
}
