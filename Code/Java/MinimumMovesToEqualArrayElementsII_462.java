import java.util.Arrays;
import java.util.Random;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 17:28:11
 * @LastEditTime: 2022-07-29 21:30:06
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MinimumMovesToEqualArrayElementsII_462.java
 */
public class MinimumMovesToEqualArrayElementsII_462 {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int num = nums[nums.length / 2];
            int ans = 0;
            for (int i : nums) {
                ans += Math.abs(i - num);
            }
            return ans;
        }
    }
    class Solution_QuickSort {
        // 相当于求解第n / 2(从0开始计数)小的元素，用快速选择去做
        Random random = new Random();
        public int minMoves2(int[] nums) {
            int len = nums.length;
            int x = quickSelect(nums, 0, len - 1, len / 2);
            int ans = 0;
            for (int i : nums) {
                ans += Math.abs(i - x);
            }
            return ans;
        }
        public int quickSelect(int[] nums, int left, int right, int index) {
            int q = randomPartition(nums, left, right);
            if (q == index) {
                return nums[q];
            } else {
                return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
            }
        }
        public int randomPartition(int[] nums, int left, int right) {
            int rand = random.nextInt(right - left + 1) + left;
            swap(nums, rand, right);
            int x = nums[right], leftPoint = left;
            for (int j = left; j < right; j++) {
                if (nums[j] < x) {
                    swap(nums, leftPoint++, j);
                }
            }
            swap(nums, leftPoint, right);
            return leftPoint;

        }
        public void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
