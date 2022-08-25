import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-01 17:46:40
 * @LastEditTime: 2022-07-01 18:50:40
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/PacificAtlanticWaterFlow_417.java
 */
public class PacificAtlanticWaterFlow_417 {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> ans = new ArrayList<>();
            int p = heights.length, a = heights[0].length;
            // boolean[] dft = new boolean[a];
            // Arrays.fill(dft, false);
            boolean[][] canReachP = new boolean[p][a];
            boolean[][] canReachA = new boolean[p][a];
            // Arrays.fill(canReachP, dft);
            // Arrays.fill(canReachA, dft);
            for (int i = 0; i < p; i++) {
                dfs(heights, canReachP, i, 0);
                dfs(heights, canReachA, i, a - 1);
            }
            for (int j = 0; j < a; j++) {
                dfs(heights, canReachP, 0, j);
                dfs(heights, canReachA, p - 1, j);
            }
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < a; j++) {
                    if (canReachP[i][j] && canReachA[i][j]) {
                        List<Integer> t = new ArrayList<>();
                        t.add(i);
                        t.add(j);
                        ans.add(t);
                    }
                }
            }
            return ans;
        }
        public void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            if (ocean[i][j]) {
                return;
            }
            ocean[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = i + dir[k];
                int y = j + dir[k + 1];
                if (x >= 0 && x < heights.length && y >= 0
                && y < heights[0].length && heights[i][j] <= heights[x][y]) {
                    dfs(heights, ocean, x, y);
                }
            }
        }
    }
}
