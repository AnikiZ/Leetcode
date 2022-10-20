/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-19 19:03:02
 * @LastEditTime: 2022-10-19 19:20:39
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/Graph/CourseScheduleII_210.java
 */
package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseScheduleII_210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int inDegree[] = new int[numCourses];
            int[] result = new int[numCourses];
            int index = 0;
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<Integer>());
            }
            for (int[] pre : prerequisites) {
                edges.get(pre[1]).add(pre[0]);
                inDegree[pre[0]]++;
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i]==0) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                int node = q.pop();
                result[index++] = node;
                for (int c : edges.get(node)) {
                    inDegree[c]--;
                    if (inDegree[c]==0) {
                        q.add(c);
                    }
                }
            }
            if (index==numCourses) {
                return result;
            } else {
                return new int[0];
            }
        }
    }
}
