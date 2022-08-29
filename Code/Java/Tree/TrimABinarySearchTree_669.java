/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-24 15:08:12
 * @LastEditTime: 2022-08-25 19:45:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/TrimABinarySearchTree_669.java
 */
package Tree;

public class TrimABinarySearchTree_669 {
    class Solution {
        public static class TreeNode {
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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            if (root.val < low) {
                return trimBST(root.right, low, high);
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
