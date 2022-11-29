import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-29 16:49:11
 * @LastEditTime: 2022-11-29 16:49:11
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Java/MissingRanges_163.java
 */
public class MissingRanges_163 {
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            int curr = lower;
            List<String> res = new ArrayList<>();
            for (int num : nums) {
                if(num == curr) {
                    curr++;
                } else if (num > curr) {
                    StringBuilder a = new StringBuilder();
                    a.append(curr);
                    if (num > (curr + 1)) {
                        a.append("->");
                        a.append(num - 1);
                    }
                    curr = num + 1;
                    res.add(a.toString());
                }
            }
            if (curr < upper) {
                StringBuilder a = new StringBuilder();
                a.append(curr);
                a.append("->");
                a.append(upper);
                res.add(a.toString());
            } else if (curr == upper) {
                StringBuilder a = new StringBuilder();
                a.append(upper);
                res.add(a.toString());
            }
            return res;
        }
    }
}
