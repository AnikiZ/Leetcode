import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-02 20:44:35
 * @LastEditTime: 2022-07-02 21:33:02
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Permutations_46.java
 */
public class Permutations_46 {
    class Solution_MemoryUse {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            List<Integer> path = new ArrayList<>();
            dfs(nums, visited, 0, path, ans);
            return ans;
        }
        public void dfs(int[] nums, boolean[] visited, int depth, List<Integer> path, List<List<Integer>> ans) {
            if (depth == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0/*因为有visited储存了状态*/; i < visited.length; i++) {
                if (visited[i] == false) {
                    path.add(nums[i]);
                    visited[i] = true;
                    // System.out.println("  递归之前 => " + path);
                    dfs(nums, visited, depth + 1, path, ans);
                    visited[i] = false;
                    path.remove(path.size() - 1);
                    System.out.println("递归之后 => " + path);
                }
            }
        }
    }
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> numsList = new ArrayList<>();
            for (int i : nums) {
                numsList.add(i);
            }
            int len = numsList.size();
            dfs(numsList, len, 0, ans);
            return ans;
        }
        public void dfs(List<Integer> nums, int len, int depth, List<List<Integer>> ans) {
            if (depth == nums.size() - 1/*最后一次自己交换自己可以去掉*/) {
                ans.add(new ArrayList<Integer>(nums));
                return;
            }
            for (int i = depth/*没有visited, 直接在nums上进行修改*/; i < len; i++) {
                Collections.swap(nums, depth, i);
                dfs(nums, len, depth + 1, ans);
                Collections.swap(nums, depth, i);
            }
        }
    }
}
