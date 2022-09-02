/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-09-01 22:12:14
 * @LastEditTime: 2022-09-01 23:00:08
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/TwoSumIV_InputIsaBST_653.java
 */
package Tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TwoSumIV_InputIsaBST_653 {
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
    class Solution {
        
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer> set = new HashSet<>();
            boolean ans = false;
            ans = inorder(root, set, k);
            return ans;
        }
        private boolean inorder(TreeNode root, HashSet<Integer> set, int k) {
            if (root == null) {
                return false;
            }
            
            
            if (set.contains(k - root.val)) {
                return true;
            }
            set.add(root.val);
            
            return inorder(root.left, set, k) || inorder(root.right, set, k);
        }
    }
    class Solution_SetBFS {
        // 目标只需要把所有节点遍历一遍，用queue实现BFS即可，更好写，用set存节点，每次poll判断set里有没有匹配
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<Integer>();
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return false;
        }
    }
}
