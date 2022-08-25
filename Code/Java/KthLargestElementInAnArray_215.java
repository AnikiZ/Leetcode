import java.util.Random;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-29 20:17:23
 * @LastEditTime: 2022-06-29 20:17:23
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/KthLargestElementInAnArray_215.java
 */
public class KthLargestElementInAnArray_215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelection(nums, 0, nums.length - 1, nums.length - k);
        }
        public int quickSelection(int[] nums, int left, int right, int index) {
            if (left >= right) {
                return nums[left];
            }
            int position = randomPartition(nums, left, right);
            if (position == index) {
                return nums[position];
            } else {
                return position < index ? quickSelection(nums, position + 1, right, index) : quickSelection(nums, left, position - 1, index);
            }
        }
        // 快排
        public int randomPartition(int[] nums, int left, int right) {
            Random random = new Random();
            int randomIndex = random.nextInt(right - left + 1) + left;
            int pivot = nums[randomIndex];
            swap(nums, randomIndex, right);
            int partition = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, partition++, i);
                }
            }
            swap(nums, partition, right);
            return partition;
        }
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
