/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-01 00:51:25
 * @LastEditTime: 2022-08-01 00:51:26
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/BinaryNumberWithAlternatingBits_693.java
 */
public class BinaryNumberWithAlternatingBits_693 {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int a = n ^ (n >> 1);
            return (a & (a + 1)) == 0;
        }
    }
}
