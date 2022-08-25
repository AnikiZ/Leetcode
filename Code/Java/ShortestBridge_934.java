import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-05 15:48:01
 * @LastEditTime: 2022-07-05 17:16:28
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ShortestBridge_934.java
 */
public class ShortestBridge_934 {
    class Solution_Deque {
        public int shortestBridge(int[][] grid) {
            int rol = grid.length, col = grid[0].length;
            boolean[][] visited = new boolean[rol][col];
            Deque<int[]> points = new LinkedList<>();
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        visited[i][j] = true;
                        return dfsPlus(grid, visited, points, rol, col, i, j);
                    }
                }
            }
            return -1;
        }
        public int dfsPlus(int[][] grid, boolean[][] visited, Deque<int[]> points, int rol, int col, int i, int j) {
            points.offer(new int[]{i, j, 0});
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            while (!points.isEmpty()) {
                int[] point = points.poll();
                for (int k = 0; k < 4; k++) {
                    int x = point[0] + dir[k], y = point[1] + dir[k + 1];
                    if (x >= 0 && x < rol && y >= 0 && y < col && visited[x][y] == false) {
                        visited[x][y] = true;
                        if (grid[x][y] == 1) {
                            if (point[2] > 0) {
                                return point[2];
                            }
                            points.offerFirst(new int[]{x, y, 0});
                        } else {
                            points.offerLast(new int[]{x, y, point[2] + 1});
                        }
                    }
                }
            }
            return -1;
        }
    }
    class Solution {
        public int shortestBridge(int[][] grid) {
            int rol = grid.length, col = grid[0].length;
            int level = 0;
            boolean find = false;
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            Queue<int[]> points = new LinkedList<>();
            for (int i = 0; i < rol; i++) {
                if (find) {
                    break;
                }
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        dfs(grid, points, rol, col, i, j);
                        find = true;
                        break;
                    }
                }
            }
            while (!points.isEmpty()) {
                int nums = points.size();
                level++;
                while (nums-- != 0) {
                    int[] point = points.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = point[0] + dir[k];
                        int y = point[1] + dir[k + 1];
                        if (x >= 0 && x < rol && y >= 0 && y < col) {
                            if (grid[x][y] == 2) {
                                continue;
                            }
                            if (grid[x][y] == 1) {
                                return level;
                            }
                            // grid[x][y] = 0
                            grid[x][y] = 2;
                            points.offer(new int[]{x, y});
                            
                        }
                    }
                }
            }
            return level;
        }
        public void dfs(int[][] grid, Queue<int[]> points, int rol, int col, int i, int j) {
            if (i < 0 || j < 0 || i >= rol || j >= col || grid[i][j] == 2) {
                return;
            }
            if (grid[i][j] == 0) {
                points.offer(new int[]{i, j});
                return;
            }
            // grid[i][j] == 1
            grid[i][j] = 2;
            dfs(grid, points, rol, col, i + 1, j);
            dfs(grid, points, rol, col, i - 1, j);
            dfs(grid, points, rol, col, i, j + 1);
            dfs(grid, points, rol, col, i, j - 1);
        }
    }
}
