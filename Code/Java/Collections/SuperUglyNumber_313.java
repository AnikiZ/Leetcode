/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-14 16:51:06
 * @LastEditTime: 2022-08-15 14:12:38
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/SuperUglyNumber_313.java
 */
package Collections;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber_313 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(1);
            while (n-- > 0) {
                int x = queue.poll();
                if (n == 0) {
                    return x;
                }
                for (int prime : primes) {
                    // 不判断这个会有问题！记住是>=!有可能=，很刁钻
                    if ((Integer.MAX_VALUE / x) >= prime) {
                        queue.add(prime * x);
                    }
                    if (x % prime == 0) {
                        break;
                    }
                }
            }
            return 1;
        }
    }
    class Solution_Pointers {
        // ugly number is the product of the prime and ugly number in front of it.
        // the first ugly number is 1, pointers reserve the smallest index of the dp to multiple 
        // the correspoding prime that is bigger than current dp ugly number.
        // In array nums, there are products for each prime that are bigger than current dp ugly number.
        // In each iteration, we get the smallest num in nums as the new ugly number, others are equal or
        // bigger than it. Then we should update the pointers and nums that are equal to the new ugly number,
        // the pointer will add 1, pointing to its next ugly number and the num should correspoindly update.
        public static void main(String[] args) {
            int n = 5911;
            int[] nums = {2,3,5,7};
            int ans = Solution_OPT.nthSuperUglyNumber(n, nums);
        }
        public static int nthSuperUglyNumber(int n, int[] primes) {
            int m = primes.length;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int[] pointers = new int[m];
            Arrays.fill(pointers, 1);
            int[] nums = primes.clone();
            // System.arraycopy(src, srcPos, dest, destPos, length);
            for (int i = 2; i <= n; i++) {
                int min = Arrays.stream(nums).min().getAsInt();
                dp[i] = min;
                for (int j = 0; j < m; j++) {
                    if (nums[j] == min) {
                        pointers[j]++;
                        // corner case!!!!!!!!!!!!!!!
                        // nums[j] = dp[pointers[j]] * primes[j];
                        // if (nums[j] < 0) {
                        //     System.out.println(nums[j]);
                        // }
                        if (Integer.MAX_VALUE / primes[j] >= dp[pointers[j]]) {
                            nums[j] = dp[pointers[j]] * primes[j];
                        } else {
                            nums[j] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            // System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
    class Solution_OPT {
        // public static void main(String[] args) {
        //     int n = 5911;
        //     int[] nums = {2,3,5,7};
        //     int ans = Solution_OPT.nthSuperUglyNumber(n, nums);
        // }
        public static int nthSuperUglyNumber(int n, int[] primes) {
            int m = primes.length;
            // amazing! 很好的避免了越限corner case，因为很大的数减去很大的负数（实际已经越界）是越界正数，就变为负，所以很大的负数（实际是大正数）不会在前面
            PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]); 
            for (int i = 0; i < m; i++) {
                q.add(new int[]{primes[i], i, 0});
            }
            int[] ans = new int[n];
            ans[0] = 1;
            for (int j = 1; j < n; ) {
                int[] poll = q.poll();
                int val = poll[0], i = poll[1], idx = poll[2];
                if (val != ans[j - 1]) ans[j++] = val;
                if (ans[idx + 1] * primes[i] < 0) {
                    System.out.println("What!" + ans[idx + 1] * primes[i]);
                }
                q.add(new int[]{ans[idx + 1] * primes[i], i, idx + 1});
            }
            // System.out.println(Arrays.toString(ans));
            return ans[n - 1];
        }
    }
    
}
