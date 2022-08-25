import java.util.Stack;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-01 15:57:22
 * @LastEditTime: 2022-07-01 16:21:32
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaxAreaOfIsland_695.java
 */
public class MaxAreaOfIsland_695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            int row = grid.length;
            int col = grid[0].length;
            

            int currArea = 0, area = 0;
            int x, y = 0;
            Stack<int[]> map = new Stack<int[]>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        currArea = 1;
                        grid[i][j] = 0;
                        map.add(new int[]{i, j});
                    }
                    while (!map.isEmpty()) {
                        int[]tmp = map.pop();
                        for (int k = 0; k < 4; k++) {
                            x = tmp[0] + dir[k];
                            y = tmp[1] + dir[k + 1];
                            if (x >= 0 && x < row && y >= 0
                                && y < col && grid[x][y] == 1) {
                                currArea++;
                                grid[x][y] = 0;
                                map.add(new int[]{x, y});
                            }
                        }
                    }
                    area = Math.max(area, currArea);
                }
            }
            return area;
        }
    }
}
