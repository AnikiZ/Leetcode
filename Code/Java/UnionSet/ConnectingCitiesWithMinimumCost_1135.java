/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-20 02:29:07
 * @LastEditTime: 2022-10-31 02:03:50
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/Graph/ConnectingCitiesWithMinimumCost_1135.java
 */
package UnionSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class ConnectingCitiesWithMinimumCost_1135 {
    public static void main(String[] args) {
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        Solution_Prim.minimumCost(3, connections);
    }
    class Solution {
        public int minimumCost(int n, int[][] connections) {
            // Kruskal's algorithm + 并查集UF
            // 1.所有边按权重从小到大排序
            // 2.取一条权重最小的边
            // 3.使用UF判断加入这条边后是否会形成环；若不会构成环，加入最小生成树中
            // 4.检查所有结点是否已经全部联通（加入边的数量） 全联通：结束；否则返回2
            // 需要UF的原因：该算法是按照边去加，有可能出现两团集合合并的情况，所以需要判断是否属于同一集合
            int[] fathers = new int[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
            }
            int[] size = new int[n];
            Arrays.fill(size, 1);
            Arrays.sort(connections, (a, b) -> {
                return a[2] - b[2];
            });
            int cost = 0;
            int count = 1; // 树现在有1个点；每union一对就+1，若到n就满足，返回
            for (int[] connect : connections) {
                if (count == n) {
                    return cost;
                }
                // 注意减一！题目的节点是从1开始的
                if (findHead(connect[0] - 1, fathers) == findHead(connect[1] - 1, fathers)) {
                    continue;
                }
                union(connect[0] - 1, connect[1] - 1, fathers, size);
                count++;
                cost+=connect[2];

            }
            if (count == n) {
                return cost;
            } else {
                return -1;
            }
        }
        public int findHead(int i, int fathers[]) {
            if (i == fathers[i]) {
                return i;
            }
            return fathers[i] = findHead(fathers[i], fathers);
        }
        public void union(int i, int j, int fathers[], int size[]) {
            int iF = findHead(i, fathers);
            int jF = findHead(j, fathers);
            if (iF != jF) {
                if (size[iF] >= size[jF]) {
                    size[iF] += size[jF];
                    fathers[jF] = iF;
                } else {
                    size[jF] += size[iF];
                    fathers[iF] = jF;
                }
            }
        }
    }
    class Solution_Prim {
        public static int minimumCost(int n, int[][] connections) {
            // Prim priority queue!
            // Krusal是考虑每次把权重最小的边加入到树种；Prim是根据顶点，
            // 每一步都会增加一条连接树中顶点与不在树中顶点且权重最小的边加入到树中。
            // 是不断往外扩的，不需要UF

            // 这样不会出错但很怪。linkedlist右边不能加泛型之类会报错
            // List<int[]>[] graph = new LinkedList[n + 1];
            List<List<int[]>> edges = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                edges.add(new ArrayList<>());
            }

            for(int[] connect : connections) {
                edges.get(connect[0]).add(new int[]{connect[1], connect[2]});
                // 一个边，两个顶点都要分别加入对应的list里，不然搜索时可能搜不到
                edges.get(connect[1]).add(new int[]{connect[0], connect[2]});
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
                return a[1] - b[1];
            });

            int[] visited = new int[n + 1];

            int cost = 0;

            // Prim queue:
            // 少了一个visited!!!
            visited[1] = 1;
            for (int[] edge : edges.get(1)) {
                // 需要检查么，或者直接在while里检查一次就够了
                if (visited[edge[0]] == 0) {
                    queue.offer(edge);
                }    
            }
            while (!queue.isEmpty()) {
                int[] edge = queue.poll();
                if (visited[edge[0]] == 0) {
                    visited[edge[0]] = 1;
                    cost += edge[1];
                    for (int[] nextEdge : edges.get(edge[0])) {
                        // 需要检查么，或者直接在while里检查一次就够了
                        if (visited[nextEdge[0]] == 0) {
                            queue.offer(nextEdge);
                        }    
                    }
                }
            }
            for (int i = 1; i < n + 1; i++) {
                if (visited[i] == 0) {
                    return -1;
                }
            }
            return cost;
        }
    }

}
