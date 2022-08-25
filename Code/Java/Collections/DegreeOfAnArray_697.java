/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-13 23:59:41
 * @LastEditTime: 2022-08-14 01:32:37
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/DegreeOfAnArray_697.java
 */
package Collections;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray_697 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new int[3]);
                    map.get(nums[i])[1] = i;
                }
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }
            int maxNum = 1;
            // 最好设置为nums.length!
            int minLen = 1;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] arr = entry.getValue();
                if (maxNum < arr[0]) {
                    maxNum = arr[0];
                    minLen = arr[2] - arr[1] + 1;
                } else if (maxNum == arr[0]) {
                    minLen = Math.min(minLen, arr[2] - arr[1] + 1);
                }
            }
            return minLen;
        }
    }
}
