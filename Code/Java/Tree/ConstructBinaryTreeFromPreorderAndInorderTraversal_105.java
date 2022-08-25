/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 23:19:38
 * @LastEditTime: 2022-08-23 16:37:35
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/ConstructBinaryTreeFromPreorderAndInorderTraversal_105.java
 */
package Tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = preorder.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(inorder[i], i);
            }
            // 这边用 len, 左闭右开的包含！截止条件是preStart >= preEnd，
            // 试想一下右边就一个的情况
            return recurBuild(preorder, 0, len, inorder, 0, len, map);
        }
        private TreeNode recurBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
            if (preStart >= preEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRootIndex = map.get(preorder[preStart]);

            int leftNum = inRootIndex - inStart;
            root.left = recurBuild(preorder, preStart + 1, preStart + leftNum + 1, inorder, inStart, inStart + leftNum, map);
            root.right = recurBuild(preorder, preStart + leftNum + 1, preEnd, inorder, inRootIndex + 1, inEnd, map);

            return root;
        }
    }
    class Solution_Stack {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            stack.push(root);
            int inorderIndex = 0;
            for (int i = 1; i < preorder.length; i++) {
                int preorderVal = preorder[i];
                TreeNode node = stack.peek();
                if (node.val != inorder[inorderIndex]) {
                    node.left = new TreeNode(preorderVal);
                    stack.push(node.left);
                } else {
                    // 寻找右节点父亲，即为最后pop出来的那个，有可能会让stack变空到顶(root的右子树)，也有可能提前不相等结束(root左子树的)
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }
            return root;
        }
    }
}
