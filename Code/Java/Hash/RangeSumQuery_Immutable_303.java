/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-12 14:51:59
 * @LastEditTime: 2022-08-12 15:39:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Hash/RangeSumQuery_Immutable_303.java
 */
package Hash;

public class RangeSumQuery_Immutable_303 {
    class NumArray {
        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            // dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
        }
        public int sumRange(int left, int right) {
            return dp[right + 1] - dp[left];
        }
    }
    
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
}
