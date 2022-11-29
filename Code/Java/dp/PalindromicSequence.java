package dp;

public class PalindromicSequence {
    public static void main(String[] args) {
        System.out.println(Solution.product("leetcodecom"));
    }
    public static class Solution {
        public static int product (String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                // one character itself is palindromic
                dp[i][i] = 1;
            }
           // stage one: from bottom to up, obtain the palindromic subsequence numbers in each substring
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i < n - len + 1; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j) && len == 2) {
                        dp[i][j] = 2;
                    } else if (s.charAt(i) == s.charAt(j)) {
                        // 应该可以和上面合并的，len=2时dp[i+1][j-1] = 0且不会越界
                        dp[i][j] = dp[i+1][j-1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            // second stage: traverse the matrix, update maxProduct in each iteration
            // outer loop: traverse string s from i to length
            // inner loop: divide current s[i : length - 1] by j to left and right part, then obtain current product by multiply 
            // palindromic numbers in s[i : j] and s[j : length - 1], which correspond to dp[i][j] and dp[j][length - 1], also update maxProduct
            int maxProduct = 0;
            for (int i = 0; i < n - 1; i++) {
                maxProduct = Math.max( maxProduct, dp[0][i]*dp[i+1][n-1] );
            }
            return maxProduct;
        }
    }
}
