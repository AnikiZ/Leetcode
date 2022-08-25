import java.util.Stack;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-08 00:23:27
 * @LastEditTime: 2022-08-08 01:11:46
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MakeChunksToMakeSorted_769.java
 */
public class MakeChunksToMakeSorted_769 {
    // maximum value of previous chunk < numbers behind
    // meaning recording current maximum value, which can only be equal to current index. 
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int chunk = 0;
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if (max == i) {
                    chunk++;
                }
            }

            return chunk;
        }
    }
    class Solution_Stack {
        public int maxChunksToSorted(int[] arr) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(arr[0]);
            for (int num : arr) {
                if (num > stack.peek()) {
                    stack.push(num);
                } else {
                    int currentChunk = stack.pop();
                    while (!stack.isEmpty() && stack.peek() > num) {
                        stack.pop();
                    }
                    stack.push(currentChunk);
                }
            }
            return stack.size();
        }
    }
}
