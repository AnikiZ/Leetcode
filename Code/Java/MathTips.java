/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-27 16:06:23
 * @LastEditTime: 2022-08-11 17:05:56
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MathTips.java
 */
public class MathTips {
    public static void main(String[] args) {
        int a = MathTips.GreatestCommonDivisor(-5, 3);
        int b = MathTips.GreatestCommonDivisor(5, -3);
        System.out.println(a + " " + b);
    }
    public static int GreatestCommonDivisor(int a, int b) {
        // 在 % 的本质看一个公式!!!! a % b = a - a / b * b
        return b == 0 ? a : GreatestCommonDivisor(b, a % b);
    }
    public int LeastCommonMultiple(int a, int b) {
        return a * b / GreatestCommonDivisor(a, b);
    }
    // 得到GCD同时得到系数x, y 使得 x * a + y * b = gcd(a, b)
    public int ExtendedGCD(int a, int b, int x, int y) {
        if (b == 0) {
            x = 1; y = 0;
            return a;
        }
        int gcd = ExtendedGCD(b, a % b, x, y);
        x = y; y = x - (a / b) * y;
        return gcd;
    }
}
