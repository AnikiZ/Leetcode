/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-19 19:07:14
 * @LastEditTime: 2022-07-19 19:09:48
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/BestTimeToBuyAndSellStock_121.java
 */
public class BestTimeToBuyAndSellStock_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int price = prices[0], sell = 0;
            for (int i = 1; i < prices.length; i++) {
                price = Math.min(price, prices[i]);
                sell = Math.max(sell, prices[i] - price);
            }
            
            return sell;
        }
    }
}
