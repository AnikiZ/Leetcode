import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-24 01:49:47
 * @LastEditTime: 2022-07-24 02:02:00
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaximumLengthOfPairChain_646.java
 */
public class MaximumLengthOfPairChain_646 {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> {
                // if (a[1] != b[1]) {
                //     return a[1] - b[1];
                // } else {
                //     return a[0] - b[0];
                // }
                return a[1] - b[1];
            });
            int ans = 0, cur = Integer.MIN_VALUE;
            for (int[] pair : pairs) {
                if (pair[0] > cur) {
                    cur = pair[1];
                    ans++;
                }
            }
            return ans;
        }
    }
}