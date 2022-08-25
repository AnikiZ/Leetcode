/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-18 11:13:44
 * @LastEditTime: 2022-08-18 17:02:18
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/String/ImplementstrStr_28.java
 */
package String;

import java.util.ArrayList;
import java.util.List;

public class ImplementstrStr_28 {
    class Solution {
        public static void main(String[] args) {
            String hey = "abababab";
            String needle = "abab";
            Solution.strStr(hey, needle);
        }
        // KMP method!
        public static int strStr(String haystack, String needle) {
            int len1 = haystack.length(), len2 = needle.length();
            // get all feasible solutions
            List<Integer> indexs = new ArrayList<>();

            // Notice important!
            if (len2 == 0) {
                return 0;
            }

            // update next array:
            int[] next = new int[len2];
            // i start from 1 because the fix not include itself!
            for (int i = 1, prefix = 0; i < len2; i++) {
                while (prefix > 0 && needle.charAt(i) != needle.charAt(prefix)) {
                    prefix = next[prefix - 1];
                }
                if (needle.charAt(i) == needle.charAt(prefix)) {
                    prefix++;
                }
                next[i] = prefix;
            }

            // match haystack and needle, same as update of next! amazing.
            for (int i = 0, j = 0; i < len1; i++) {
                while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                    j = next[j - 1];
                }
                if (needle.charAt(j) == haystack.charAt(i)) {
                    j++;
                }
                if (j == len2) {
                    // get all feasible solutions
                    indexs.add(i - len2 + 1);
                    j = next[j - 1];
                    // return i - len2 + 1;
                }
            }
            return -1;
        }
    }
}
