package Graph;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-19 20:18:31
 * @LastEditTime: 2022-10-19 21:20:42
 * @LastEditors: Zeping Zhu
 * @Description: package Graph;
 * @FilePath: /Leetcode/Code/Java/Graph/AllPathsFromSourceLeadToDestination_1059.java
 */

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> roads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            roads.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            roads.get(edge[0]).add(edge[1]);
        }
        // corner case: edges:[], src==dest
        if (roads.get(source).size() == 0 && source == destination) {
            return true;
        }
        boolean res = false;
        int[] visited;
        for (int node : roads.get(source)) {
            visited = new int[n];
            visited[source] = 1;
            res = dfs(node, destination, roads, visited);
            if (res == false) {
                return false;
            }
        }
        return res;
    }
    public boolean dfs(int node, int destination, List<List<Integer>> roads, int[] visited) {
        if (visited[node] == 1) {
            return false;
        } else {
            if (roads.get(node).size() == 0) {
                if (node == destination) {
                    return true;
                } else {
                    return false;
                }
            }
            visited[node] = 1;
            boolean res = false;
            for (int n : roads.get(node)) {
                res = dfs(n, destination, roads, visited);
                if (res == false) {
                    return false;
                }
                visited[node] = 0;
            }
            return res;
        }
    }
}
