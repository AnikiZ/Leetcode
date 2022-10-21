/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-20 22:48:11
 * @LastEditTime: 2022-10-20 23:36:23
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/OA/Tiktok2.java
 */
package OA;

import java.util.Arrays;

public class Tiktok2 {
    public static void main(String[] args) {
        System.out.println(Solution.uniquePaths(2, 2));
    }
    class Solution {
        public static long uniquePaths(int m, int n) {
            // long mL = Long.valueOf(m);
            // Long nL = Long.valueOf(n);
            // long l = Long.parseLong("10000000");
            long[] dp = new long[n + 1];
            Arrays.fill(dp, 1);
            for (int i = m-1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
            // dp[1]!!!
            return dp[0];

            // int[] dp = new int[n];
            // Arrays.fill(dp, 1);
            // for (int i = m-1; i > 0; i--) {
            //     for (int j = n - 2; j >= 0; j--) {
            //         dp[j] = dp[j] + dp[j + 1];
            //     }
            // }
            // return dp[0];
        }
    }
}
