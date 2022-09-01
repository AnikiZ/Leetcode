/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-31 12:31:41
 * @LastEditTime: 2022-08-31 12:51:29
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/ConstructBinaryTreefromPreorderandPostorderTraversal_889.java
 */
package Tree;

import java.util.HashMap;

class ConstructBinaryTreefromPreorderandPostorderTraversal {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return recur(preorder, 0, preorder.length, postorder, 0, postorder.length);
        }
        private TreeNode recur(int[] pre, int preL, int preR, int[] post, int postL, int postR) {
            if (preL >= preR) {
                return null;
            }
            TreeNode root = new TreeNode(pre[preL]);
            if (preR - preL == 1) {
                return root;
            }
            int leftEnd = map.get(pre[preL + 1]);
            int leftLen = leftEnd - postL + 1;
            root.left = recur(pre, preL + 1, preL + leftLen + 1, post, postL, leftEnd + 1);
            root.right = recur(pre, preL + leftLen + 1, preR, post, leftEnd + 1, postR);
            return root;
        }
    }
}