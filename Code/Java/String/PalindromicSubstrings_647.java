/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-16 21:37:06
 * @LastEditTime: 2022-08-18 11:12:10
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/PalindromicSubstrings_647.java
 */
package String;

public class PalindromicSubstrings_647 {
    class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                count += subs(s, i, i); // 奇数长度
                count += subs(s, i, i + 1); // 偶数长度
            }
            return count;
        }
        public int subs(String s, int left, int right) {
            int count = 0;
            int len = s.length();
            // while (left >= 0 && right < len) {
            //     if (s.charAt(left) == s.charAt(right)) {
            //         left--;
            //         right++;
            //         count++;
            //     } else {
            //         break;
            //     }
            // }
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
            return count;
        }
    }
    // 求最长回文子串的O(n)方法，利用了对称性质，并可同时处理奇偶情况
    // 计数回文子串也可以通过长度得到
    class Solution_Manacher {
        public int countSubstrings(String s) {
            StringBuilder ss = new StringBuilder();
            // 构造为奇数长度字符串，并在头尾加两个不同的字符(不要是字母以防误判),使中心拓展时不会越界必然终止
            ss.append("?#");
            for (char c : s.toCharArray()) {
                ss.append(c);
                ss.append("#");
            }
            int n = ss.length();
            // no need to check "!"
            ss.append("!");

            // f[i]: the max palindrome radius of index i(containing the palindrome center)
            int[] f = new int[n];
            int iMax = 1, rMax = 1, ans = 0;
            // start from 1, no need to check "!"
            for (int i = 1; i < n; i++) {
                // initiate f[i]
                // i's symmetrical position is j that i + j = 2 * iMax(prerequisite: i <= rMax)
                // choose smaller one
                f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
                
                // update f[i], 中心拓展 center expansion
                while (ss.charAt(i + f[i]) == ss.charAt(i - f[i])) {
                    f[i]++;
                }

                // dynamically maitain iMax and rMax
                // compare the rMax because we should ensure 
                // ontaining following elements' max length as fast as possible
                if (i + f[i] - 1 > rMax) {
                    rMax = i + f[i] - 1;
                    iMax = i;
                }
                // 最秒的地方！
                // two cases:
                // 1. #a#, the character is the center, equivalent to odd-length string,
                // f[i] will always be even number, possible substrings will be f[i] / 2
                // 2. #a#a#, # is the center, equivalent to even-length string,
                // f[i] will always be odd number, possible substrings will also be f[i] / 2!
                ans += f[i] / 2;
            }
            return ans;
        }
    }
    // dp[i][j]: [i, j]是不是回文，需要知道[i + 1, j - 1]的情况
    // 所以遍历应该是外层j++,里层i++且i<=j
    class Solution_DP {
        public int countSubstrings(String s) {
            int len = s.length();
            int ans = 0;
            boolean[][] dp = new boolean[len][len];
            for (int j = 0; j < len; j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && ((j - i) < 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
