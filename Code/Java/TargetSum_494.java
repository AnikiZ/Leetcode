/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-24 23:50:45
 * @LastEditTime: 2022-07-25 01:04:21
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/TargetSum_494.java
 */
public class TargetSum_494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            // int len = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 必要条件！！！ sum >= target && (sum - target) % 2 == 0
            if (sum < target || (sum - target) % 2 != 0) {
                return 0;
            }
            int neg = (sum - target) / 2;
            // int[][] dp = new int[len + 1][neg + 1];
            // dp[0][0] = 1;
            // for (int i = 1; i < len + 1; i++) {
            //     // 注意这边j从0开始！问题转化为0-1背包问题，求在nums前i个数中选取元素，元素和为j的方案数，
            //     // 那和可以为0的方案数并不为0，不选数就行了，或者该数为0的时候选不选都行，相当于0前面正负号都一样，但是是两种不同方案！
            //     for (int j = 0; j <= neg; j++) {
            //         // 注意是nums[i - 1]!!!!!!!!!!!!!!!!!!!!!!!!!!
            //         int num = nums[i - 1];
            //         // 可以降维！
            //         if (num > j) {
            //             dp[i][j] = dp[i - 1][j];
            //         } else {
            //             dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
            //         }
            //     }
            // }
            // return dp[len][neg];
            int[] dp = new int[neg + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int j = neg; j >= num; j--) {
                    dp[j] = dp[j] + dp[j - num];
                }
            }
            return dp[neg];
        }
    }
}
