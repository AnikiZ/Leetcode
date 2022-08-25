/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-12 22:22:14
 * @LastEditTime: 2022-08-12 22:22:15
 * @LastEditors: Zeping Zhu
 * @Description:
 * @FilePath: /Code/Java/ReshapeTheMatrix_266.java
 */

public class ReshapeTheMatrix_566 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int row = mat.length, col = mat[0].length;
            int num = row * col;
            int[][] ans = new int[r][c];
            if (r * c != num) {
                return mat;
            } else {
                // for (int i = 0; i < row; i++) {
                //     for (int j = 0; j < col; j++) {
                //         int m = (i * col + j) / c;
                //         int n = (i * col + j) % c;
                //         ans[m][n] = mat[i][j];
                //     }
                // }
                for (int x = 0; x < row * col; x++) {
                    ans[x / c][x % c] = mat[x / col][x % col];
                }
            }
            return ans;
        }
    }
}