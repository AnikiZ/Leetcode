/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-29 20:22:39
 * @LastEditTime: 2022-11-29 20:22:40
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Hash/MaximumSizeSubarraySumEqualsk_325.java
 */
package Hash;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk_325 {
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int preSum = 0;
            int len = nums.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                preSum += nums[i];
                if (map.containsKey(preSum - k)) {
                    res = Math.max(res, i - map.get(preSum - k));
                }
                if (!map.containsKey(preSum)) {
                    map.put(preSum, i);
                }
            }
            return res;
        }
    }
}
