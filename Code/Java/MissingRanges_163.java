import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-11-29 16:49:11
 * @LastEditTime: 2022-11-29 18:32:49
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
    class Solution_B {
        public List<String> findMissingRanges(int[] a, int lo, int hi) {
            List<String> res = new ArrayList<String>();
      
            // the next number we need to find
            int next = lo;
            
            for (int i = 0; i < a.length; i++) {
                // not within the range yet
                if (a[i] < next) continue;
                
                // continue to find the next one
                if (a[i] == next) {
                    next++;
                    continue;
                }
                
                // get the missing range string format
                res.add(getRange(next, a[i] - 1));
                
                // now we need to find the next number
                next = a[i] + 1;
            }
            
            // do a final check
            if (next <= hi) res.add(getRange(next, hi));
            
            return res;
        }
        
        String getRange(int n1, int n2) {
            return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
        }
    }
}
