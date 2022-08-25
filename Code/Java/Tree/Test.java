/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 19:05:21
 * @LastEditTime: 2022-08-22 19:09:58
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/Test.java
 */
package Tree;

public class Test {
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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode ans = clear(root);
        System.out.println(ans.val);
        System.out.println(root.val);
        int a = 45;
        add(a);
        System.out.println(a);
    }
    private static TreeNode clear(TreeNode root) {
        // root = null;
        root.val = 3;
        return root;
    }
    private static void add(int a) {
        a++;
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 19:05:21
 * @LastEditTime: 2022-08-22 19:05:21
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Tree/Test.java
 */
