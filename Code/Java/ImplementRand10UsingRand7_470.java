import java.util.Random;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-29 22:04:30
 * @LastEditTime: 2022-07-29 22:38:38
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ImplementRand10UsingRand7_470.java
 */
public class ImplementRand10UsingRand7_470 {
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
// class Solution extends SolBase {
//     public int rand10() {
        
//     }
// }
    class Solution {
        public int rand7() {
            Random random = new Random();
            return random.nextInt(6);
        }
        public int rand10() {
            int row, col, idx;
            while (true) {
                row = rand7();
                col = rand7();
                idx = row + (col - 1) * 7;
                if (idx <= 40) {
                    return 1 + (idx - 1) % 10;
                }
                row = idx - 40;
                col = rand7();
                // idx应该为（行数-1） * 列最大数！
                //idx = row + (col - 1) * 9;
                idx = col + (row - 1) * 7;
                if (idx <= 60) {
                    return 1 + (idx - 1) % 10;
                }
                row = idx - 60;
                col = rand7();
                idx = col + (row - 1) * 7;
                if (idx <= 20) {
                    return 1 + (idx - 1) % 10;
                }
            }
        }
    }
    
}
