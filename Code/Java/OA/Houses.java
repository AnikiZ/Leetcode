/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-31 09:09:23
 * @LastEditTime: 2022-10-31 09:30:47
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/OA/Houses.java
 */
package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Houses {
    static int[] res(int[] houses, int[] queries) {
        int[] res = new int[queries.length];
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int num = houses.length;
        for (int i = 0; i < num; i++) {
            if (i == 0 || houses[i] != houses[i - 1] + 1) {
                List<Integer> list = new ArrayList<>();
                list.add(houses[i]);
                lists.add(list);
                map.put(houses[i], lists.size() - 1);
            } else {
                int in = map.get(houses[i - 1]);
                List<Integer> list = lists.get(in);
                list.add(houses[i]);
                map.put(houses[i], in);
            }
        }
        int r = lists.size();
        for (int i = 0; i < queries.length; i++) {
            int in = map.get(queries[i]);
            List<Integer> list = lists.get(in);
            list.remove(Integer.valueOf(queries[i]));
            if (list.size() == 0) {
                r--;
            }
            res[i] = r;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 6, 7, 9};
        int[] queries = {6, 7, 2, 3, 1, 9};
        int[] res = Houses.res(houses, queries);
        System.out.println(Arrays.toString(res));
    }
}
