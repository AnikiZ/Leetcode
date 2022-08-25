/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-23 18:01:58
 * @LastEditTime: 2022-06-23 18:02:16
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Sqrt_69.java
 */
public class Sqrt_69 {
    class Solution {
        public int mySqrt(int x) {
            // Newton method:
            // long a = x;
            // while (a * a > x) {
            //     a = (a + x / a) / 2;
            // }
            // return (int)a;
            if (x == 0) {
                return x;
            }
            int left = 1;
            int right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sqrt = x / mid;
                if (sqrt == mid) {
                    return mid;
                } else if (sqrt < mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right;
            
        }
    }
}
