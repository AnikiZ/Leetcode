/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 16:00:26
 * @LastEditTime: 2022-07-29 16:12:43
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/AddBinary_67.java
 */
public class AddBinary_67 {
    class Solution {
        public String addBinary(String a, String b) {
            int len1 = a.length() - 1, len2 = b.length() - 1, add = 0;
            StringBuilder ans = new StringBuilder();
            while (len1 >= 0 || len2 >= 0 || add != 0) {
                // 注意 - '0'!!!!!!!!!
                int n1 = (len1 >= 0) ? a.charAt(len1) - '0' : 0;
                int n2 = (len2 >= 0) ? b.charAt(len2) - '0' : 0;
                // + add!!!!!!!
                int sum = (n1 + n2 + add);
                add = sum / 2;
                ans.append(String.valueOf(sum % 2));
                // --!!!!!!!
                len1--; len2--;
            }
            ans.reverse();
            return ans.toString();
        }
    }
}
