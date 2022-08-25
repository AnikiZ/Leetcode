/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-18 19:24:30
 * @LastEditTime: 2022-08-19 01:06:41
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/BasicCalculatorIII_772.java
 */
package String;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BasicCalculatorIII_772 {
    class Solution {
        public int calculate(String s) {
            int[] result = calculate(s, 0);
            return result[0];
        }
        private int[] calculate(String s, int start) {
            Deque<Integer> stack = new LinkedList<>();
            char op = '+';
            int len = s.length();
            int[] rec = new int[2];
            while (start < len) {
                // initialize num to be 0!
                int num = 0;
                while (start < len && Character.isDigit(s.charAt(start))) {
                    num = 10 * num + s.charAt(start) - '0';
                    start++;
                }
                if (start < len && s.charAt(start) == '(') {
                    int[] res = calculate(s, start + 1);
                    num = res[0];
                    start = res[1] + 1;
                }
                switch(op) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        stack.push(stack.pop() * num);
                        break;
                    }
                    case '/': {
                        stack.push(stack.pop() / num);
                        break;
                    }
                }
                // check the bound! possible ')' is the end!
                if (start < len && s.charAt(start) == ')') {
                    rec[1] = start;
                    break;
                }
                // check the bound!
                if (start < len) {
                    op = s.charAt(start);
                    start++;
                }
            }
            while (!stack.isEmpty()) {
                rec[0] += stack.pop();
            }
            return rec;
        }
    }
    class Solution_O {
        public int calculate(String s) {
            int[] result = js(s,0);
            return result[0];
        }
        public int[] js(String s,int begin) {
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[2];
            char presign = '+';
            int n = s.length();
            int num = 0;
            for (int i = begin; i < n; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                }
                if (c == '(') {
                    int[] numNext = js(s,i + 1);
                    num = numNext[0];
                    i = numNext[1];
                }
                //对于末尾结束时 或 不是数字字符且字符不为'('时，对num进行处理
                if (i == n - 1 || !Character.isDigit(c) && c != '(') {
                    switch (presign) {
                        case '+':deque.push(num);break;
                        case '-':deque.push(-num);break;
                        case '*':deque.push(deque.pop() * num);break;
                        default:deque.push(deque.pop() / num);break;
                    }
                    //如果结束是右括号，那么就记录位置结束循环。
                    if (c == ')') {
                        result[1] = i;
                        break;
                    }
                    presign = c;
                    num = 0;
                }
    
            }
            while (!deque.isEmpty()) {
                result[0] += deque.pop();
            }
            return result;
        }
    }
    class Solution_RPN {
        public int calculate(String s) {
            List<String> tokens = getRPN(s);
            return evalRPN(tokens);
        }
        public List<String> getRPN(String s) {
            // 注意类型！ String 和 Character!!! "" & ''
            List<String> rpn = new ArrayList<String>();
            Deque<String> stack = new LinkedList<>();
            int len = s.length();
            int num = 0;
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = 10 * num + s.charAt(i) - '0';
                } else {
                    // consider first num is negative! -7 + 3
                    if (i > 0 && Character.isDigit(s.charAt(i - 1))) {
                        rpn.add(String.valueOf(num));
                        num = 0;
                    }
                    if (c == '(') {
                        stack.push(String.valueOf(c));
                    } else if (c == ')') {

                        // equals!!!!!!!!!!!!!!!!!!!!!!
                        while (!stack.peek().equals("(")) {

                            rpn.add(stack.pop());
                        }
                        // "(" 也pop
                        stack.pop();
                    } else {
                        int precedence = getPrecedence(c);
                        // string(len = 1) -> char: .charAt(0)
                        while (!stack.isEmpty() && getPrecedence(stack.peek().charAt(0)) >= precedence) {
                            rpn.add(stack.pop());
                        }
                        stack.push(String.valueOf(c));
                    }
                }
            }
            // if end with a num
            if (Character.isDigit(s.charAt(len - 1))) {
                rpn.add(String.valueOf(num));
            }
            while (!stack.isEmpty()) {
                rpn.add(stack.pop());
            }
            return rpn;
        }
        public int evalRPN(List<String> tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            int size = tokens.size();
            for (int i = 0; i < size; i++) {
                String token = tokens.get(i);
                // is a number? 得判断最后一位是不是数字，只判断第一位不行！有可能是负数！！！
                if (Character.isDigit(token.charAt(token.length() - 1))) {
                    stack.push(Integer.valueOf(token)); // or Integer.parseInt(token)
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
        private int getPrecedence(Character c) {
            if (c == '*' || c == '/') {
                return 2;
            } else if (c == '+' || c == '-') {
                return 1;
            } else {
                return 0;
            }
        }
    }
}