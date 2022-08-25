import java.util.Stack;

public class ValidParentheses_20 {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> lefts = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    lefts.push(c);
                } else {
                    if (lefts.isEmpty()) {
                        return false;
                    } else {
                        char left = lefts.peek();
                        if ((left == '(' && c == ')') ||
                            (left == '[' && c == ']') ||
                            (left == '{' && c == '}')) 
                        {
                            lefts.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
            // 不是直接return true！ "["就不对~
            return lefts.isEmpty();
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-08 20:29:52
 * @LastEditTime: 2022-08-08 20:33:44
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/ValidParentheses_20.java
 */
