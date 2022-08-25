/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-21 19:05:35
 * @LastEditTime: 2022-08-22 02:37:31
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/DiameterOfBinaryTree_543.java
 */
package Tree;

public class DiameterOfBinaryTree_543 {
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
        int diameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            // 这么写的话diameter是不是全局无所谓了，因为是基本数据类型，helper的diameter是独立的！
            // helper(root, diameter);
            helper(root);
            return diameter;
        }
        // wrong!
        // private int helper(TreeNode root, int diameter) {
        //     if (root == null) {
        //         return 0;
        //     }
        //     int left = helper(root.left, diameter);
        //     int right = helper(root.right, diameter);
        //     diameter = Math.max(left + right, diameter);
        //     return 1 + Math.max(left, right);
        // }
        // 理解为节点个数，除去该点自身，左右子节点总数和 周长
        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = helper(root.left);
            int right = helper(root.right);
            diameter = Math.max(left + right, diameter);
            return 1 + Math.max(left, right);
        }
    }
}
