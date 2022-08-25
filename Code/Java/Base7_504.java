/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-28 14:03:00
 * @LastEditTime: 2022-07-28 16:28:59
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Base7_504.java
 */
public class Base7_504 {
    class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }
            int abs = num;
            if (num < 0) {
                abs = -num;
            }
            String ans = new String();
            while (abs != 0) {
                int remainder = abs % 7;
                // 注意顺序！！！
                ans = String.valueOf(remainder) + ans;
                abs = abs / 7;
            }
            return num < 0 ? "-" + ans : ans;
        }
    }
}