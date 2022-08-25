/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-22 17:53:36
 * @LastEditTime: 2022-06-22 17:53:36
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/TwoSumII_InputArrayIsSorted_167.java
 */
public class TwoSumII_InputArrayIsSorted_167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1, sum;
            while (left < right) {
                sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }
    }
}
