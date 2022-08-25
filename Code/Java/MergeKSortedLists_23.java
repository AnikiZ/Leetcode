import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
/**
 * Definition for singly-linked list.
 */
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode ans = new ListNode();
            ListNode t = ans;
            PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode n1, ListNode n2) {
                    return n1.val - n2.val;
                }
            });
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }
            while (!queue.isEmpty()) {
                t.next = queue.poll();
                t = t.next;
                if (t.next != null) {
                    queue.add(t.next);
                }
            }
            return ans.next;
        }
    }
}
