/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-24 15:56:10
 * @LastEditTime: 2022-08-24 16:03:45
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/InvertBinaryTree_226.java
 */
package Tree;

public class InvertBinaryTree_226 {
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 先存起来，不然
            TreeNode left = root.left;
            TreeNode right = root.right;
            // 不然这一行，root.left就会变，放入root.right就会出错！
            root.left = invertTree(right);
            root.right = invertTree(left);

            // 或者这样，先把左右颠倒并得到对应左右子树的root，然后root左右子树调换
            // TreeNode left = invertTree(root.left);
            // TreeNode right = invertTree(root.right);
            // root.left = right;
            // root.right = left;
            return root;
        }
    }
}
