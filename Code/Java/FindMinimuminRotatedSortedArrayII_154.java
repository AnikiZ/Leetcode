/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-27 15:37:15
 * @LastEditTime: 2022-06-27 16:02:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/FindMinimuminRotatedSortedArrayII_154.java
 */
public class FindMinimuminRotatedSortedArrayII_154 {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return nums[right];
        }
    }
}
