package Tiktok;

public class ContainerWithMostWater_11 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;
            int max = 0;
            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                if (area > max) {
                    max = area;
                }
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-21 17:21:24
 * @LastEditTime: 2022-11-21 17:21:24
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/ContainerWithMostWater_11.java
 */
