/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-29 21:50:31
 * @LastEditTime: 2022-08-29 21:50:31
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/ConvertBSTToGreaterTree_538.java
 */
package Tree;

public class ConvertBSTToGreaterTree_538 {
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
        public TreeNode convertBST(TreeNode root) {
            add(root);
            return root;
        }
        private void add(TreeNode node) {
            if (node == null) {
                return;
            }
            add(node.right);
            // 傻逼了，sum应该加的是还没有增加的node.val!这样累加会变大很多！
            // node.val += sum;
            // sum += node.val;
            sum += node.val;
            node.val = sum;
            add(node.left);
        }
    }
}
