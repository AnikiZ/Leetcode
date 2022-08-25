import java.util.Arrays;
import java.util.Random;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 02:33:50
 * @LastEditTime: 2022-07-29 02:40:20
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/RandomPickWithWeight_528.java
 */
public class RandomPickWithWeight_528 {
    class Solution {
        private int[] preSums;
        int sum;
        public Solution(int[] w) {
            preSums = new int[w.length];
            preSums[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                preSums[i] = w[i] + preSums[i - 1];
            }
            sum = Arrays.stream(w).sum();
        }
        public int pickIndex() {
            Random random = new Random();
            int x = random.nextInt(sum) + 1;
            return binarySearch(x);
        }
        public int binarySearch(int x) {
            int left = 0, right = preSums.length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (preSums[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
    
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
}
