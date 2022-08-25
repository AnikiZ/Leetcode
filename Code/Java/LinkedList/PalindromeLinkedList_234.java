/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-19 21:25:13
 * @LastEditTime: 2022-08-20 00:54:28
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/PalindromeLinkedList_234.java
 */
package LinkedList;

public class PalindromeLinkedList_234 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);
            head.next.next.next.next = null;
            Solution.isPalindrome(head);
        }
        public static boolean isPalindrome(ListNode head) {
            // fast and slow pointer to get the middle in list
            // otherwise slow.next will be null, but doesn't matter
            // if (head.next == null) {
            //     return true;
            // }
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = reverseList(slow.next);
            ListNode start = head;
            while (slow != null) {
                if (slow.val == start.val) {
                    slow = slow.next;
                    start = start.next;
                } else {
                    return false;
                }
            }
            return true;
        }

        private static ListNode reverseList(ListNode node) {
            // 错在这了，必须prev为null!!!!!!这样最后倒过来尾部也是个null!
            ListNode prev = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }
    }
    class Solution_Recurssive {
        private ListNode frontPointer;
    
        private boolean recursivelyCheck(ListNode currentNode) {
            if (currentNode != null) {
                if (!recursivelyCheck(currentNode.next)) {
                    return false;
                }
                if (currentNode.val != frontPointer.val) {
                    return false;
                }
                frontPointer = frontPointer.next;
            }
            return true;
        }
    
        public boolean isPalindrome(ListNode head) {
            frontPointer = head;
            return recursivelyCheck(head);
        }
    }
}
