/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 03:02:38
 * @LastEditTime: 2022-07-29 03:06:53
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LinkedListRandomNode_382.java
 */
import java.util.Random;

public class LinkedListRandomNode_382 {

// Definition for singly-linked list.
   public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
class Solution {
    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    public int getRandom() {
        int ans = 0;
        int i = 1;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) {
                ans = node.val;
            }
            i++;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}
