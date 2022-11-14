/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-13 23:58:58
 * @LastEditTime: 2022-11-14 01:54:58
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/dp/LongestLineOfConsecutiveOneInMatrix_562.java
 */
package dp;

public class LongestLineOfConsecutiveOneInMatrix_562 {
    class Solution {
        public int longestLine(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] horizontal = new int[m][n];
            int[][] vertical = new int[m][n];
            int[][] diagonal = new int[m][n];
            int[][] anti = new int[m][n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j]==0) {
                        horizontal[i][j] = 0;
                        vertical[i][j] = 0;
                        diagonal[i][j] = 0;
                        anti[i][j] = 0;
                    } else {
                        horizontal[i][j] = j > 0 ? horizontal[i][j-1]+1 : 1;
                        vertical[i][j] = i > 0 ? vertical[i-1][j]+1:1;
                        diagonal[i][j] = (i>0&&j>0) ? diagonal[i-1][j-1]+1:1;
                        anti[i][j] = (i >0 && j<n-1) ? anti[i-1][j+1]+1:1;
                        ans = Math.max(ans, horizontal[i][j]);
                        ans = Math.max(ans, vertical[i][j]);
                        ans = Math.max(ans, diagonal[i][j]);
                        ans = Math.max(ans, anti[i][j]);
                    }
                }
            }
            return ans;
        }
    }
}