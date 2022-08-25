/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-18 17:32:03
 * @LastEditTime: 2022-08-18 17:59:58
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/LongestPalindrome_409.java
 */
package String;

import java.util.HashMap;

public class LongestPalindrome_409 {
    class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                map.merge(s.charAt(i), 1, (a, b) -> {
                    return a + b;
                });
            }
            int ans = 0;
            // for (int value : map.values()) {
            //     // add the even number, and then check if it is odd
            //     ans += value / 2 * 2;
            //     // value is odd and ans is even, ans++, only plus once!
            //     if (value % 2 != 0 && ans % 2 == 0) {
            //         ans++;
            //     }
            // }
            int odd = 0;
            for (int value : map.values()) {
                int rem = value % 2;
                ans += value - rem;
                if (rem == 1) {
                    odd = 1;
                }
            }
            return ans + odd;
        }
    }
}
