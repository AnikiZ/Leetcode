/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 15:47:55
 * @LastEditTime: 2022-08-20 16:03:18
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/RemoveDuplicatesFromSortedList_83.java
 */
package LinkedList;

public class RemoveDuplicatesFromSortedList_83 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 细心一点！三个一样会怎样，11 2 33会怎样，什么情况下才node = node.next
            ListNode node = head;
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 15:47:55
 * @LastEditTime: 2022-08-20 15:47:56
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/RemoveDuplicatesFromSortedList_83.java
 */
