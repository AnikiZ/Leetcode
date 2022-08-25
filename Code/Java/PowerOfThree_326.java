/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-28 22:16:19
 * @LastEditTime: 2022-07-28 22:16:20
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/PowerOfThree_326.java
 */
public class PowerOfThree_326 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            return (Math.log10(n) / Math.log10(3.0) % 1) == 0; 
        }
    }
}