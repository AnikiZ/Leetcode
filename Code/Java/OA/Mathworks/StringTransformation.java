package OA.Mathworks;

public class StringTransformation {
    private static final int M = 1000000007;

    private static int add(int x, int y) {
        x += y;
        if (x >= M) {
            x -= M;
        }
        return x;
    }

    private static int mul(long x, long y) {
        return (int) ((x * y) % M);
    }

    public static int solution(String s, String t, int k) {
        int n = s.length();
        int[] dp = {1, 0};
        
        for (; k > 0; --k) {
            dp = new int[]{mul(dp[1], n - 1), add(dp[0], mul(n - 2, dp[1]))};
        }
        
        int r = 0;
        for (int i = 0; i < n; ++i) {
            boolean ok = true;
            for (int j = 0; ok && j < n; ++j) {
                ok = s.charAt((i + j) % n) == t.charAt(j);
            }
            if (ok) {
                r = add(r, dp[i == 0 ? 0 : 1]);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcd", "cdab", 2));
        System.out.println(solution("aaaa", "aaaa", 1));
        System.out.println(solution("ababab", "ababab", 1));
    }
}
