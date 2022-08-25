/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-14 01:34:16
 * @LastEditTime: 2022-08-14 02:40:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/LongestHarmoniousSubsequence_594.java
 */
package Collections;

import java.util.Arrays;

public class LongestHarmoniousSubsequence_594 {
    // also can be solved using HashMap
    // 这题乍一看感觉要用dp，实际用dp要考虑的状态转换很复杂
    // 仔细一想，对于数x，只要看x-1有几个，x+1有几个，技术就行了
    // 本题元素值域远大于元素个数，数组计数会相当稀疏，直接用哈希表可很好解决
    class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            int start = 0;
            for (int end = 1; end < nums.length; end++) {
                while (nums[end] - nums[start] > 1) {
                    start++;
                }
                if (nums[end] - nums[start] == 1) {
                    ans = Math.max(ans, end - start + 1);
                }
            }
            return ans;
        }
    }
}
