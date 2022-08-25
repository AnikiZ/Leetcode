/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 22:40:23
 * @LastEditTime: 2022-08-22 23:17:00
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/AverageOfLevelsInBinaryTree_637.java
 */
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        public List<Double> averageOfLevels(TreeNode root) {
            if (root != null) {
                q.add(root);
                bfs(root, q, ans);
            }
            return ans;
        }
        private void bfs(TreeNode root, Queue<TreeNode> q, List<Double> ans) {
            while (!q.isEmpty()) {
                int size = q.size();
                int num = size;
                double sum = 0;
                while (size-- != 0) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                ans.add(sum / num);
            }
        }
    }
    class Solution_DFS {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Integer> counts = new ArrayList<Integer>();
            List<Double> sums = new ArrayList<Double>();
            dfs(root, 0, counts, sums);
            List<Double> averages = new ArrayList<Double>();
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                averages.add(sums.get(i) / counts.get(i));
            }
            return averages;
        }
    
        public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
            if (root == null) {
                return;
            }
            if (level < sums.size()) {
                sums.set(level, sums.get(level) + root.val);
                counts.set(level, counts.get(level) + 1);
            } else {
                sums.add(1.0 * root.val);
                counts.add(1);
            }
            dfs(root.left, level + 1, counts, sums);
            dfs(root.right, level + 1, counts, sums);
        }
    }
}
