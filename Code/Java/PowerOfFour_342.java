public class PowerOfFour_342 {
    class Solution {
        public boolean isPowerOfFour(int n) {
            // n > 0 and n is multple of two and has no one in odd bits
            return n > 0 && ((n & (n - 1)) == 0) && (n & (0xaaaaaaaa)) == 0;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-31 15:14:04
 * @LastEditTime: 2022-07-31 15:20:48
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/PowerOfFour_342.java
 */
