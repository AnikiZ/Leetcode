/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-31 18:11:54
 * @LastEditTime: 2022-08-31 18:46:43
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/BinaryTreeInorderTraversal_94.java
 */
package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
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
        List<Integer> ans = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
            return ans;
        }
    }
    class Solution_ColorStack {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            // 判断类型！
            Stack<Object> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                // pop的是Object!
                Object o = stack.pop();
                if (o == null) {
                    continue;
                }
                if (o instanceof TreeNode) {
                    // 得转换成treenode才行！
                    stack.add(((TreeNode)o).right);
                    stack.add(((TreeNode) o).val);
                    stack.add(((TreeNode) o).left);
                } else if (o instanceof Integer) {
                    ans.add((Integer) o);
                }
            }
            return ans;
        }
    }
}
