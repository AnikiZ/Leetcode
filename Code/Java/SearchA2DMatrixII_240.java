/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-07 01:29:03
 * @LastEditTime: 2022-08-07 01:29:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SearchA@DMatrixII_240.java
 */
public class SearchA2DMatrixII_240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }
}
