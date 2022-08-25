/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-12 23:25:27
 * @LastEditTime: 2022-08-13 23:04:21
 * @LastEditors: Zeping Zhu
 * @Description:
 
 * @FilePath: /Code/Java/Collections/NextGreaterElementII_503.java
 */
package Collections;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementII_503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            Deque<Integer> stack = new LinkedList<Integer>();
            // or directly iterate twice
            // use module to store the index to iterate twice
            for (int i = 0; i < 2 * n - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ans[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return ans;
        }
    }
    class Solution_Stack {
        public static void main(String[] args) {
            int[] nums = {1,2,3,4,3};
            System.out.println(Arrays.toString(Solution_Stack.nextGreaterElements(nums)));
        }
        public static int[] nextGreaterElements(int[] nums) {
            // 用Deque实现stack, 可以加头也可以加尾，add = addLast, push = addFirst, pop = removeFirst
            // 用Stack实现stack, push 和 add 都是加头
            int[] ans = new int[nums.length];
            Deque<Integer> stack = new LinkedList<>();
            // Stack<Integer> stac = new Stack<>();
            // stac.add(3);
            // stac.add(4);
            // stac.push(6);
            // int nu = stac.get(0);
            // stac.pop();
            for (int i = nums.length - 1; i >= 0 ; i--) {
                // stack.add: addLast!
                stack.push(nums[i]); // equals to addFirst!
            }
            for (int i = nums.length - 1; i>= 0; i--) {
                while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                    stack.pop();
                    stack.removeLast();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                    stack.push(nums[i]);
                } else {
                    ans[i] = stack.peek();
                    stack.push(nums[i]);
                }
            }
            return ans;
        }
    }
}