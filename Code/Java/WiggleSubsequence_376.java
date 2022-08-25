/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-24 18:18:06
 * @LastEditTime: 2022-07-24 18:18:07
 * @LastEditors: Zeping Zhu
 * @Description:
 * @FilePath: /Code/Java/WiggleSubsequence——376.java
 */
public class WiggleSubsequence_376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int len = nums.length;
            int[] up = new int[len];
            int[] down = new int[len];
            up[0] = 1; down[0] = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] == nums[i - 1]) {
                    up[i] = up[i - 1];
                    down[i] = down[i - 1];
                }
                if (nums[i] > nums[i - 1]) {
                    up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                    down[i] = down[i - 1];
                }
                if (nums[i] < nums[i - 1]) {
                    up[i] = up[i - 1];
                    down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
                }
            }
            return Math.max(up[len - 1], down[len - 1]);
        }
    }
    class Solution_SpaceOpt {
        public int wiggleMaxLength(int[] nums) {
            int len = nums.length;
            int up = 1;
            int down = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] < nums[i - 1]) {
                    down = Math.max(up + 1, down);
                }
                if (nums[i] > nums[i - 1]) {
                    up = Math.max(up, down + 1);
                }
            }
            return Math.max(up, down);
        }
    }
}