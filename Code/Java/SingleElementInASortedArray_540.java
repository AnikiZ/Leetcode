
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-27 16:59:47
 * @LastEditTime: 2022-06-27 16:59:47
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SingleElementInASortedArray_540.java
 */
public class SingleElementInASortedArray_540 {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            // if (right == 0) {
            //     return nums[right];
            // }
            // if (nums[0] < nums[1]) {
            //     return nums[0];
            // }
            // if (nums[right] > nums[right - 1]) {
            //     return nums[right];
            // }
            while (left < right) {
                int mid = left + (right - left) / 2;
                // if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                //     return nums[mid];
                // }
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        left = mid + 2;
                    } else {
                        right = mid;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return nums[right];
        }
    }
}
