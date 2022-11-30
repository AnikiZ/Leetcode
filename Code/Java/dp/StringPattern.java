/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-30 13:40:12
 * @LastEditTime: 2022-11-30 13:41:44
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/dp/StringPattern.java
 */
package dp;

public class StringPattern {
    // Java program for the above approach
    class GFG{
    
        // Power function to calculate
        // long powers with mod
        static long power(int x, int y, int p)
        {
            long res = 1;
            // x = x % p;
        
            // if (x == 0)
            //     return 0;
        
            // while (y > 0)
            // {
            //     if ((y & 1) != 0)
            //         res = (res * x) % p;
                    
            //     y = y >> 1;
            //     x = (x * x) % p;
            // }
            while (y > 0) {
                res = (res * x) % p;
            }
            return res;
        }
        
        // Function for finding number of ways to
        // create string with length N and atmost
        // K contiguous vowels
        static int kvowelwords(int N, int K)
        {
            int i, j;
            int MOD = 1000000007;
        
            // Array dp to store number of ways
            long[][] dp = new long[N + 1][K + 1] ;
        
            long sum = 1;
            for(i = 1; i <= N; i++)
            {
                
                // dp[i][0] = (dp[i-1][0]+dp[i-1][1]..dp[i-1][k])*21
                dp[i][0] = sum * 21;
                dp[i][0] %= MOD;
        
                // Now setting sum to be dp[i][0]
                sum = dp[i][0];
        
                for(j = 1; j <= K; j++)
                {
                    
                    // If j>i, no ways are possible to create
                    // a string with length i and vowel j
                    if (j > i)
                        dp[i][j] = 0;
                        
                    else if (j == i)
                    {
                        
                        // If j = i all the character should
                        // be vowel
                        dp[i][j] = power(5, i, MOD);
                    }
                    else
                    {
                        
                        // dp[i][j] relation with dp[i-1][j-1]
                        dp[i][j] = dp[i - 1][j - 1] * 5;
                    }
        
                    dp[i][j] %= MOD;
        
                    // Adding dp[i][j] in the sum
                    sum += dp[i][j];
                    sum %= MOD;
                }
            }
            return Integer.parseInt(String.valueOf(sum));
        }
        
        // Driver Code
        public static void main(String[] args)
        {
            
            // Input
            int N = 3;
            int K = 3;
        
            // Function Call
            System.out.println( kvowelwords(N, K));
        }
        }
}
