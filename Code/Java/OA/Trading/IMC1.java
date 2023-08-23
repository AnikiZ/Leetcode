package OA.Trading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class IMC1 {
    private final static int[] DIRS = {-1, 0, 1, 0, -1};
    private int[] fa;
    private int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        var q = new ArrayList<int[]>();
        var dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) > 0) {
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }
        var groups = new ArrayList<List<int[]>>();
        groups.add(q);
        while (!q.isEmpty()) { // multi bfs
            var tmp = q;
            q = new ArrayList<>();
            for (var p : tmp) {
                for (int d = 0; d < 4; d++) {
                    int x = p[0] + DIRS[d];
                    int y = p[1] + DIRS[d + 1];
                    // todo: if n * m?
                    if (Math.min(x, y) >= 0 && x < n && y < m && dis[x][y] < 0) {
                        q.add(new int[]{x, y});
                        dis[x][y] = groups.size();
                    }
                }
            }
            groups.add(q);
        }
        // Union Find
        fa = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            fa[i] = i;
        }
        for (int ans = groups.size() - 2; ans > 0; ans--) {
            var g = groups.get(ans);
            for (var p : g) {
                int i = p[0], j = p[1];
                for (int d = 0; d < 4; d++) {
                    int x = i + DIRS[d];
                    int y = j + DIRS[d + 1];
                    // todo: if n * m?
                    if (Math.min(x, y) >= 0 && x < n && y < m && dis[x][y] >= dis[i][j]) {
                        fa[find(n * x + y)] = find(n * i + j);
                    }
                }
            }
            if (find(0) == find(n * n - 1)) {
                return ans;
            }
        }
        return 0;
    }
    // Solution2 BFS + PriorityQueue
    static class Solution2 {

    private final static int[] DIRS = {-1, 0, 1, 0, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dis = new int[n][n];

        var q = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int i = front[0], j = front[1];
            
            for (int d = 0; d < 4; d++) {
                int x = i + DIRS[d], y = j + DIRS[d + 1];
                if (x >= 0 && x < n && y >= 0 && y < n && dis[x][y] == -1) {
                    dis[x][y] = dis[i][j] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.add(new int[]{dis[0][0], 0, 0});
        boolean[][] v = new boolean[n][n];
        
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int di = top[0], i = top[1], j = top[2];
            if (v[i][j]) continue;
            
            v[i][j] = true;
            ans = Math.min(ans, di);
            if (i == n - 1 && j == n - 1) return ans;
            
            for (int d = 0; d < 4; d++) {
                int x = i + DIRS[d], y = j + DIRS[d + 1];
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (v[x][y]) continue;
                    pq.add(new int[]{dis[x][y], x, y});
                }
            }
        }
        
        return 0;
    }
}

    // Solution3 bfs + binary search for answer
    class Solution3 {
    int n, m;
    int[][] dir;
    int[][] dis;
    // Define a checker function for BFS with limited distance
    private boolean check(int lim) {
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0], j = p[1];
            for (int[] d : dir) {
                int ii = i + d[0], jj = j + d[1];
                if (ii < 0 || jj < 0 || ii >= n || jj >= m || dis[ii][jj] < lim || vis[ii][jj]) continue;
                if (ii == n - 1 && jj == m - 1) return true;
                queue.add(new int[]{ii, jj});
                vis[ii][jj] = true;
            }
        }
        return vis[n - 1][m - 1];
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        this.n = grid.size();
        this.m = grid.get(0).size();
        this.dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // 2D array to store distances
        this.dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    dis[i][j] = 0;
                }
            }
        }

        // Perform BFS from all thieves
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            for (int[] d : dir) {
                int ii = i + d[0], jj = j + d[1];
                if (ii < 0 || jj < 0 || ii >= n || jj >= m || dis[ii][jj] >= 0) continue;
                q.add(new int[]{ii, jj});
                dis[ii][jj] = dis[i][j] + 1;
            }
        }
        
        // Binary search on the answer
        int head = 0, tail = Math.min(dis[0][0], dis[n - 1][m - 1]);
        while (head < tail) {
            int mid = head - ((head - tail) >> 1);
            if (check(mid)) head = mid;
            else tail = mid - 1;
        }
        
        return head;
    }
}

}
