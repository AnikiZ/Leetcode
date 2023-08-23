package OA.Mathworks;

import java.util.ArrayList;
import java.util.List;

public class LongestPrefixSuffix {

    // Compute the longest prefix suffix array
    public static int[] computeLPSArray(String pat) {
        int j = 0;
        int i = 1;
        int m = pat.length();
        int[] lps = new int[m];
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }

    // Returns the list of start indexes patterns in arr
    public static List<Integer> kmp(String pat, String arr) {
        int m = pat.length();
        int n = arr.length();
        int[] lps = computeLPSArray(pat);
        int i = 0;
        int j = 0;
        List<Integer> indexes = new ArrayList<>();
        while (i < n) {
            if (pat.charAt(j) == arr.charAt(i)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == m) {
                indexes.add(i - j);
                j = lps[j - 1];
            }
        }
        return indexes;
    }

    // More optimized
    public static long solveLC(String src, String targ, int k) {
        long MOD = 1000000007;
        int n = src.length();
        long[] dp = {1, 0};
        for (int i = 0; i < k; i++) {
            long temp = dp[0];
            dp[0] = ((n - 1) * dp[1]) % MOD;
            dp[1] = (temp + (n - 2) * dp[1]) % MOD;
        }
        long res = 0;
        List<Integer> indexes = kmp(targ, src + src.substring(0, n - 1));
        for (int i : indexes) {
            res += i == 0 ? dp[0] : dp[1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solveLC("aaaa", "aaaa", 2));
        System.out.println(solveLC("ababab", "ababab", 1));
    }
}

