/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-22 01:06:58
 * @LastEditTime: 2022-11-22 01:06:59
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/NumberofWaysofCuttingaPizza_1444.java
 */
package Tiktok;

public class NumberofWaysofCuttingaPizza_1444 {
    class Solution {
        public int ways(String[] pizza, int k) {
            int n = pizza.length, m = pizza[0].length(), mod = 1000000007;
    
            // 状态数组，三个维度分别表示以x、y为左上角的矩阵中，分给k个人，元素值表示方案数
            int[][][] f = new int[n + 1][m + 1][k + 1];
            // 苹果数的前缀和，用于快速获得在指定矩阵范围内的苹果数量，两个维度也分别是左上角的x、y
            int[][] cnt = new int[n + 1][m + 1];
    
            // 遍历矩阵，获取指定左上角矩阵中范围内的苹果数量
            for(int i = n - 1; i >= 0; i--) {
                for(int j = m - 1; j >= 0; j--) {
                    cnt[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
                    // 通用的矩阵求前缀和公式
                    cnt[i][j] += cnt[i][j + 1] + cnt[i + 1][j] - cnt[i + 1][j + 1];
                }
            }
    
            // 从右下角开始，向左上角开始枚举所有状态
            for(int i = n - 1; i >= 0; i --) {
                for(int j = m - 1; j >= 0; j --) {
                    // 如果这个范围矩阵内存在苹果，那么这个矩阵肯定可以分给1个人，且方案数为1
                    if(cnt[i][j] > 0) {
                        f[i][j][1] = 1;
                    }
                    // 枚举所有人数状态下的方案，前面已经判断了人数为1的状态，所以这里只需要从2开始枚举
                    for(int p = 2; p <= k; p++) {
                        // 横着切，枚举所有切法
                        for(int x = n - i - 1; x >= 1; x --) {
                            // 如果当前切掉的矩阵内存在苹果，则可以进行状态转移
                            if(cnt[i][j] - cnt[i + x][j] > 0) {
                                // 从切剩下的那块矩阵中的人数减一方案数进行转移
                                f[i][j][p] = (f[i][j][p] + f[i + x][j][p - 1]) % mod;
                            }
                        }
                        // 竖着切
                        for(int y = m - j - 1; y >= 1; y --) {
                            if(cnt[i][j] - cnt[i][j + y] > 0) {
                                f[i][j][p] = (f[i][j][p] + f[i][j + y][p - 1]) % mod;
                            }
                        }
                    }
                }
            }
            // 返回总的矩阵和k个人的方案数
            return f[0][0][k];
        }
    }
}
