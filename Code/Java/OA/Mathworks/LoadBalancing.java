package OA.Mathworks;

public class LoadBalancing {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public static int splitArray(int[] nums, int k) {
        // binary search
        int left = 0, right = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static boolean check(int[] nums, int x, int k) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= k;
    }
}
