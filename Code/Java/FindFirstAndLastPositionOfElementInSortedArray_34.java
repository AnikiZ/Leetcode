/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-23 18:38:40
 * @LastEditTime: 2022-06-23 18:38:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/FindFirstAndLastPositionOfElementInSortedArray_34.java
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) {
                return new int[]{-1, -1};
            }
            int lowerBound = lowerBound(nums, target);
            int upperBound = upperBound(nums, target);
            if (nums[lowerBound] != target) {
                return new int[]{-1, -1};
            } else {
                return new int[]{lowerBound, upperBound};
            }
        }
        public int lowerBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
        public int upperBound(int[] nums, int  target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }
    }
}
