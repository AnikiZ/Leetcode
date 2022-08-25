package LinkedList;

public class MergeTwoSortedLists_21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        // Recurssion method
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val > list2.val) {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
    class Solution_O {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(), node = head;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    node.next = list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    list2 = list2.next;
                }
                node = node.next;
            }
            node.next = list1 == null ? list2 : list1;
            return head.next;
        }
    }
}
