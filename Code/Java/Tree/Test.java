/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-22 19:05:21
 * @LastEditTime: 2022-11-30 11:28:05
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tree/Test.java
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> li = new ArrayList<>();
        li.add(0,1);
        li.add(0,2);
        System.out.println(li.toString());
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
