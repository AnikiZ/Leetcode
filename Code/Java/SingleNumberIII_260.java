/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-01 02:20:33
 * @LastEditTime: 2022-08-06 21:45:35
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SingleNumberIII_260.java
 */
import java.util.HashMap;

public class SingleNumberIII_260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xorSum = 0;
            for (int num : nums) {
                xorSum ^= num;
            }
            // x & (-x)可以提取出x二进制表示中最低位的1，但如果是最小数的话就会越界，01...1加一越限，所以要单独处理
            int mask = (xorSum == Integer.MIN_VALUE) ? xorSum : xorSum & (-xorSum);
            int x1 = 0, x2 = 0;
            for (int num : nums) {
                if ((mask & num) != 0) {
                    x1 ^= num;
                } else {
                    x2 ^= num;
                }
            }
            return new int[]{x1, x2};
        }
    }
    class Solution_HashMap {
        public int[] singleNumber(int[] nums) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int[] ans = new int[2];
            int index = 0;
            for (int key : freq.keySet()) {
                if (freq.get(key) == 1) {
                    ans[index++] = key;
                }
            }
            return ans;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-01 02:20:33
 * @LastEditTime: 2022-08-01 02:20:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/SingleNumberIII_260.java
 */
