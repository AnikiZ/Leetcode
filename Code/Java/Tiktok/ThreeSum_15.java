package Tiktok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int i = 0;
            while (i <= len - 3) {
                if (nums[i] > 0) {
                    return res;
                }
                if (i > 0 && nums[i]==nums[i-1]) {
                    i++;
                    continue;
                }
                int left = i + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        // avoid duplication!
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        // update left and right
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
                i++;
            }
            return res;
        }
    }
}