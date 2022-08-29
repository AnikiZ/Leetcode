/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-24 01:59:08
 * @LastEditTime: 2022-08-25 19:43:28
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/RecoverBinarySearchTree_99.java
 */
package Tree;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
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
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null, y = null, prevSmaller = null;
        // if (root != null) {
        //     stack.push(root);
        // }
        // 加一个或者root != null不然初始过不了
        while (!stack.isEmpty() || root != null) {
            // 还是从root判断，否则
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prevSmaller != null && root.val < prevSmaller.val) {
                y = root;
                if (x == null) {
                    x = prevSmaller;
                } else {
                    break;
                }
            }
            prevSmaller = root;
            // 有可能为null!，所以上面while还是以root判断比较好
            root = root.right;
        }
        // swap
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
