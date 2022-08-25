import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-07 23:26:34
 * @LastEditTime: 2022-07-08 15:34:16
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/BinaryTreePaths_257.java
 */
public class BinaryTreePaths_257 {
    
    //  * Definition for a binary tree node.
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            dfs(root, "", paths);
            return paths;
        }
        public void dfs(TreeNode root, String path, List<String> paths) {
            if (root != null) {
                StringBuffer newPath = new StringBuffer(path);
                newPath.append(root.val);
                if (root.left == null && root. right == null) {
                    paths.add(newPath.toString());
                    return;
                }
                newPath.append("->");
                dfs(root.left, newPath.toString(), paths);
                dfs(root.right, newPath.toString(), paths);
            }
        }
    }
}
