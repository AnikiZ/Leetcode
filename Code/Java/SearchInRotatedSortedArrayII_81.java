/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-23 21:03:31
 * @LastEditTime: 2022-06-27 16:09:51
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SearchInRotatedSortedArrayII_81.java
 */
public class SearchInRotatedSortedArrayII_81 {
    class Solution_BetterToUnderstand {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] < nums[right]) {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] > nums[right]) {
                    if (target < nums[mid] && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right--;
                }
            }
            return false;
        }
    }
    class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                // 无法判断在左区间还是右区间
                if (nums[left] == nums[mid]) {
                    left++;
                } else if (nums[mid] <= nums[right]) {
                    // right side is non-decreasing
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // left side is non-decreasing
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return false;
        }
    }
}
