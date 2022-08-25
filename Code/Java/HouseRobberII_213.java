/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-22 15:52:44
 * @LastEditTime: 2022-07-22 15:52:44
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/HouseRobberII——213.java
 */
public class HouseRobberII_213 {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            if (n == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
        }
        public int robRange(int[] nums, int start, int end) {
            int first = nums[start], second = Math.max(first, nums[start + 1]);
            for (int i = start + 2; i < end; i++) {
                int curr = Math.max(first + nums[i], second);
                first = second;
                second = curr;
            }
            return second;
        }
    }
}
