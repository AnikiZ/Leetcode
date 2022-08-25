import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-01 17:34:28
 * @LastEditTime: 2022-07-01 17:34:28
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/NumberOfProvinces_547.java
 */
public class NumberOfProvinces_547 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int num = isConnected.length, cnt = 0;
            boolean[] visited = new boolean[num];
            Arrays.fill(visited, false);
            for (int i = 0; i < num; i++) {
                if (!visited[i]) {
                    dfs(isConnected, i, visited);
                    cnt++;
                }
            }
            return cnt;
        }
        public void dfs(int[][] isConnected, int i, boolean[] visited) {
            visited[i] = true;
            for (int k = 0; k < isConnected.length; k++) {
                if (isConnected[i][k] == 1 && !visited[k]) {
                    dfs(isConnected, k, visited);
                }
            }
        }
    }
}
