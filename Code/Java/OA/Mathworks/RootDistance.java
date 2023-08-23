package OA.Mathworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RootDistance {

    static List<List<Integer>> g;
    static List<Long> sum;
    static List<Long> dp;

    public static void dfs(int s, int p, List<Integer> a) {
        sum.set(s, (long) a.get(s - 1));
        for (int j : g.get(s)) {
            if (j == p) {
                continue;
            }
            dfs(j, s, a);
            sum.set(s, sum.get(s) + sum.get(j));
            dp.set(s, dp.get(s) + dp.get(j) + sum.get(j));
        }
    }

    public static void dfs2(int s, int p) {
        for (int j : g.get(s)) {
            if (j == p) {
                continue;
            }
            dp.set(j, dp.get(j) + dp.get(s) - (dp.get(j) + sum.get(j)) + sum.get(1) - sum.get(j));
            dfs2(j, s);
        }
    }

    public static long maxBeauty(int tree_nodes, List<Integer> tree_from, List<Integer> tree_to, List<Integer> a) {
        g = new ArrayList<>();
        for (int i = 0; i <= tree_nodes; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < tree_nodes - 1; i++) {
            int x = tree_from.get(i);
            int y = tree_to.get(i);
            g.get(x).add(y);
            g.get(y).add(x);
        }

        sum = new ArrayList<>(Collections.nCopies(tree_nodes + 1, 0L));
        dp = new ArrayList<>(Collections.nCopies(tree_nodes + 1, 0L));

        dfs(1, 0, a);
        dfs2(1, 0);

        return Collections.max(dp);
    }

    public static void main(String[] args) {
        // Test the function with sample data
        List<Integer> tree_from = Arrays.asList(1, 3, 3);
        List<Integer> tree_to = Arrays.asList(3, 4, 2);
        List<Integer> a = Arrays.asList(1, 1, 4, 3);
        System.out.println(maxBeauty(4, tree_from, tree_to, a)); // sample call
    }
}
