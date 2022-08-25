/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-16 20:04:58
 * @LastEditTime: 2022-08-16 21:21:47
 * @LastEditors: Zeping Zhu
 * @Description:
 * @FilePath: /Code/Java/Collections/IsomorphicStrings_205.java
 */
package String;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings_205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Integer> mapS = new HashMap<>();
            HashMap<Character, Integer> mapT = new HashMap<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                // 傻逼记着！Integer要用equals！
                if (!mapS.getOrDefault(s.charAt(i), -1).equals(mapT.getOrDefault(t.charAt(i), -1))) {
                    return false;
                }
                mapS.put(s.charAt(i), i);
                mapT.put(t.charAt(i), i);
            }
            return true;
        }
    }
    // 用数组可以提高效率，256足够
    // 用String的indexOf方法来做，更方便
    class Solution_Convenient {
        public boolean isIsomorphic(String s, String t) {
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.indexOf(ss[i]) != t.indexOf(tt[i])) {
                    return false;
                }
            }
            return true;
        }
    }
    // 数组 实测更快
    class Solution_Array {
        public boolean isIsomorphic(String s, String t) {
            int[] ss = new int[256];
            int[] tt = new int[256];
            Arrays.fill(ss, -1);
            Arrays.fill(tt, -1);
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if (ss[c1] == -1 && tt[c2] == -1) {
                    ss[c1] = c2;
                    tt[c2] = c1;
                } else if(ss[c1] != c2) {
                    return false;
                }
            }
            return true;
        }
    }
 }