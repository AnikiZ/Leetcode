import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-29 22:15:25
 * @LastEditTime: 2022-07-01 16:03:24
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SortCharactersByFrequency_451.java
 */
public class SortCharactersByFrequency_451 {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> cnts = new HashMap<Character, Integer>();
            for (char c : s.toCharArray()) {
                cnts.put(c, cnts.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
                public int compare(Map.Entry<Character, Integer> n1, Map.Entry<Character, Integer> n2) {
                    return n2.getValue() - n1.getValue();
                }
            });
            // Entry是接口，没法new
            // cnts.forEach((x, y) -> {
            //     queue.offer(new Map.Entry<Character, Integer>(x, y));
            // });
            for (Map.Entry<Character, Integer> entry : cnts.entrySet()) {
                queue.offer(entry);
            }
            StringBuilder ans = new StringBuilder();
            while (!queue.isEmpty()) {
                Map.Entry<Character, Integer> entry = queue.poll();
                for (int i = 0; i < entry.getValue(); i++) {
                    ans.append(entry.getKey());
                }
            }
            return ans.toString();
        }
    }
}
