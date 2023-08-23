package OA.Mathworks;

import java.util.Arrays;

public class AlloyProduction {
    public static int solution(int[] composition, int[] stock, int[] cost, int budget) {
        int left = 1;
        int right = (budget / Arrays.stream(cost).min().getAsInt() + Arrays.stream(stock).max().getAsInt()) / Arrays.stream(composition).min().getAsInt();
        int n = composition.length;

        while (left <= right) {
            long mid = (left + right) >> 1;
            long b = budget;
            for (int i = 0; b >= 0 && i < n; ++i) {
                b -= Math.max(0L, mid * composition[i] - stock[i]) * cost[i];
            }
            if (b >= 0) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}, new int[]{0, 1}, new int[]{1, 1}, 3));
        System.out.println(solution(new int[]{2, 1, 2}, new int[]{1, 0, 0}, new int[]{2, 2, 1}, 14));
        System.out.println(solution(new int[]{2, 2, 3, 1}, new int[]{3, 2, 1, 4}, new int[]{2, 3, 1, 6}, 30));
    }
}
