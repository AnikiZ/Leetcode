/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-25 15:32:47
 * @LastEditTime: 2022-11-25 16:30:24
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/TaskScheduler_621.java
 */
package OA;

import java.util.Arrays;

public class TaskScheduler_621 {
    class Solution {
        public static void main(String[] args) {
            // char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
            char[] tasks = {'A','A','A','B','C'};
            int t =Solution.leastInterval(tasks, 2);
            System.out.println(t);

        }
        public static int leastInterval(char[] tasks, int n) {
            int term = 0;
            int len = tasks.length;
            int[] remaining = new int[26];
            for (char c : tasks) {
                remaining[c-'A']++;
            }
            int[] nextValid = new int[26];
            Arrays.fill(nextValid, 1);
            for (int i = 0; i < len; i++) {
                term++;
                int minNext = Integer.MAX_VALUE;
                // 这儿有问题，因为存的这26个里有remaining位0的废物节点，
                // 他们的next必定是1，所以这里还要判断remaining有没有效
                // opt: 不用int存，用list存所有有效的task！
                for (int t = 0; t < 26; t++) {
                    if (remaining[t] > 0) {
                        minNext = Math.min(minNext, nextValid[t]);
                    }
                }
                term = Math.max(term, minNext);
                int maxRemainIndex = -1;
                for (int m = 0; m < 26; m++) {
                    if (remaining[m] > 0 && nextValid[m] <= term) {
                        if (maxRemainIndex == -1 || remaining[m] > remaining[maxRemainIndex]) {
                            maxRemainIndex = m;
                        } 
                    }
                }
                remaining[maxRemainIndex]--;
                nextValid[maxRemainIndex] = term + n + 1;
            }
            return term;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-25 15:32:47
 * @LastEditTime: 2022-11-25 15:32:47
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/OA/TaskSchedular_621.java
 */
