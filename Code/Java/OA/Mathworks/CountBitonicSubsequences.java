package OA.Mathworks;

public class CountBitonicSubsequences {
    private static final int M = 1000000007;

    private static int mul(long x, long y) {
        return (int)((x * y) % M);
    }

    private static void add(int[] x, int idx, int y) {
        x[idx] += y;
        if (x[idx] >= M) {
            x[idx] -= M;
        }
    }

    public static int solution(int[] v) {
        int n = v.length;
        int[] dpv = new int[201];
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < v[i]; ++j) {
                add(dp, i, dpv[j]);
            }
            add(dpv, v[i], dp[i]);
            add(dpv, v[i], 1);
        }

        dpv = new int[201];
        int r = 0;

        for (int i = n - 1; i >= 0; --i) {
            int sum = 0;
            for (int j = 0; j < v[i]; ++j) {
                sum += dpv[j];
                if (sum >= M) {
                    sum -= M;
                }
            }
            r += mul(sum, dp[i]);
            if (r >= M) {
                r -= M;
            }
            
            dpv[v[i]] += sum;
            if (dpv[v[i]] >= M) {
                dpv[v[i]] -= M;
            }
            
            dpv[v[i]] += 1;
            if (dpv[v[i]] >= M) {
                dpv[v[i]] -= M;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 2, 1}));
    }
}
