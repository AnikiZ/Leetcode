/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-19 15:43:47
 * @LastEditTime: 2022-08-19 15:45:36
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/ReverseLinkedList_206.java
 */
package LinkedList;

public class ReverseLinkedList_206 {
 //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            return reverseListRec(head, prev);
        }
        public ListNode reverseListRec(ListNode head, ListNode prev) {
            // corner case
            if (head == null) {
                return prev;
            }
            // base case
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            return reverseListRec(head, prev);
        }
    }
    class Solution_O {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
