/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 18:55:12
 * @LastEditTime: 2022-08-21 02:24:16
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedList/SortList_148.java
 */
package LinkedList;

public class SortList_148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 这个好，递归写起来简单，自底向上有点麻烦
    class Solution {
        // merge sort by recurssion
        // O(nlogn) O(logn)递归栈空间
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rightNode = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(rightNode);

            // merge sort
            ListNode dummy = new ListNode();
            ListNode node = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
                node = node.next;
            }
            node.next = left == null ? right : left;
            return dummy.next;
        }
    }
    class Solution_O1 {
        // 记得要让一段结束最后是null!
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }

            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }

            ListNode dummy = new ListNode(0, head);

            for (int subLen = 1; subLen < len; subLen <<= 1) {
                ListNode prev = dummy, curr = dummy.next;
                while (curr != null) {
                    // 得到左边那条链并让最后end是null,最后一段长度可能不够，所以next为null就停
                    ListNode head1 = curr;
                    for (int i = 1; i < subLen && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    // 得到右边另一半链，有可能curr直接就是null了
                    for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    // next 是下一次的head1，给curr的，考虑curr是否为null，提前让next为null
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }

                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return dummy.next;
        }
        public ListNode merge(ListNode node1, ListNode node2) {
            ListNode dummy = new ListNode();
            ListNode node = dummy;

            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    node.next = node1;
                    node1 = node1.next;
                } else {
                    node.next = node2;
                    node2 = node2.next;
                }
                node = node.next;
            }
            node.next = node1 == null ? node2 : node1;
            return dummy.next;
        }
    }
}
