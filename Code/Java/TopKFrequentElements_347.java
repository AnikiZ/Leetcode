import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-29 20:35:42
 * @LastEditTime: 2022-06-29 21:45:54
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/TopKFrequentElements_347.java
 */
public class TopKFrequentElements_347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> cnts = new HashMap<Integer, Integer>();
            for (int num : nums) {
                cnts.put(num, cnts.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] n1, int[] n2) {
                    return n1[1] - n2[1];
                }
            });
            cnts.forEach((key, value) -> {
                if (queue.size() == k) {
                    if (queue.peek()[1] < value) {
                        queue.poll();
                        queue.offer(new int[]{key, value});
                    }
                } else {
                    queue.offer(new int[]{key, value});
                }
            });
            int[] ans = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                ans[i] = queue.poll()[0];
            }
            return ans;
        }
    }
}
