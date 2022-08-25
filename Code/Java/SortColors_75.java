/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-30 18:20:30
 * @LastEditTime: 2022-06-30 18:20:31
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SortColors_75.java
 */
public class SortColors_75 {
    class Solution {
        public void sortColors(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int i = 0;
            while (i <= right) {
                while (i < right && nums[i] == 2) {
                    int temp = nums[i];
                    nums[i] = nums[right];
                    nums[right] = temp;
                    right--;
                }
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                i++;
            }
        }
    }
}
