package OA.Mathworks;

public class CountSubarrays {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int n = nums.length, minI = -1, maxI = -1, leftBound = -1;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == minK) minI = i;
            if (x == maxK) maxI = i;
            if (x < minK || x > maxK) leftBound = i;
            ans += Math.max(0, Math.min(minI, maxI) - leftBound);
        }
        return ans;
    }
}
