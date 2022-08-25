import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-09 17:57:49
 * @LastEditTime: 2022-08-10 13:05:26
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SlidingWindowMaximum_239.java
 */
public class SlidingWindowMaximum_239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                if (!dq.isEmpty() && (i - dq.getFirst()) == k) {
                    dq.removeFirst();
                }
                while (!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
                    dq.removeLast();
                }
                dq.addLast(i);
                if (i >= k - 1) {
                    ans[i - (k - 1)] = nums[dq.getFirst()];
                }
            }
            return ans;
        }
    }
}
