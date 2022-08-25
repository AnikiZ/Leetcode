/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-21 13:05:27
 * @LastEditTime: 2022-07-22 15:29:58
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/BestTimeToBuyAndSellStockWithCooldown_309.java
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] buy = new int[n];
            int[] sell = new int[n];
            int[] cool = new int[n];
            // int[] s1 = new int[n];
            buy[0] = -prices[0];
            sell[0] = cool[0] = 0;
            for (int i = 1; i < n; i++) {
                // buy[i] = cool[i - 1] - prices[i];
                buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
                // sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
                sell[i] = buy[i - 1] + prices[i];
                // s1[i] = Math.max(s1[i - 1], buy[i - 1]);
                cool[i] = Math.max(sell[i - 1], cool[i - 1]);
            }
            return Math.max(sell[n - 1], cool[n - 1]);
         }
    }
    class Solution_Opt {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int buy = -prices[0];
            int sell = 0;
            int cool = 0;
            for (int i = 1; i < n; i++) {
                int newBuy = Math.max(buy, cool - prices[i]);
                int newSell = buy + prices[i];
                int newCool = Math.max(cool, sell);
                buy = newBuy;
                sell = newSell;
                cool = newCool;
            }
            return Math.max(cool, sell);
         }
    }
}