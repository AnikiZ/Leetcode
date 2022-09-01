/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-31 11:27:14
 * @LastEditTime: 2022-08-31 12:26:28
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/MinimumAbsoluteDifferenceinBST_530.java
 */
package Tree;

public class MinimumAbsoluteDifferenceinBST_530 {
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
        int ans = Integer.MAX_VALUE;
        int prev = -1; // range >= 0
        public int getMinimumDifference(TreeNode root) {
            // utilize the feature of bfs, inorder traverse get increasing order
            // minimum difference must be from two adjacent elements
            inOrder(root);
            return ans;
        }
        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            if (prev == -1) {
                prev = node.val;
            } else {
                ans = Math.min(ans, Math.abs(prev - node.val));
                prev = node.val;
            }
            inOrder(node.right);
        }
    }
}
