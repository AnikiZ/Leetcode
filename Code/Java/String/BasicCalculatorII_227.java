/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-18 01:19:40
 * @LastEditTime: 2022-08-18 03:29:20
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/BasicCalculatorII_227.java
 */
package String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII_227 {
    class Solution {
        public int calculate(String s) {
            int left = 0, right = 0;
            int i = 0, len = s.length();
            char op = '+';
            while (i < len) {
                if (s.charAt(i) != ' ') {
                    // get current number
                    int num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = 10 * num + (s.charAt(i++) - '0');
                    }
                    switch(op) {
                        case '+': {
                            left += right;
                            right = num;
                            break;
                        }
                        case '-': {
                            left += right;
                            right = -num;
                            break;
                        }
                        case '*': {
                            right *= num;
                            break;
                        }
                        case '/': {
                            right /= num;
                            break;
                        }
                    }
                    if (i < len) {
                        op = s.charAt(i);
                    }
                }
                i++;
            }
            return left + right;
        }
        // i不会跟着变，不用
        public int parseNum(String s, int i) {
            int n = 0;
            while (i < s.length() && Character.isDigit(i)) {
                n = 10 * n + (s.charAt(i++) - '0');
            }
            return n;
        }
    }
    class Solution_Stack {
        public static void main(String[] args) {
            Solution_Stack.calculate("400");
        }
        public static int calculate(String s) {
            Deque<Integer> stack = new LinkedList<>();
            int len = s.length();
            char pre = '+';
            int i = 0;
            while (i < len) {
                int num = 0;
                if (s.charAt(i) == ' ') {
                    i++;
                    continue;
                }
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                switch(pre) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        stack.push(num * stack.pop());
                        break;
                    }
                    case '/': {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                if (i < len) {
                    pre = s.charAt(i);
                    // don't forget!
                    i++;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }
    class Solution_Official {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            char preSign = '+';
            int num = 0;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                    switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                    }
                    preSign = s.charAt(i);
                    num = 0;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }
}