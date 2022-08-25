/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-30 15:35:45
 * @LastEditTime: 2022-07-30 15:36:47
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaximumLevelSumOfABinaryTree_1161.java
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree_1161 {

// Definition for a binary tree node.
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
    public int maxLevelSum(TreeNode root) {
        // List<Integer> floors = new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        int max = root.val;
        int floor = 0, ans = 1;
        queue.add(root);
        ans = dfs(queue, root, max, floor, ans);
        return ans;
    }
    public int dfs(Queue<TreeNode> queue, TreeNode root, int max, int floor, int ans) {
        while (!queue.isEmpty()) {
            floor++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (sum > max) {
                max = sum;
                ans = floor;
            }
        }
        return ans;
    }
}
}
