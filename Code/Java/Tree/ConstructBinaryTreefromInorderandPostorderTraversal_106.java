/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-31 15:47:54
 * @LastEditTime: 2022-08-31 15:52:56
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/ConstructBinaryTreefromInorderandPostorderTraversal_106.java
 */
package Tree;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                map.put(inorder[i], i);
            }
            return recur(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }
        private TreeNode recur(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
            if (inL > inR) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postR]);
            int rootIndex = map.get(postorder[postR]);
            int leftLen = rootIndex - inL;
            // 仔细这里，到底是左闭右闭还是左闭右开！
            root.left = recur(inorder, inL, rootIndex - 1, postorder, postL, postL + leftLen - 1);
            root.right = recur(inorder, rootIndex + 1, inR, postorder, postL + leftLen, postR - 1);
            return root;
        }
    }
}
