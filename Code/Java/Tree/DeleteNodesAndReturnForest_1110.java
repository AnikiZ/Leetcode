/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 18:04:57
 * @LastEditTime: 2022-08-22 19:11:43
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/DeleteNodesAndReturnForest_1110.java
 */
package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesAndReturnForest_1110 {
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
        // 返回的是root集合！
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> ans = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i : to_delete) {
                set.add(i);
            }
            root = helper(root, set, ans);
            if (root != null) {
                ans.add(root);
            }
            return ans;
        }
        // helper判断该root需不需要被删除，先得到他的孩子，有可能会被删除，然后看自己，如果自己被删除但孩子
        // 不被，那么孩子就是新的root，加到ans中
        private TreeNode helper(TreeNode root, HashSet<Integer> set, List<TreeNode> ans) {
            if (root == null) {
                return null;
            }
            // 不对，传递的root.left到helper中，传了root.left的地址给root
            // 令root = null, 原来穿进去的root.left并不会是null，有问题，需要原来的也改变，更新新的连接情况
            // TreeNode left = helper(root.left, set, ans);
            // TreeNode right = helper(root.right, set, ans);
            // if (set.contains(root.val)) {
            //     if (left != null) {
            //         ans.add(left);
            //     }
            //     if (right != null) {
            //         ans.add(right);
            //     }
            //     root = null;
            // }
            root.left = helper(root.left, set, ans);
            root.right = helper(root.right, set, ans);
            if (set.contains(root.val)) {
                if (root.left != null) {
                    ans.add(root.left);
                }
                if (root.right != null) {
                    ans.add(root.right);
                }
                root = null;
            }
            return root;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 18:04:57
 * @LastEditTime: 2022-08-22 18:04:57
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/DeleteNodesAndReturnForest_1110.java
 */
