/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-21 23:23:30
 * @LastEditTime: 2022-08-22 03:16:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/PathSumIII_437.java
 */
package Tree;

import java.util.HashMap;

public class PathSumIII_437 {
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
        // O(n^2)，有很多重复计算
        public int pathSum(TreeNode root, int targetSum) {
            return root == null ? 0 : pathSumStartAt(root, targetSum) + pathSum(root.left, targetSum)
                                + pathSum(root.right, targetSum);
            // int count = 0;
            // if (root == null) {
            //     return 0;
            // }
            // if (root.val == targetSum) {
            //     count++;
            // }
            // // 这么写是不对的，这样相当于路径必须包括了这个root,注释部分相当于是pathSumStartAt(root, targetSum)部分
            // count += pathSum(root.left, targetSum - root.val);
            // count += pathSum(root.right, targetSum - root.val);
            // return count;
        }
        // 改为long，有测试卡
        // 辅助函数，表示从该点开始连续往下

        private int pathSumStartAt(TreeNode root, long targetSum) {
            // int count = 0;
            if (root == null) {
                return 0;
            }
            // if (root.val == targetSum) {
            //     count++;
            // }
            int count = root.val == targetSum ? 1 : 0;
            count += pathSumStartAt(root.left, targetSum - root.val);
            count += pathSumStartAt(root.right, targetSum - root.val);
            return count;
        }
    }
    // dfs + 前缀和保存路径前缀和避免重复计算
    // 树，不存在环，前缀和可以用，从根节点出发有且仅有一条路径
    // 时间空间都是O(n),每个节点只遍历一次
    class Solution_DFS {
        public int pathSum(TreeNode root, int targetSum) {
            HashMap<Long, Integer> prefix = new HashMap<>();
            // 保存空路径！细节，考虑corner case，有可能就是从起点开始前缀和满足target
            prefix.put(0L, 1);
            return dfs(root, prefix, 0, targetSum);
        }
        public int dfs(TreeNode root, HashMap<Long, Integer> prefix, long curr, int targetSum) {
            if (root == null) {
                return 0;
            }
            int ret = 0;
            curr += root.val;

            ret = prefix.getOrDefault(curr - targetSum, 0);
            prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
            
            ret += dfs(root.left, prefix, curr, targetSum);
            ret += dfs(root.right, prefix, curr, targetSum);

            // 退出该状态！
            prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

            return ret;
        }
    }
}
