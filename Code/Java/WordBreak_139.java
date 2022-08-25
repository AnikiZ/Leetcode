import java.util.Arrays;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-11 18:13:42
 * @LastEditTime: 2022-07-11 20:12:51
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/WordBreak_139.java
 */
public class WordBreak_139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            char[] str = s.toCharArray();
            int n = str.length;
            boolean[] dp = new boolean[n + 1];
            Arrays.fill(dp, false);
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (String word : wordDict) {
                    int len = word.length();
                    if (i >= len && s.substring(i - len, i).equals(word)) {
                        dp[i] = dp[i] || dp[i - len];
                    }
                }
            }
            return dp[n];
        }
    }
}
