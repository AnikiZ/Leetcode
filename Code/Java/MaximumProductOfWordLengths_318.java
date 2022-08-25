/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-31 16:14:03
 * @LastEditTime: 2022-07-31 17:57:19
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaximumProductOfWordLengths_318.java
 */
import java.util.HashMap;

public class MaximumProductOfWordLengths_318 {
    class Solution {
        public int maxProduct(String[] words) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (String word : words) {
                int len = word.length();
                int mask = 0;
                for (int i = 0; i < len; i++) {
                    mask |= 1 << (word.charAt(i) - 'a');
                }
                map.put(mask, Math.max(len, map.getOrDefault(mask, 0)));
                // map.forEach((key, value) -> {
                //     if ((key & mask) == 0) {
                //     ans 用不了
                //         ans = Math.max(ans, value * len);
                //     }
                // });
                for (int key : map.keySet()) {
                    if ((key & mask) == 0) {
                        ans = Math.max(ans, map.get(key) * len);
                    }
                }
            }
            return ans;
        }
    }
}
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-31 16:14:03
 * @LastEditTime: 2022-07-31 17:42:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MaximumProductOfWordLengths_318.java
 */
