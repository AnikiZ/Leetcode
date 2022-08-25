import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-08 10:48:40
 * @LastEditTime: 2022-07-08 15:47:36
 * @LastEditors: Zeping Zhu
 * @Description:
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 * 处理重复元素方法：对数组nums排序后，限定重复（相邻）元素的选取准则以保证对于任意
 * 位置idx，若选取的数在nums中有重复，必须从左到右选，唯一顺序
 
 * @FilePath: /Code/Java/PermutationsII_47.java
 */

public class PermutationsII_47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> permute = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            dfs(nums, nums.length, visited, ans, permute);
            return ans;
        }
        public void dfs(int[] nums, int len, boolean[] visited, List<List<Integer>> ans, List<Integer> permute) {
            if (permute.size() == len) {
                // new!!!
                ans.add(new ArrayList<>(permute));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                        continue;
                    }
                    permute.add(nums[i]);
                    visited[i] = true;
                    dfs(nums, len, visited, ans, permute);
                    // 还原！！！
                    visited[i] = false;
                    permute.remove(permute.size() - 1);
                }
            }
        }
    }
}
