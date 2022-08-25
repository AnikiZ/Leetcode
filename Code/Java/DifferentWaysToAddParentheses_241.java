/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-25 18:49:24
 * @LastEditTime: 2022-07-25 20:39:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/DifferentWaysToAddParentheses_241.java
 */
import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses_241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> ways = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                    for (int l : left) {
                        for (int r : right) {
                            switch(c) {
                                case '+': {
                                    ways.add(l + r);
                                    break;
                                }
                                case '-': {
                                    ways.add(l - r);
                                    break;
                                }
                                case '*': {
                                    ways.add(l * r);
                                }
                            }
                        }
                    }
                }
            }
            if (ways.isEmpty()) {
                ways.add(Integer.valueOf(expression));
                return ways;
            }
            // 别忘了！
            return ways;
        }
    }
    class Solution_DFS {
        public List<Integer> diffWaysToCompute(String expression) {
            return dfs(expression, 0, expression.length() - 1);
        }
        public List<Integer> dfs(String expression, int l, int r) {
            List<Integer> ans = new ArrayList<>();
            for (int i = l; i < r; i++) {
                if (Character.isDigit(expression.charAt(i))) {
                    continue;
                }
                List<Integer> left = dfs(expression, l, i - 1);
                List<Integer> right = dfs(expression, i + 1, r);
                for (int num1 : left) {
                    for (int num2 : right) {
                        if (expression.charAt(i) == '+') {
                            ans.add(num1 + num2);
                        } else if (expression.charAt(i) == '-') {
                            ans.add(num1 - num2);
                        } else if (expression.charAt(i) == '*') {
                            ans.add(num1 * num2);
                        }
                    }
                }
            }
            if (ans.isEmpty()) {
                ans.add(Integer.valueOf(expression.substring(l, r + 1)));
            }
            return ans;
        }
    }
    class Solution_DP {
        
    }
}