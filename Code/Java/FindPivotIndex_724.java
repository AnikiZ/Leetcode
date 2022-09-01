/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-09-01 11:45:29
 * @LastEditTime: 2022-09-01 12:05:17
 * @LastEditors: Zeping Zhu
 * @Description: package Tree;
 */

 public class FindPivotIndex_724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int ans = -1;

            int left = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                right += nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                right -= nums[i];
                if (left == right) {
                    ans = i;
                    break;
                }
                left += nums[i];
            }

            return ans;
        }
    }
}

