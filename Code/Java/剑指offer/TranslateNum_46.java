/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-26 02:59:57
 * @LastEditTime: 2022-11-26 02:59:57
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/剑指offer/TranslateNum_46.java
 */
package 剑指offer;

public class TranslateNum_46 {
    class Solution {
        public int translateNum(int num) {
            String numS = String.valueOf(num);
            int len = numS.length();
            int[] dp = new int[len + 1];
            if (len == 1) {
                return 1;
            }
            // 从2开始，初始化0,2都是1
            // dp[i] = dp[i-1] + dp[i - 2](如果dp[i]和dp[i-1]可以组成10~25)
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < len; i++) {
                String sub = numS.substring(i-1, i+1);
                if (sub.compareTo("25") <= 0 && sub.compareTo("10") >= 0) {
                    dp[i+1] = dp[i] + dp[i-1];
                } else {
                    dp[i+1] = dp[i];
                }
            }
            return dp[len];
        }
    }
}
