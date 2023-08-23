/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-12-02 21:56:09
 * @LastEditTime: 2022-12-02 22:10:54
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/StrategyforTikTokAdvertisement.java
 */
package OA;

public class StrategyforTikTokAdvertisement {
    public static void main(String[] args) {
        int budget = 600;
        int[][] M = {{1000, 3000}, {500, 2000}, {200,1000}, {100, 800}, {50, 200}};
        System.out.println(Solution.maxUsers(M, budget));
    }
    public static class Solution {
        public static int maxUsers(int[][] M, int N) {
            int[] dp = new int[N+1];
            int items = M.length;
            for (int i = 0; i < items; i++) {
                int cost = M[i][0], user = M[i][1];
                for (int j = N; j >= cost; j--) {
                    dp[j] = Math.max(dp[j], dp[j - cost] + user);
                }
            }
            return dp[N];
        }
    }
}
