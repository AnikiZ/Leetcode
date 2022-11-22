/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-21 16:03:49
 * @LastEditTime: 2022-11-21 16:23:03
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Tiktok/BullsandCows_299.java
 */
package Tiktok;

import java.util.HashMap;

public class BullsandCows_299 {
    class Solution {
        public String getHint(String secret, String guess) {
            StringBuilder ans = new StringBuilder();

            int len = secret.length();
            int a = 0, b = 0;
            // optimize: only ten numbers, replace map with array to improve efficiency!
            HashMap<Character, Integer> mapS = new HashMap<>();
            HashMap<Character, Integer> mapG = new HashMap<>();

            for (int i = 0; i < len; i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    a++;
                } else {
                    mapS.put(secret.charAt(i), mapS.getOrDefault(secret.charAt(i), 0) + 1);
                    mapG.put(guess.charAt(i), mapG.getOrDefault(guess.charAt(i), 0) + 1);
                }
            }

            for (char s : mapS.keySet()) {
                if (mapG.containsKey(s)) {
                    b += Math.min(mapS.get(s), mapG.get(s));
                }
            }

            ans.append(a);
            ans.append('A');
            ans.append(b);
            ans.append('B');

            return ans.toString();
        }
    }
}
