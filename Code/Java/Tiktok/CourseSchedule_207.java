/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-21 16:23:31
 * @LastEditTime: 2022-11-21 17:20:26
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/CourseSchedule_207.java
 */
package Tiktok;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule_207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses == 1) {
                return true;
            }
            int inDegrees[] = new int[numCourses];
            // HashMap<Integer, List<Integer>> map = new HashMap<>();
            // Wrong: no guarantee that the course is in the map!
            // for (int[] pre : prerequisites) {
            //     // [0, 1] : 1 -> 0
            //     // check if pre[1] not in the map; Y: value = new list
            //     map.computeIfAbsent(pre[1], k -> new ArrayList<Integer>());
            //     map.get(pre[1]).add(pre[0]);
            //     inDegrees[pre[0]]++;
            // }
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] pre : prerequisites) {
                adj.get(pre[1]).add(pre[0]);
                inDegrees[pre[0]]++;
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < numCourses ; i++) {
                if (inDegrees[i] == 0) {
                    q.add(i);
                }
            }
            int num = 0;
            while (!q.isEmpty()) {
                int course = q.pop();
                num++;
                
                for (int i : adj.get(course)) {
                    inDegrees[i]--;
                    if (inDegrees[i] == 0) {
                        q.add(i);
                    }
                }
            }
            if (num == numCourses) {
                return true;
            }
            return false;
        }
    }
}
