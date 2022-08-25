package Hash;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-11 17:09:32
 * @LastEditTime: 2022-08-12 12:31:37
 * @LastEditors: Zeping Zhu
 * @Description: 时间O(mlogm), m为边数量，每条边logm时间插入和删除各一次 空间O(m),存m个边
 * 
 * @FilePath: /Code/Java/Hash/ReconstructItinerary_332.java
 */
public class ReconstructItinerary_332 {
    class Solution {
        public static void main(String[] args) {
            List<List<String>> tickets = new ArrayList<>();
            List<String> ticket1 = new ArrayList<>();
            ticket1.add("MUC");ticket1.add("LHR");
            tickets.add(ticket1);
            List<String> ticket2 = new ArrayList<>();
            ticket2.add("JFK");ticket2.add("MUC");
            tickets.add(ticket2);
            // System.out.println(Solution.findItinerary(tickets));
        }
        public List<String> findItinerary(List<List<String>> tickets) {
            if (tickets.size() == 1) {
                return tickets.get(0);
            }
            HashMap<String, PriorityQueue<String>> map = new HashMap<>();

            List<String> ans = new ArrayList<>();
            for (List<String> ticket : tickets) {
                String start = ticket.get(0);
                String end = ticket.get(1);
                // PriorityQueue<String> a = new PriorityQueue<>();
                // a.add("a")
                // 不对的原因是a.add方法不会返回一个q，不符合value要求
                // map.put(start, a.add("a"));
                // if (!map.containsKey(start)) {
                //     PriorityQueue<String> queue = new PriorityQueue<>();
                //     queue.add(end);
                //     map.put(start, queue);
                // } else {
                //     PriorityQueue<String> queue = map.get(start);
                //     queue.add(end);
                // }
                // 一样
                if (!map.containsKey(start)) {
                    map.put(start, new PriorityQueue<String>());
                }
                map.get(start).offer(end);
            }
            // 这么写有问题，想得太简单了没有考虑到JFK可能有很多重复的票
            // 一味只选最小的终点可能导致无法形成完整通路
            // String cur = "JFK";
            // ans.add(cur);
            
            // while (map.containsKey(cur) && map.get(cur).size() != 0) {
            //     String next = map.get(cur).first();
            //     ans.add(next);
            //     map.get(cur).remove(next);
            //     cur = next;
            // }
            dfs(ans, "JFK", map);
            Collections.reverse(ans);
            return ans;
        }
        public void dfs(List<String> ans, String cur, HashMap<String, PriorityQueue<String>> map) {
            PriorityQueue<String> q = map.get(cur);
            // 注意要判断是否为null！然后在看大小！
            while (q != null && !q.isEmpty()) {
                dfs(ans, q.poll(), map);
            }
            ans.add(cur);
        }
    }
}
