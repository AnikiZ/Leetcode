import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-27 16:41:34
 * @LastEditTime: 2022-07-28 03:07:38
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/CountPrimes_204.java
 */
public class CountPrimes_204 {
    class Solution {
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }
            boolean[] primes = new boolean[n];
            Arrays.fill(primes, true);
            int count = n - 2; // 1不是质数，且题目不包含n
            for (int i = 2; i < n; i++) {
                if (primes[i]) {
                    for (int j = 2 * i; j < n; j += i) {
                        if (primes[j]) {
                            primes[j] = false;
                            count--;
                        }
                    }
                }
            }
            return count;
        }
    }
    class Solution_Opt {
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }
            boolean[] primes = new boolean[n];
            Arrays.fill(primes, true);
            int count = n - 2; // 1不是质数，且题目不包含n
            for (int i = 2; i < n; i++) {
                if (primes[i]) {
                    // 考虑越界情况！！！
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            if (primes[j]) {
                                primes[j] = false;
                                count--;
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
    class Solution_On {
        // 线性筛实际运行时间 > 埃氏， 因为质数合成合数过程需要不断访问primes
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }
            boolean[] isPrime = new boolean[n];
            List<Integer> primes = new ArrayList<>();
            Arrays.fill(isPrime, true);
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }

                for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                    isPrime[i * primes.get(j)] = false;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            return primes.size();
        }
    }
}
