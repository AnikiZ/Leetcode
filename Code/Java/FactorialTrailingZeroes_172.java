/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-28 17:12:06
 * @LastEditTime: 2022-07-28 17:32:44
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/FactorialTrailingZeroes_172.java
 */
public class FactorialTrailingZeroes_172 {
    class Solution {
        public int trailingZeroes(int n) {
            // [1, n]中p的倍数有(n / p)个，向下取整，p^2的倍数同理，最终质因子p的个数为
            // sum(k = 1 -> inf) n / (p ^ k)
            // 因此n不变，p越大，质因子个数越少，所以5个数不会大于2个数
            // n / (p ^ k) = n / (p ^ k - 1) / p，因此可得如下代码：
            return (n == 0) ? 0 : (n / 5) + trailingZeroes(n / 5);
        }
    }
}