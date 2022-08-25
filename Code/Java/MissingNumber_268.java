import java.util.Arrays;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-01 00:26:32
 * @LastEditTime: 2022-08-01 00:27:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MissingNumber_268.java
 */
public class MissingNumber_268 {
    class Solution {
        public int missingNumber(int[] nums) {
            int miss = Arrays.stream(nums).sum();
            int sum = 0;
            for (int i = 0; i <= nums.length; i++) {
                sum += i;
            }
            return sum - miss;
        }
    }
}