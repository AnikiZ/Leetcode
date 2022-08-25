import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-12 20:32:53
 * @LastEditTime: 2022-07-14 16:37:45
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/PartitionEqualSubsetSum_416.java
 */
public class PartitionEqualSubsetSum_416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 1 || n == 1) {
                return false;
            }
            int target = sum / 2;
            boolean[][] dp = new boolean[n + 1][target + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    
                }
            }
            return dp[n][target];
        }
    }
    class Solution_Opt {
        // 节省空间
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 1 || n == 1) {
                return false;
            }
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            for (int i = 0; i <= n; i++) {
                dp[0] = true;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = target; j > 0; j--) {
                    if (j >= nums[i - 1]) {
                        dp[j] = dp[j] || dp[j - nums[i - 1]];
                    } else {
                        dp[j] = dp[j];
                    }
                    
                }
            }
            return dp[target];
        }
    }
    class Solution_Wrong {
        // [5, 4, 3, 3, 3]不行！
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for (int i : nums) {
                sum += i;
            }
            if (sum % 2 == 1 || n == 1) {
                return false;
            }
            List<Integer> n1 = new ArrayList<>();
            List<Integer> n2 = new ArrayList<>();
            int sum1 = 0, sum2 = 0;
            ArrayList<Integer> n0 = new ArrayList<Integer>();
            for (int i : nums) {
                n0.add(i);
            }
            Collections.sort(n0, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i : n0) {
                if (sum1 <= sum2) {
                    n1.add(i);
                    sum1 += i;
                } else {
                    n2.add(i);
                    sum2 += i;
                }
            }
            if (sum1 == sum2) {
                return true;
            } else {
                return false;
            }
        }
    }
}
