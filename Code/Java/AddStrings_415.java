/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-28 17:34:07
 * @LastEditTime: 2022-07-28 22:06:01
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/AddStrings_415.java
 */
public class AddStrings_415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length() - 1, len2 = num2.length() - 1, add = 0;
            StringBuilder sumReverse = new StringBuilder();
            while (len1 >= 0 || len2 >= 0 || add != 0) {
                int a = (len1 >= 0) ? num1.charAt(len1) - '0' : 0;
                int b = (len2 >= 0) ? num2.charAt(len2) - '0' : 0;
                int sum = a + b + add;
                sumReverse.append(sum % 10);
                add = sum / 10;
                len1--; len2--;
            }
            sumReverse.reverse();
            return sumReverse.toString();
        }
    }
}
