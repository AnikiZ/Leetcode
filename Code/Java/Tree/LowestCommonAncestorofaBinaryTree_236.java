/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-31 23:29:05
 * @LastEditTime: 2022-08-31 23:29:06
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/LowestCommonAncestorofaBinaryTree_236.java
 */
package Tree;

public class LowestCommonAncestorofaBinaryTree_236 {
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
        TreeNode ans = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            find(root, p, q);
            return ans;
        }
        private boolean find(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            boolean inCurrent = root.val == p.val || root.val == q.val;
            boolean inLeft = find(root.left, p, q);
            boolean inRight = find(root.right, p, q);
            if ((inLeft && inRight) || (inCurrent && inLeft) || (inCurrent && inRight)) {
                ans = root;
            }
            // return inLeft || inRight || root.val == p.val || root.val == q.val;多余，已经有inCurrent判断了！
            return inLeft || inRight || inCurrent;
        }
    }
}
