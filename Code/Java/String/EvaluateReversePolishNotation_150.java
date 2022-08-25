/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-19 01:07:26
 * @LastEditTime: 2022-08-19 01:15:09
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/EvaluateReversePolishNotation_150.java
 */
package String;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation_150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            int size = tokens.length;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                String token = tokens[i];
                // 判断最后一位！！！考虑负数情况，index(0) = '-'
                if (Character.isDigit(token.charAt(token.length() - 1))) {
                    stack.push(Integer.valueOf(token));
                } else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    switch(token) {
                        case "+": {
                            stack.push(num1 + num2);
                            break;
                        }
                        case "-": {
                            stack.push(num1 - num2);
                            break;
                        }
                        case "*": {
                            stack.push(num1 * num2);
                            break;
                        }
                        case "/": {
                            stack.push(num1 / num2);
                            break;
                        }
                    }
                }
            }
            return stack.pop();
        }
    }
}