/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-10 15:47:59
 * @LastEditTime: 2022-08-12 14:50:26
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Hash/LongestConsecutiveSequence_128.java
 */
package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence_128 {
    // 错的！有的极端算例过不去，如-9999,-9998,...
    // 该算法每个num都会查询一次删除一次，固定O(2n)
    class Solution {
        public static void main(String[] args) {
            int[] nums = {0,3,7,2,5,8,4,6,0,1};
            int ans = Solution.longestConsecutive(nums);
            System.out.println(ans);
        }
        public static int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            Iterator<Integer> iter = set.iterator();
            int ans = 0;
            while (iter.hasNext()){
                int num = iter.next();
                iter.remove();
                int prev = num - 1, next = num + 1;
                while (set.contains(prev)) {
                    set.remove(prev--);
                }
                while (set.contains(next)) {
                    set.remove(next++);
                }
                ans = Math.max(ans, next - prev - 1);
                iter = set.iterator();
            }
            return ans;
        }
    }
    // 可以通过，最坏情况O(2n),若一开始就找到了最小的那个数字，就是O(n)，更快
    class Solution_O {
        public int longestConsecutive(int[] nums) {
            int ans = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int n : set) {
                if (!set.contains(n - 1)) {
                    int count = 1;
                    while (set.contains(n + 1)) {
                        count++;
                        n++;
                    }
                    ans = Math.max(ans, count);
                }
            }
            return ans;
        }
    }
    class Solution_DP {
        public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int ans = 0;
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    int left = map.getOrDefault(num - 1, 0);
                    int right = map.getOrDefault(num + 1, 0);
                    int len = left + right + 1;
                    map.put(num, len);
                    map.put(num - left, len);
                    map.put(num + right, len);
                    ans = Math.max(ans, len);
                }
            }
            return ans;
        }
    }
    class Solution_BCJ {
        public int longestConsecutive(int[] nums) {
            int more = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            return more;
        }
    }
}
