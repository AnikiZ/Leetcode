/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-22 16:13:48
 * @LastEditTime: 2022-07-22 16:28:23
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaximumSubarray_53.java
 */
public class MaximumSubarray_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int max = nums[0];
            int prev = nums[0];
            for (int i = 1; i < n; i++) {
                prev = Math.max(prev + nums[i], nums[i]);
                max = Math.max(prev, max);
            }
            return max;
        }
    }
    class Solution_DivedeConquer {
        public class Status {
            public int lSum, rSum, mSum, sum;

            public Status(int lSum, int rSum, int mSum, int sum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.sum = sum;
            }
        }
        public int maxSubArray(int[] nums) {
            return getStatusInfo(nums, 0, nums.length - 1).mSum;
        }
        public Status getStatusInfo(int[] nums, int l, int r) {
            if (l == r) {
                return new Status(nums[l], nums[l], nums[l], nums[l]);
            }
            int m = (r - l) / 2 + l;
            Status lSub = getStatusInfo(nums, l, m);
            Status rSub = getStatusInfo(nums, m + 1, r);
            return pushUp(lSub, rSub);
        }
        public Status pushUp(Status lSub, Status rSub) {
            int sum = lSub.sum + rSub.sum;
            int lSum = Math.max(lSub.lSum, lSub.sum + rSub.lSum);
            int rSum = Math.max(rSub.rSum, rSub.sum + lSub.rSum);
            int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);
            return new Status(lSum, rSum, mSum, sum);
        }
    }
}
