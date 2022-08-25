/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-11 01:58:17
 * @LastEditTime: 2022-08-11 17:04:29
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Hash/MaxPointsOnALine_149.java
 */
package Hash;

import java.util.HashMap;

public class MaxPointsOnALine_149 {
    class Solution {
        // 处理斜率的时候要注意，浮点数精度会造成误差使答案有误，用公约数约完得到整数后用String保存是一巧妙方法，
        // 或者用、约完整数构造出独立多项式，但比较麻烦
        // 在 % 的本质看一个公式!!!!a%b=a-a/b*b
        public int maxPoints(int[][] points) {
            // ans一开始设为1！否则只有一个点的话怎么办？？？
            int ans = 1;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < points.length; i++) {
                int same = 0;
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        same++;
                    } else {
                        // 这里gcd很巧妙，如dx, dy对应(-5, 3)和（5, -3）斜率其实是一样的
                        // 但化成字符串可能不对，但这里gcd会让得到1 和 -1，除完以后是一样的！
                        int dx = points[i][0] - points[j][0];
                        int dy = points[i][1] - points[j][1];
                        int gcd = gcd(dx, dy);
                        dx = dx / gcd;
                        dy = dy / gcd;
                        String key = String.valueOf(dx + "/" + dy);
                        // default设为1，即包含计算了i点自己，same才可为0
                        map.put(key, map.getOrDefault(key, 1) + 1);
                        
                    }
                }
                // ans = Math.max(ans, sameX);
                for (int value : map.values()) {
                    ans = Math.max(ans, value + same);
                }
                // Don't forget to clear the map! Or there will be repeated counts!
                map.clear();
            }
            return ans;
        }
        public int gcd(int a, int b) {
            // 在 % 的本质看一个公式!!!!a%b=a-a/b*b
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}