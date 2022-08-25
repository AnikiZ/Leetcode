/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-23 15:48:59
 * @LastEditTime: 2022-06-23 16:03:57
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SumOfSquareNumbers_633.java
 */
public class SumOfSquareNumbers_633 {
    public static void main(String[] args) {
        System.out.println(Solution.judgeSquareSum(2147483600));
    }
    class Solution {
        public static boolean judgeSquareSum(int c) {
            int a = 0, b = (int)Math.sqrt(c);
            System.out.println("a = " + a + " b = " + b);
            long sum = 0;
            while (a <= b) {
                // don't forget the long!!!!!
                sum = (long)a * a + b * b;
                // System.out.println("sum = " + sum + " a = " + a + " b = " + b);
                if (sum == c) {
                    System.out.println("a = " + a + "b = " + b);
                    return true;
                } else if (sum < c) {
                    a++;
                } else {
                    b--;
                }
            }
            
            return false;
        }
    }
}
