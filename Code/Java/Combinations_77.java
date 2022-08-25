import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-07-03 17:46:47
 * @LastEditTime: 2022-07-04 15:55:30
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Combinations_77.java
 */
public class Combinations_77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> comb = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, comb, n, k, 1);
            return ans;
        }
        public void dfs(List<List<Integer>> ans, List<Integer> comb, int n, int k, int depth) {
            if (comb.size() == k) {
                ans.add(new ArrayList<>(comb));
                return;
            }
            //剪枝
            if (comb.size() + (n - depth) + 1 < k) {
                return;
            }
            for (int i = depth; i <= n; i++) {
                comb.add(i);
                dfs(ans, comb, n, k, i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
