/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-26 22:47:24
 * @LastEditTime: 2022-07-27 01:03:55
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/BeautifulArray_932.java
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeautifulArray_932 {
    class Solution {
        public int[] beautifulArray(int n) {
            Map<Integer, int[]> memo = new HashMap<Integer, int[]>();
            memo.put(1, new int[]{1});
            return f(memo, n);
        }
        public int[] f(Map<Integer, int[]> memo, int n) {
            if (memo.containsKey(n)) {
                return memo.get(n);
            }
            int[] ans = new int[n];
            int t = 0;
            for (int odd : f(memo, (n + 1) / 2)) {
                ans[t++] = odd * 2 - 1;
            }
            for (int even : f(memo, n / 2)) {
                ans[t++] = even * 2;
            }
            memo.put(n, ans);
            return ans;
        }
    }
    // 慢了不少，空间时间都不行
    class Solution_DP {
        public int[] beautifulArray(int n) {
            List<Integer>[] dp = (ArrayList<Integer>[])new ArrayList[n + 1];
            dp[1] = new ArrayList<>();
            dp[1].add(1);
            for (int i = 2; i < n + 1; i++) {
                dp[i] = new ArrayList<>();
                for (int odd : dp[(i + 1) / 2]) {
                    dp[i].add(odd * 2 - 1);
                }
                for (int even : dp[i / 2]) {
                    dp[i].add(even * 2);
                }
            }
            int[] ans = new int[n];
            for (int i = 0 ; i < n; i++) {
                ans[i] = dp[n].get(i);
            }
            System.out.println(dp[n]);
            return ans;
        }
    }
}