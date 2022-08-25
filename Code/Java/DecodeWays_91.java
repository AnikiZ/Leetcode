import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-11 16:54:25
 * @LastEditTime: 2022-07-11 18:06:46
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/DecodeWays_91.java
 */
public class DecodeWays_91 {
    class Solution {
        public int numDecodings(String s) {
            char[] str = s.toCharArray();
            int len = str.length;
            if (str[0] == '0') {
                return 0;
            }
            if (len == 1) {
                return 1;
            }
            int[] dp = new int[len + 1];
            Arrays.fill(dp, 1);
            char prev = str[0];
            for (int i = 2; i <= len; i++) {
                char cur = str[i - 1];
                if ((prev > '2' || prev == '0') && cur == '0') {
                    return 0;
                }
                if (prev == '1' || (prev == '2' && cur < '7')) {
                    if (cur == '0') {
                        dp[i] = dp[i - 2];
                    } else {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
                prev = cur;
            }
            return dp[len];
        }
    }
    class SolutionOpt {
        public int numDecodings(String s) {
            int n = s.length();
            // a = f[i-2], b = f[i-1], c=f[i]
            int a = 0, b = 1, c = 0;
            for (int i = 1; i <= n; ++i) {
                c = 0;
                if (s.charAt(i - 1) != '0') {
                    c += b;
                }
                if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                    c += a;
                }
                a = b;
                b = c;
            }
            return c;
        }
    }
}
