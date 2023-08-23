package UnionSet;

public class RedundantConnection_683 {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UnionSet us = new UnionSet(edges.length + 1);
            for (int[] edge : edges) {
                if (us.find(edge[0]) == us.find(edge[1])) {
                    return edge;
                }
                us.union(edge[0], edge[1]);
            }
            return new int[]{0, 0};
        }
        class UnionSet {
            int[] parent;
            int[] size;
            public UnionSet(int n) {
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }
            public int find(int x) {
                if (parent[x] != x) {
                    // 压缩路径
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }
            public void union(int x, int y) {
                int parentX = find(x);
                int parentY = find(y);
                if (parentX != parentY) {
                    // 按秩合并
                    if (size[parentX] < size[parentY]) {
                        parent[parentX] = parentY;
                        size[parentY] += size[parentX];
                    } else {
                        parent[parentY] = parentX;
                        size[parentX] += size[parentY];
                    }
                }
            }
        }  
    }
}
