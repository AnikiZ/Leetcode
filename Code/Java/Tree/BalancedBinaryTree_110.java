/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-21 18:35:24
 * @LastEditTime: 2022-08-22 18:05:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/BalancedBinaryTree_110.java
 */
package Tree;

public class BalancedBinaryTree_110 {
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
        // 自底向上递归，时间O(n),空间O(n)
        public boolean isBalanced(TreeNode root) {
            return balanced(root) != -1;
        }
        private int balanced(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 这里还可以优化，先计算left，如果left就是-1不用计算right了
            // int left = balanced(root.left), right = balanced(root.right);
            // if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            //     return -1;
            // }
            int left, right;
            if ((left = balanced(root.left)) == -1 || (right = balanced(root.right)) == -1
             || Math.abs(left - right) > 1) {
                return -1;
             }
            return 1 + Math.max(left, right);
        }
    }
}
