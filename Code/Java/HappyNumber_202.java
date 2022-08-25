import java.util.HashSet;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 22:58:07
 * @LastEditTime: 2022-07-29 23:01:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/HappyNumber_202.java
 */
public class HappyNumber_202 {
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<>();
            while (true) {
                n = happy(n);
                if (n == 1) {
                    return true;
                }
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
            }
        }
        public int happy(int n) {
            int happy = 0, remainder = 0;
            while (n != 0) {
                remainder = n % 10;
                happy += remainder * remainder;
                n = n / 10;
            }
            return happy;
        }
    }
}
