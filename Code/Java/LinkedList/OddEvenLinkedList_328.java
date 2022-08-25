/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 16:06:44
 * @LastEditTime: 2022-08-20 16:40:04
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/OddEvenLinkedList_328.java
 */
package LinkedList;

public class OddEvenLinkedList_328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode odd = head, evenhead = odd.next, even = odd.next;
            while (even != null && even.next != null) {
                // 看这边会用到什么的next,那么必须不为null，用到了even 和 even.next的next，所以判断这两个
                odd.next = even.next;
                odd = even.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenhead;
            return head;
        }
    }
}
