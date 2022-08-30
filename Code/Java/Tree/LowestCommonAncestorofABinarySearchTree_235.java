/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-29 22:38:55
 * @LastEditTime: 2022-08-30 02:23:55
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/LowestCommonAncestorofABinarySearchTree_235.java
 */
package Tree;

public class LowestCommonAncestorofABinarySearchTree_235 {
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // try in-order traverse肯定有问题，是找公共祖先！不一定一个就在另一个子树底下！
            // 最小公共祖先，一定是根节点到两点路径的分叉点，可以两次遍历得到路径然后比较，也可以一次，找共性：
            // 从根节点开始遍历，如果两个点都小于或者都大于该节点，则可以继续下移
            TreeNode anc = root;
            while (true) {
                if (p.val < anc.val && q.val < anc.val) {
                    anc = anc.left;
                } else if (p.val > anc.val && q.val > anc.val) {
                    anc = anc.right;
                } else {
                    break;
                }
            }
            return anc;
        }
    }
}
