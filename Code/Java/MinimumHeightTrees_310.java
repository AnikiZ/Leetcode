import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-09 11:45:35
 * @LastEditTime: 2022-07-15 19:36:28
 * @LastEditors: Zeping Zhu
 * @Description: 将度为1的最外层叶子一层一层抽离，剩下最后一圈即为答案
 * 后续：拓扑结构DP法
 * @FilePath: /Code/Java/MinimumHeightTrees_310.java
 */
public class MinimumHeightTrees_310 {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            // 因为是integer对应一个integer数组，用list，每个数做index正好 Note: 用get(int index)!
            List<List<Integer>> map = new ArrayList<>();
            int[] degree = new int[n];
            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                degree[edge[0]]++;
                degree[edge[1]]++;
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                ans = new ArrayList<>();
                while (size-- != 0) {
                    int cur = queue.poll();
                    ans.add(cur);
                    List<Integer> neighbors = map.get(cur);
                    for (int neighbor : neighbors) {
                        degree[neighbor]--;
                        if (degree[neighbor] == 1) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return ans;
        }
    }
}
