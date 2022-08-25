/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-10 17:59:50
 * @LastEditTime: 2022-07-15 19:36:30
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/HouseRobber_198.java
 */
public class HouseRobber_198 {
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 1) {
                return nums[0];
            }
            int pre1 = nums[0], pre2 = 0, cur = nums[1];
            for (int i = 1; i < len; i++) {
                cur = Math.max(pre1, pre2 + nums[i]);
                pre2 = pre1;
                pre1 = cur;
            }
            return cur;
        }
    }
}
