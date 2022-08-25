/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-12 17:17:26
 * @LastEditTime: 2022-08-12 17:52:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Hash/SubarraySumEqualsK_560.java
 */
package Hash;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int count = 0;
            // 初始化！！！
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                count += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}