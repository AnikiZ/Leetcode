/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-22 18:16:54
 * @LastEditTime: 2022-06-22 18:16:54
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedListCircleII_142.java
 */
public class LinkedListCircleII_142 {
//  Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // check whether has a circle(encounter)
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
}
