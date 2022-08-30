/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-29 18:00:20
 * @LastEditTime: 2022-08-29 18:00:47
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/SumofLeftLeaves_404.java
 */
package Tree;

public class SumofLeftLeaves_404 {
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
        int sum = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            add(root.left, 1);
            add(root.right, 2);
            return sum;
        }
        private void add(TreeNode node, int t) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null && t == 1) {
                sum += node.val;
            }
            add(node.left, 1);
            add(node.right, 2);
        }
    }
}
