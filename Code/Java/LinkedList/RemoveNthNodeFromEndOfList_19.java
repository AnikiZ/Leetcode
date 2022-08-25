/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 16:41:53
 * @LastEditTime: 2022-08-20 18:05:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/RemoveNthNodeFromEndOfList_19.java
 */
package LinkedList;

public class RemoveNthNodeFromEndOfList_19 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head, dummy = new ListNode(0, head), pre = dummy;
            while (n > 1) {
                fast = fast.next;
                n--;
            }
            while (fast != null && fast.next != null) {
                pre = pre.next;
                fast = fast.next;
            }
            // 记住对head做特殊判断！
            // if (slow == head) {
            //     head = head.next;
            //     return head;
            // }
            // 或者用dummy node去做！
            
            pre.next = pre.next.next;
            return dummy.next;
        }
    }
}
