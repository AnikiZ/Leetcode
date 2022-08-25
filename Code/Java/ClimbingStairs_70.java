/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-10 17:04:51
 * @LastEditTime: 2022-07-10 17:04:52
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ClimbingStairs_70.java
 */
public class ClimbingStairs_70 {
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            // pre1: 到达下一楼方法数 pre2: 到达下两楼的方法数
            int pre1 = 2, pre2 = 1, cur = 3;
            for (int i = 3; i <= n; i++) {
                cur = pre1 + pre2;
                pre2 = pre1;
                pre1 = cur;
            }
            return cur;
        }
    }
}
