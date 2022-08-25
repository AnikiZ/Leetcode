/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-08-14 02:41:48
 * @LastEditTime: 2022-08-14 16:50:34
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/Collections/FindTheDuplicateNumber_287.java
 */
package Collections;

public class FindTheDuplicateNumber_287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            int l = 1, r = n - 1;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                int count = 0;
                for (int num : nums) {
                    if (mid >= num) {
                        count++;
                    }
                }
                if (count <= mid) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return r;
        }
    }
    class Solution_CycleDetection {
        // index : [0, n] element:[1, n]
        // each new element is an element in nums at the index of the previous element
        // produce a linked list with a cycle because of duplicate element, which is the cycle entrance
        public int findDuplicate(int[] nums) {
            int slow = 0, fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast); // 应该判断slow和fast是否相等，即对应的index一样了，如果用nums[slow] == nums[fast]
                                    // 因为有重复元素所以可能index不同也会相等
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
    }
}
