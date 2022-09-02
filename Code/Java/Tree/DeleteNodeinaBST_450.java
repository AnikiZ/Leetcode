/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-09-01 23:00:48
 * @LastEditTime: 2022-09-02 17:20:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/DeleteNodeinaBST_450.java
 */
package Tree;

public class DeleteNodeinaBST_450 {
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
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode curr = root,  currParent = null;
            while (curr != null && curr.val != key) {
                currParent = curr;
                if (curr.val < key) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            if (curr == null) {
                // 没找到，返回root
                return root;
            }
            if (curr.right == null && curr.left == null) {
                curr = null;
            } else if (curr.right == null) {
                curr = curr.left;
            } else if (curr.left == null) {
                curr = curr.right;
            } else  {
                TreeNode successor = curr.right;
                TreeNode successorParent = curr;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }
                if (successor == curr.right) {
                    curr.right = successor.right;
                } else {
                    successorParent.left = successor.right;
                }
                    successor.left = curr.left;
                    successor.right = curr.right;
                    curr = successor;
            }
            if (currParent == null) {
                return curr;
            }
            // 查看是左孩子还是右孩子，这时候curr已经改变，所以应该用key来检查
            if (currParent.left != null && currParent.left.val == key) {
                currParent.left = curr;
            } else {
                currParent.right = curr;
            }
            return root;
        }
    }
    // O(n), O(n)
    class Solution_Recurssion {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
                return root;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
                return root;
            }
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    root = null;
                    return root;
                } else if (root.left == null) {
                    root = root.right;
                    return root;
                } else if (root.right == null) {
                    root = root.left;
                    return root;
                } else {
                    TreeNode successor = root.right;
                    while (successor.left != null) {
                        successor = successor.left;
                    }
                    root.right = deleteNode(root.right, successor.val);
                    successor.right = root.right;
                    successor.left = root.left;
                    return successor;
                }
                
            }
            return root;
        }
    }
}
