/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-31 03:15:07
 * @LastEditTime: 2022-07-31 03:15:08
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SingleNumber_136.java
 */
public class SingleNumber_136 {
    class Solution {
        public int singleNumber(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] ^= nums[i - 1];
            }
            return nums[nums.length - 1];
        }
    }
}
