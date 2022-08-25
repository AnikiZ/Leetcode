/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-19 17:04:13
 * @LastEditTime: 2022-08-19 20:08:24
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/IntersectionOfTwoLinkedLists_160.java
 */
package LinkedList;

public class IntersectionOfTwoLinkedLists_160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Solution {
        // 一般想到的都是哈希集合，这个可以空间O(1)
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (a != b) {
                // 跑到底去另一个头跑，最后两个跑的距离能够一样同时到达相交点
                a = a == null ? headA : a.next;
                b = b == null ? headB : b.next;
            }
            return a;
        }
    }
}
