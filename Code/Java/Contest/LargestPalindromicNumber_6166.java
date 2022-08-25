/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-21 00:00:33
 * @LastEditTime: 2022-08-21 00:00:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Contest/LargestPalindromicNumber_6166.java
 */
package Contest;

public class LargestPalindromicNumber_6166 {
    class Solution {
        public static void main(String[] args) {
            String ans = Solution.largestPalindromic("442");
        }
        public static String largestPalindromic(String num) {
            int[] nums = new int[10];
            int len = num.length();
            for (int i = 0; i < len; i++) {
                nums[num.charAt(i) - '0']++;
            }
            StringBuilder ans = new StringBuilder();
            boolean odd = false;
            int oddNum = -1;
            for (int i = 9; i > 0; i--) {
                int count = nums[i];
                if (!odd) {
                    for (int j = 0; j < count / 2; j++) {
                        ans.append(i);
                    }
                    if (count % 2 != 0) {
                        odd = true;
                        oddNum = i;
                    }
                } else {
                    for (int j = 0; j < count / 2; j++) {
                        ans.append(i);
                    }
                }
            }
            if (ans.length() > 0) {
                for (int j = 0; j < nums[0] / 2; j++) {
                    ans.append('0');
                }
                if (!odd && nums[0] % 2 != 0) {
                    odd = true;
                    oddNum = 0;
                }
            }
            // reverse完了原来的stringBuilder也变了！还有深浅拷贝！
            StringBuilder realAns = new StringBuilder();
            for (int i = 0; i < ans.length(); i++) {
                realAns.append(ans.charAt(i));
            }
            if (odd) {
                realAns.append(oddNum);
            }
            StringBuilder rev = ans.reverse();
            for (int i = 0; i < rev.length(); i++) {
                realAns.append(rev.charAt(i));
            }
            if (realAns.length() == 0) {
                return "0";
            }
            return realAns.toString();
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-20 22:36:55
 * @LastEditTime: 2022-08-20 22:36:55
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/LargestPalindromicNumber_6166.java
 */
