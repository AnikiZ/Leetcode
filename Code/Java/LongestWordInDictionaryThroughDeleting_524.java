import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-23 16:47:23
 * @LastEditTime: 2022-06-23 17:22:39
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LongestWordInDictionaryThroughDeleting_524.java
 */
public class LongestWordInDictionaryThroughDeleting_524 {
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            List<String> words = new ArrayList<String>();
            for (String word : dictionary) {
                if (check(word, s)) {
                    words.add(word);
                }
            }
            Collections.sort(words, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    if (s1.length() != s2.length()) {
                        return s2.length() - s1.length();
                    } else {
                        return s1.compareTo(s2);
                    }
                }
            });
            return words.size() == 0 ? "" : words.get(0);
        }
        public boolean check(String word, String s) {
            int i = 0; 
            int j = 0;
            // 用while比较好，i和j必须小于字符串长度！
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == word.length();
        }
    }
    class Solution_DP {
        public String findLongestWord(String s, List<String> dictionary) {
            int m = s.length();
            int[][] f = new int[m + 1][26];
            Arrays.fill(f[m], m);
    
            for (int i = m - 1; i >= 0; --i) {
                for (int j = 0; j < 26; ++j) {
                    if (s.charAt(i) == (char) ('a' + j)) {
                        f[i][j] = i;
                    } else {
                        f[i][j] = f[i + 1][j];
                    }
                }
            }
            String res = "";
            for (String t : dictionary) {
                boolean match = true;
                int j = 0;
                for (int i = 0; i < t.length(); ++i) {
                    if (f[j][t.charAt(i) - 'a'] == m) {
                        match = false;
                        break;
                    }
                    j = f[j][t.charAt(i) - 'a'] + 1;
                }
                if (match) {
                    if (t.length() > res.length() ||  (t.length() == res.length() && t.compareTo(res) < 0)) {
                        res = t;
                    }
                }
            }
            return res;
        }
    }
}
