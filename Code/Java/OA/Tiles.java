/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-19 12:01:44
 * @LastEditTime: 2022-11-19 12:21:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/Tiles.java
 */
package OA;

public class Tiles {
    public static void main(String[] args) {
        
    }
    public int[] res(int[][] tiles) {
        int resRow = 0, resCol = 0;
        int m = tiles.length, n = tiles[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    int before = dp[i-1][j] + dp[i][j-1]-dp[i-1][j-1];
                    dp[i][j] = tiles[i][j] == -1 ? before : before + tiles[i][j];
                } else if (i > 0) {
                    int before = dp[i-1][j];
                    dp[i][j] = tiles[i][j]==-1 ? before : before + tiles[i][j];
                } else if (j > 0) {
                    int before = dp[i][j-1];
                    dp[i][j] = tiles[i][j] == -1 ? before : before + tiles[i][j];
                } else {
                    dp[i][j] = tiles[i][j] == -1 ? 0 : tiles[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                int area[] = new int[4];
                int av[] = new int[4];
                area[0] = dp[i][j];
                area[1] = dp[i][n-1] - dp[i][j];
                area[2] = dp[m-1][j] - dp[i][j];
                area[3] = dp[m-1][n-1] - dp[m-1][j] - dp[i][n-1] + dp[i][j];
                av[0] = area[0] / ((i+1) * (j+1));
                av[1] = area[1] / ((i+1) * (n-1-j));
                av[2] = area[2] / ((j+1) * (m-1-i));
                av[3] = area[3] / ((m-1-i) * (n-1-j));
                int diff = diff(av);
                if (diff < ans) {
                    resRow = i;
                    resCol = j;
                    ans = diff;
                }
            }
        }
        int[] res = new int[]{resRow, resCol};
        return res;
    }
    public int diff(int[] a) {
        int min = a[0], max = a[0];
        for (int i : a) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }
        return max - min;
    }
}
