package Graph;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-19 20:18:31
 * @LastEditTime: 2022-10-20 02:28:25
 * @LastEditors: Zeping Zhu
 * @Description: package Graph;
 * @FilePath: /Leetcode/Code/Java/Graph/AllPathsFromSourceLeadToDestination_1059.java
 */

 // 没有剪枝，过不去
// class Solution {
//     public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
//         List<List<Integer>> roads = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             roads.add(new ArrayList<>());
//         }
//         for (int[] edge : edges) {
//             roads.get(edge[0]).add(edge[1]);
//         }
//         // corner case: edges:[], src==dest
//         if (roads.get(source).size() == 0 && source == destination) {
//             return true;
//         }
//         boolean res = false;
//         int[] visited;
//         for (int node : roads.get(source)) {
//             visited = new int[n];
//             visited[source] = 1;
//             res = dfs(node, destination, roads, visited);
//             if (res == false) {
//                 return false;
//             }
//         }
//         return res;
//     }
//     public boolean dfs(int node, int destination, List<List<Integer>> roads, int[] visited) {
//         if (visited[node] == 1) {
//             return false;
//         } else {
//             if (roads.get(node).size() == 0) {
//                 if (node == destination) {
//                     return true;
//                 } else {
//                     return false;
//                 }
//             }
//             visited[node] = 1;
//             boolean res = false;
//             for (int n : roads.get(node)) {
//                 res = dfs(n, destination, roads, visited);
//                 if (res == false) {
//                     return false;
//                 }
//                 visited[node] = 0;
//             }
//             return res;
//         }
//     }
// }
class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();
        for(int[] edge: edges) 
            adj[edge[0]].add(edge[1]);
        return dfs(adj, source, destination, new boolean[n], new boolean[n]);
    }
    public boolean dfs(List<Integer>[] adj, int v, int d, boolean[] visited, boolean[] onPath) {
        if(adj[v].size() == 0)
            return v == d;
        visited[v] = true;
        onPath[v] = true;
        for(int next: adj[v]) 
        // visited过的，下面的路径不用管，是重复的，直接出来；只有环或者下面节点没visit，同时dfs返回false，那上级返回false
            if((onPath[next]) || (!visited[next] && !dfs(adj, next, d, visited, onPath))) 
                return false;
        onPath[v] = false;
        return true;
    }
}