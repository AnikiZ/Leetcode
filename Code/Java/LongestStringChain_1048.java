import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-15 21:20:12
 * @LastEditTime: 2022-06-15 21:33:34
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /LeetCode/Code/Java/LongestStringChain_1048.java
 */
public class LongestStringChain_1048 {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(Solution.longestStrChain(words));
    }
    class Solution {
        public static int longestStrChain(String[] words) {
            Arrays.sort(words, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();
                }
            });
            Map<String, Integer> map = new HashMap<>();
            int ans = 0;
            for (String word : words) {
                int cnt = 1;
                for (int l = 0; l < word.length(); l++) {
                    StringBuilder sb = new StringBuilder(word);
                    String sub = sb.deleteCharAt(l).toString();
                    System.out.println("sub:" + sub);
                    if (map.containsKey(sub)) {
                        cnt = Math.max(cnt, map.get(sub) + 1);
                    }
                }
                map.put(word, cnt);
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }
}
