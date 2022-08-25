import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-21 09:10:55
 * @LastEditTime: 2022-07-21 12:49:28
 * @LastEditors: Zeping Zhu
 * @Description: 二维好理解一些：buy/sell[i][j]表示第i天交易j次最大
 * buy一次sell一次算一次交易，buy肯定在sell之前
 * buy[i][j] = max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i])
 * sell[i][j] = max(sell[i - 1][j], buy[i - 1][j] + prices[i])
 * 同一天买了再买是一样的，不加
 * 这里可以降维其实挺特殊，因为buy里会用到sell，如果降维，sell[i - 1][j - 1]会被sell[i][j - 1]替代
 * 若这两者不等就会出问题。首先可以得知sell[i][j]一定是>=sell[i][j - 1]的，然后假设存在上述问题，
 * 那么此时buy[i - 1][j] < sell[i - 1][j - 1] - prices[i], sell[i - 1][j] < buy[i - 1][j] + prices[i]
 * 矛盾了，所以不会存在这种情况，那么就可以降维
 * 时间有限的话先写出二维吧！
 * @FilePath: /Code/Java/BestTimeToBuyAndSellStockIV_188.java
 */
public class BestTimeToBuyAndSellStockIV_188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int days = prices.length;
            int buy[] = new int[k + 1], sell[] = new int[k + 1];
            Arrays.fill(buy, -prices[0]);
            k = Math.min(days - 1, k);
            for (int i = 0; i < days; i++) {
                for (int j = 1; j <= k; j++) {
                    // 因为有sell[j - 1], j = 1即第一次交易，需要有一个初值，
                    // 那第零次交易肯定sell值为0，所以初始化sell全为0
                    // 而i在降维之后没有了越界问题，所以可以直接从0开始
                    // 对于buy[j]的初值，全设为-prices[0]，因为肯定买了股票，比如第一次购买，肯定得是负值，
                    // 之后跟他进行比较，如果设为0那就会变成0，不对
                    // 神奇之处：下面两行顺序怎么样其实都不影响，与可以降维原因相同
                    buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                    sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                }
            }
            return sell[k];
        }
    }
}
