/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-31 22:41:04
 * @LastEditTime: 2022-08-31 22:41:04
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/BinaryTreePostorderTraversal_145.java
 */
package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<Object> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Object o = stack.pop();
                if (o == null) {
                    continue;
                }
                if (o instanceof TreeNode) {
                    stack.add(((TreeNode) o).val);
                    stack.add(((TreeNode) o).right);
                    stack.add(((TreeNode) o).left);
                } else if (o instanceof Integer) {
                    ans.add((Integer) o);
                }
            }
            return ans;
        }
    }
}
