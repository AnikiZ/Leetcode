/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-09-01 15:35:11
 * @LastEditTime: 2022-09-04 23:04:55
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/Tree/ConvertSortedListtoBinarySearchTree_109.java
 */
package Tree;

public class ConvertSortedListtoBinarySearchTree_109 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
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
        public TreeNode sortedListToBST(ListNode head) {
            return build(head, null);
        }
        private TreeNode build(ListNode start, ListNode end) {
            if (start == end) {
                return null;
            }
            ListNode mid = getMid(start, end);
            TreeNode root = new TreeNode(mid.val);
            root.left = build(start, mid);
            root.right = build(mid.next, end);
            return root;
        }
        private ListNode getMid(ListNode start, ListNode end) {
            ListNode slow = start, fast = start;
            while (fast != end && fast.next != end) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

}
