/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-10 19:18:16
 * @LastEditTime: 2022-07-15 19:36:31
 * @LastEditors: Zeping Zhu
 * @Description: 对于位置i，如果它和前两个数构成等差数列，那么该位置可构成的
 * 等差数列数为前一个数可构成等差数列数 + 1（前一个数构成的等差数列加上他本身以及他和前两个数）
 * 如果不构成等差数列，则为0
 * @FilePath: /Code/Java/ArithmeticSlices_413.java
 */
public class ArithmeticSlices_413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int len = nums.length;
            if (len < 3) {
                return 0;
            }
            // int[] dp = new int[len];
            int sum = 0;
            int cons = 0;
            for (int i = 2; i < len; i++) {
                if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                    // dp[i] = dp[i - 1] + 1;
                    // sum = sum + dp[i];
                    // 因为只跟前面一个数有关，用一个变量记录就可以让空间复杂度变为O(1):
                    cons = cons + 1;
                    sum = sum + cons;
                } else {
                    cons = 0;
                }
            }
            return sum;
        }
    }
}
