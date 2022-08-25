/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-30 14:09:55
 * @LastEditTime: 2022-07-30 14:09:55
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/HammingDistance_461.java
 */
public class HammingDistance_461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int diff = x ^ y;
            int num = 0;
            while (diff != 0) {
                num += diff & 1;
                diff = diff >> 1;
            }
            return num;
        }
    }
}
