import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-27 15:18:44
 * @LastEditTime: 2022-06-27 15:28:14
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/LongestSubstringWithAtMostKDistinctCharacters_340.java
 */
public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    //给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int cnt = 0;
            if (k == 0) {
                return cnt;
            }
            int left = 0;
            int right = 0;
            Map<Character, Integer> subString = new HashMap<Character, Integer>();
            while (right < s.length()) {
                subString.put(s.charAt(right), right++);
                if (subString.size() > k) {
                    int delIndex = Collections.min(subString.values());
                    subString.remove(s.charAt(delIndex));
                    left = delIndex + 1;
                }
                // right++ above, so cnt = right - left!!!
                cnt = Math.max(cnt, right - left);
            }
            return cnt;
        }
    }
    class Solution_LinkedHashMap {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
          int n = s.length();
          if (n*k == 0) return 0;
      
          // sliding window left and right pointers
          int left = 0;
          int right = 0;
          // hashmap character -> its rightmost position 
          // in the sliding window
          LinkedHashMap<Character, Integer> hashmap = new LinkedHashMap<Character, Integer>(k + 1);
      
          int max_len = 1;
      
          while (right < n) {
            Character character = s.charAt(right);
            // if character is already in the hashmap -
            // delete it, so that after insert it becomes
            // the rightmost element in the hashmap
            if (hashmap.containsKey(character))
              hashmap.remove(character);
            hashmap.put(character, right++);
      
            // slidewindow contains k + 1 characters
            if (hashmap.size() == k + 1) {
              // delete the leftmost character
              // Like Linked List, ensure the first element in the linkedMap
              // is the leftmost index to delete in the window to decrease map's size.
              Map.Entry<Character, Integer> leftmost = hashmap.entrySet().iterator().next();
              hashmap.remove(leftmost.getKey());
              // move left pointer of the slidewindow
              left = leftmost.getValue() + 1;
            }
      
            max_len = Math.max(max_len, right - left);
          }
          return max_len;
        }
      }
}
