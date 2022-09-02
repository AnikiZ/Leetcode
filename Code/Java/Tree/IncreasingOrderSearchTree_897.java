/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-09-01 21:34:01
 * @LastEditTime: 2022-09-01 21:35:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/IncreasingOrderSearchTree_897.java
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree_897 {
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
        List<TreeNode> list = new ArrayList<>();
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            add(res, root);

            TreeNode dummy = new TreeNode(-1);
            TreeNode curr = dummy;
            for (int value : res) {
                curr.right = new TreeNode(value);
                curr = curr.right;
            }
            return dummy.right;
            // 这么写有风险，因为加入的是节点，需要重新配置左右子节点，如果直接往list加的是value就不用考虑
            // 另外，考虑使用dummy节点来更方便的返回head
            // add(list, root);
            // TreeNode ans = null;
            // TreeNode n = ans;
            // for (TreeNode node : list) {
            //     if (ans == null) {
            //         ans = node;
            //         n = ans;
            //         continue;
            //     }
            //     n.left = null;
            //     n.right = node;
            //     n = node;
            // }
            // n.left = null; n.right = null;
            // return ans;
        }
        private void add(List<Integer> list, TreeNode root) {
            if (root == null) {
                return;
            }
            add(list, root.left);
            list.add(root.val);
            add(list, root.right);
            return;
        }
    }
}