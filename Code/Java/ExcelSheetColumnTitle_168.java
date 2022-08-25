/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 14:19:07
 * @LastEditTime: 2022-07-29 15:24:09
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ExcelSheetColumnTitle_168.java
 */
public class ExcelSheetColumnTitle_168 {
    class Solution {
        // 一般题: 0~25进制，这里是从1~26算作A~Z，那把数减一就一样了。
        public String convertToTitle(int columnNumber) {
            String ans = new String();
            while (columnNumber != 0) {
                columnNumber--;
                ans =(char)((columnNumber) % 26 + 'A') + ans;
                columnNumber = columnNumber / 26;
            }
            return ans;
        }
    }
}