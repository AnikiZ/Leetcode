/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-16 10:11:43
 * @LastEditTime: 2022-08-16 19:47:04
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/ValidAnagram_242.java
 */
package String;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram_242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            // 这个判断很关键！省时间的同时，下面判断map有负数就返回false，一直没有就返回true，不然会出问题
            if (s.length() != t.length()) {
                return false;
            }
            HashMap<Character, Integer> map =  new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
                if (map.get(t.charAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }
        public boolean isAnagram_Sort(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            char[] a = s.toCharArray();
            char[] b = t.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a, b);
        }
    }
}