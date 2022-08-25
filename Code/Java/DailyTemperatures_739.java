import java.util.Stack;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-08 20:41:42
 * @LastEditTime: 2022-08-09 01:39:37
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/DailyTemperatures_739.java
 */
public class DailyTemperatures_739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> temp = new Stack<Integer>();
            int[] ans = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                while (!temp.isEmpty()) {
                    int t = temp.peek();
                    System.out.println("t = " + t + "i=" + temperatures[i]);
                    if (temperatures[t] >= temperatures[i]) {
                        System.out.println("t = " + t + "i=" + temperatures[i]);
                        break;
                    }
                    ans[t] = i - t;
                    temp.pop();
                }
                temp.push(i);
            }
            return ans;
        }
    }
}
