import java.util.Random;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-28 22:50:19
 * @LastEditTime: 2022-07-29 02:01:07
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ShuffleAnArray_384.java
 */
public class ShuffleAnArray_384 {
    class Solution {
        private int[] origin;

        public Solution(int[] nums) {
            origin = nums;
        }
        
        public int[] reset() {
            return origin;
        }
        
        public int[] shuffle() {
            int[] shuffle = new int[origin.length];
            System.arraycopy(origin, 0, shuffle, 0, origin.length);
            Random random = new Random();
            for (int i = 0; i < origin.length - 1; i ++) {
                int j = i + random.nextInt(origin.length - i);
                int temp = shuffle[i];
                shuffle[i] = shuffle[j];
                shuffle[j] = temp;
            }
            return shuffle;
        }
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
}
