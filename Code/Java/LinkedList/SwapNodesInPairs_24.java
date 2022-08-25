/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-19 16:20:16
 * @LastEditTime: 2022-08-19 16:54:14
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/SwapNodesInPairs_24.java
 */
package LinkedList;

public class SwapNodesInPairs_24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode p = head, s;
            // 有可能head == null!
            if (p != null && p.next != null) {
                s = p.next;
                p.next = s.next;
                s.next = p;
                head = s;
                while (p.next != null && p.next.next != null) {
                    s = p.next.next;
                    p.next.next = s.next;
                    s.next = p.next;
                    p.next = s;
                    p = s.next;
                }
            }
            return head;
        }
    }
    class Solution_Recursion {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;
        }
    }
}
