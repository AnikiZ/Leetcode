/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-15 01:14:25
 * @LastEditTime: 2022-10-20 03:15:58
 * @LastEditors: Zeping Zhu
 * @Description:
 
 * @FilePath: /Leetcode/Code/Java/Collections/AdvantageShuffle_870.java
 */
package Collections;

import java.util.Arrays;
public class AdvantageShuffle_870 {
    class Solution_Greedy {
        
        public static void main(String[] args) {
            int[] nums1 = {2,0,4,1,2};
            int[] nums2 = {1,3,0,0,2};
            // Solution.advantageCount(nums1, nums2);
        }
        // public int[] advantageCountWrong(int[] nums1, int[] nums2) {
        //     int[] n1 = nums1.clone();
        //     int[] n2 = nums2.clone();
        //     Arrays.sort(n1);
        //     Arrays.sort(n2);
        //     // 这样是错误的，无法处理相同数字的情况，可以将value改为linkedliest
        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     int start = 0, end = n2.length - 1;
        //     for (int i = 0; i < n1.length; i++) {
        //         if (n1[i] > n2[start]) {
        //             map.put(n2[start], n1[i]);
        //             start++;
        //         } else {
        //             map.put(n2[end], n1[i]);
        //             end--;
        //         }
        //     }
        //     int[] ans = new int[n2.length];
        //     for (int i = 0; i < nums2.length; i++) {
        //         ans[i] = map.get(nums2[i]);
        //     }
        //     return ans;
        // }
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int[] n1 = nums1.clone();
            Arrays.sort(n1);
            int len2 = nums2.length;
            int[][] n2 = new int[len2][2];
            for (int i = 0; i < len2; i++) {
                n2[i][0] = nums2[i];
                n2[i][1] = i;
            }
            Arrays.sort(n2, (a, b) -> {
                return a[0] - b[0];
            });
            int[] ans = new int[len2];
            int start = 0, end = len2 - 1;
            for (int num : n1) {
                if (num > n2[start][0]) {
                    ans[n2[start][1]] = num;
                    start++;
                } else {
                    ans[n2[end][1]] = num;
                    end--;
                }
            }

            return ans;
        }
    }
    class Solution_BinarySearch {

    }
}