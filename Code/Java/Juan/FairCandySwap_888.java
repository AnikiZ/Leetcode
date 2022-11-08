/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-07 17:49:14
 * @LastEditTime: 2022-11-07 17:56:32
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Juan/FairCandySwap_888.java
 */
package Juan;

import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap_888 {
    class Solution {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
            int sumA = Arrays.stream(aliceSizes).sum();
            int sumB = Arrays.stream(bobSizes).sum();
            int diff = (sumB-sumA)/2;
            // b - a = diff, b = a + diff
            HashSet<Integer> bobSet = new HashSet<>();
            for (int b : bobSizes) {
                bobSet.add(b);
            }
            int ans[] = new int[2];
            for (int a : aliceSizes) {
                if (bobSet.contains(a+diff)) {
                    ans[0] = a;
                    ans[1] = a+diff;
                }
            }
            return ans;
        }
    }
    class Solution_Chen {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // 空间换时间，数组作为hash表会更快
        // 1 <= aliceSizes.length, bobSizes.length <= 10^4
        // 1 <= aliceSizes[i], bobSizes[j] <= 10^5
            int sumA = 0;
            int sumB = 0;
            boolean[] alice = new boolean[100001]; // like hashMap
            for (int s : aliceSizes) {
                sumA+=s;
                alice[s]=true; // 
            }
            for (int s : bobSizes) {
                sumB+=s;
            }
            // 不用考虑奇数问题，因为必定存在答案。所以不可能差值为奇数
            int d = (sumB - sumA) / 2;
            for (int s : bobSizes) {
                int sd = s-d;
                // 判断sd范围很关键！对于数组，要注意下标有效性！
                if(sd >= 0 && sd < 100001 && alice[sd]) {
                    return new int[]{sd,s};
                }
            }
            return new int[]{0,0};
        }
    }
}
