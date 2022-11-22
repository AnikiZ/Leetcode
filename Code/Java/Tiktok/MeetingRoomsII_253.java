/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-21 23:40:37
 * @LastEditTime: 2022-11-21 23:58:09
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/MeetingRoomsII_253.java
 */
package Tiktok;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {
    public static void main(String[] args) {
        int[][] intervals = {{7,10},{2,4}};
        System.out.println(Solution.minMeetingRooms(intervals));
    }
    static class Solution {
        public static int minMeetingRooms(int[][] intervals) {
            // find intervals that has max overlaps
            // Arrays.sort(intervals, new Comparator<int[]>() {
            //     public int compare(int[] a, int[] b) {
            //         return a[0] - b[0];
            //     }
            // });
            
            if (intervals.length == 1) {
                return 1;
            }
            int room = 1;
            Arrays.sort(intervals, (a, b) -> {
                return a[0] - b[0];
            });
            // PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //     public int compare(int[] a, int[] b) {
            //         return a[1] - b[1];
            //     }
            // });
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
                return a - b;
            });
            pq.add(intervals[0][1]);
            for (int i = 1; i < intervals.length; i++) {
                while (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                    pq.poll();
                }
                pq.add(intervals[i][1]);
                room = Math.max(room, pq.size());
            }
            return room;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-21 23:40:37
 * @LastEditTime: 2022-11-21 23:40:38
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/MeetingRoomsII_253.java
 */
