/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-23 16:39:42
 * @LastEditTime: 2022-06-23 16:39:42
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ValidPalindromeII_680.java
 */
public class ValidPalindromeII_680 {
    class Solution {
        // must write outside!
        int del = 0;
        public boolean validPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    if (del == 0) {
                        del++;
                        // 左闭右开！！！
                        return validPalindrome(s.substring(i, j)) || validPalindrome(s.substring(i + 1, j + 1)); 
                    }
                    return false;
                }
            }
            return true;
        }
    }
}
