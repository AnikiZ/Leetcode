/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-10-20 22:50:41
 * @LastEditTime: 2022-10-20 22:50:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Leetcode/Code/Java/OA/tiktok1.java
 */
package OA;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Tiktok1 {
    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        inputs.add(3);
        inputs.add(2);
        inputs.add(2);
        inputs.add(2);
        inputs.add(7);
        System.out.println(Solution.minUniqueArray(inputs));

    }
    class Solution {
        public static int minUniqueArray(List<Integer> inputs) {
            Collections.sort(inputs);
            int len = inputs.size();
            int sum = inputs.get(0);
            int prev = inputs.get(0);
            for (int i = 1; i < len; i++) {
                int curr = inputs.get(i);
                if (curr <= prev) {
                    curr = prev + 1;
                }
                sum += curr;
                prev = curr;
            }
            return sum;
        }
    }
}
