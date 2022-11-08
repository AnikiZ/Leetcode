/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-07 17:58:33
 * @LastEditTime: 2022-11-07 17:58:33
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/Juan/UncommonWordsfromTwoSentences_884.java
 */
package Juan;

import java.util.HashMap;
import java.util.Map;

public class UncommonWordsfromTwoSentences_884 {
    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            String[] s1s = s1.split(" ");
            String[] s2s = s2.split(" ");
            
        
        
        }
    }
    class Solution_Chen {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> myMap = new HashMap<>();
            // record all words in s1 and s2, satisfied word will only appear once
            String con[] = new String[]{s1, s2};
            int size = 0;
            for (int j = 0; j < 2; j++) {
                int point = 0;
                // split?
                int length = con[j].length();
                for (int i = 0; i <= length; i++) {
                    if (i==length || con[j].charAt(i)==' ') {
                        String str = con[j].substring(point, i);
                        int count = myMap.getOrDefault(str, 0) + 1;
                        if (count == 1) {
                            size++;
                        } else if (count == 2) {
                            size--;
                        }
                        myMap.put(str, count);
                        point = i+1;
                    }
                }
            }
            String[] ans = new String[size];
            for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
                if (entry.getValue()==1) {
                    ans[--size]=entry.getKey();
                }
            }
            return ans;
        }
    }
}
