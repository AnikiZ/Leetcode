import java.util.ArrayDeque;
import java.util.Deque;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-19 17:17:31
 * @LastEditTime: 2022-10-19 18:22:16
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Graph/IsGraphBipartite_785.java
 */
public class IsGraphBipartite_785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int color[] = new int[n];
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    q.add(i);
                    color[i] = 1;
                }
                while (!q.isEmpty()) {
                    int node = q.pop();
                    for (int edge : graph[node]) {
                        if(color[edge]==0) {
                            color[edge] = color[node] == 1 ? 2 : 1;
                            q.add(edge);
                        } else if (color[edge]==color[node]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
