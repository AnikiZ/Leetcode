/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-12-02 21:15:25
 * @LastEditTime: 2022-12-02 21:40:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/ReorderingFromShortesttoTallest.java
 */
package OA;

import java.util.Arrays;

public class ReorderingFromShortesttoTallest {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 3};
        System.out.println(Solution.minMoves(arr));
    }
    public static class Solution {
        public static int minMoves(int[] arr) {
            int[] brr = arr.clone();
            Arrays.sort(brr);
            int expectedIdx = 0;
            int count = 0;
            for (int i : arr) {
                if (i == brr[expectedIdx]) {
                    expectedIdx++;
                } else {
                    count++;
                }
            }
            return count;
        }
    }

}
