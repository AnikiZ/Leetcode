/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-16 17:40:00
 * @LastEditTime: 2022-06-16 17:40:00
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /LeetCode/Code/Java/NonDecreasingArray_665.java
 */
public class NonDecreasingArray_665 {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;
            for (int i = 0; i < nums.length - 1 && cnt < 2; i++) {
                if (nums[i] > nums[i + 1]) {
                    cnt++;
                    if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                }
            }
            return cnt <= 1;
        }
    }
}
