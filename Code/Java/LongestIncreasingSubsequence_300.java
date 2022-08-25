import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-12 01:41:45
 * @LastEditTime: 2022-07-12 14:05:23
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LongestIncreasingSubsequence_300.java
 */
public class LongestIncreasingSubsequence_300 {
    class SolutionDp {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            int ans = 1;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        ans = Math.max(ans, dp[i]);
                    }
                }
            }
            return ans;
        }
    }
    // 贪心+二分O(nlogn)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] d = new int[n];
            int len = 0;
            d[len] = nums[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] > d[len]) {
                    d[++len] = nums[i];
                } else {
                    // 二分查找
                    int left = 0, right = len;
                    while (left < right) {
                        int mid = (right - left) / 2 + left;
                        if (d[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    d[left] = nums[i];
                }
            }
            return len + 1;
        }
    }
}
