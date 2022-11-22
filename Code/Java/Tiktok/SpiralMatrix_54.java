/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-21 15:45:23
 * @LastEditTime: 2022-11-21 16:02:50
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/SpiralMatrix_54.java
 */
package Tiktok;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length;
            int num = m * n, i = 0;
            // use the pattern of the iteration
            int left = 0, right = n - 1, top = 0, bottom = m-1;
            while (i < num) {
                // make sure i < num in the loop!
                for (int j = left; j <= right && i < num; j++) {
                    list.add(matrix[top][j]);
                    i++;
                }
                top++;
                for (int j = top; j <= bottom && i < num; j++) {
                    list.add(matrix[j][right]);
                    i++;
                }
                right--;
                for (int j = right; j >= left && i < num; j--) {
                    list.add(matrix[bottom][j]);
                    i++;
                }
                bottom--;
                for (int j = bottom; j >= top && i < num; j--) {
                    list.add(matrix[j][left]);
                    i++;
                }
                left++;
            }
            return list;
        }
    }
}
