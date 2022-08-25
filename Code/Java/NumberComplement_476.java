/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-01 01:01:10
 * @LastEditTime: 2022-08-01 02:19:06
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/NumberComplement_476.java
 */
public class NumberComplement_476 {
    class Solution {
        public int findComplement(int num) {
            int highBit = 0;
            // 这里 1<=num<2^31
            for (int i = 30; i >= 0; i++) {
                if (((num >> i) & 1) != 0) {
                    highBit = i;
                    break;
                }
            }
            int x = (1 << highBit) - 1;
            return ~num & x;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-01 01:01:10
 * @LastEditTime: 2022-08-01 01:01:10
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/NumberComplement_476.java
 */
