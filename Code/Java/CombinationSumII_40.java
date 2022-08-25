import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-08 16:17:38
 * @LastEditTime: 2022-07-08 16:50:57
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/CombinationSumII_40.java
 */
public class CombinationSumII_40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, ans, path, 0, 0, candidates.length);
            return ans;
        }
        public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int depth, int sum, int len) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = depth; i < len; i++) {
                // 关键，对于同一层，排序好了，之后相同数字没必要选，只会是真子集且会出现重复答案！
                if (i > depth && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] + sum > target) {
                    return;
                }
                if (candidates[i] + sum <= target) {
                    path.add(candidates[i]);
                    sum = sum + candidates[i];
                    dfs(candidates, target, ans, path, i + 1, sum, len);
                    sum = sum - candidates[i];
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
