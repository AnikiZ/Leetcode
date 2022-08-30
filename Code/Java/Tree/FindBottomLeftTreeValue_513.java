/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-29 21:22:40
 * @LastEditTime: 2022-08-29 21:46:59
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/FindBottomLeftTreeValue_513.java
 */
package Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {
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
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode last = root;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size - 1; i++) {
                    TreeNode node = queue.poll();
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }
                last = queue.poll();
                if (last.right != null) {
                    queue.add(last.right);
                }
                if (last.left != null) {
                    queue.add(last.left);
                }
            }
            return last.val;
        }
    }
    class Solution_OfficialBFS {
        public int findBottomLeftValue(TreeNode root) {
            int ret = 0;
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                if (p.right != null) {
                    queue.offer(p.right);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                ret = p.val;
            }
            return ret;
        }
    }
}
