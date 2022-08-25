/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-22 17:50:22
 * @LastEditTime: 2022-06-22 17:52:25
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MergeSortedArray_88.java
 */
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
// representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
// and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
public class MergeSortedArray_88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //从后往前 不用在用一个数组存储
            // m, n一开始是长度，--变成index，所以while里是>=0
            int pos = (m--) + (n--) - 1;
            // m, n类似双指针
            while (m >= 0 && n >= 0) {
                nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
            while (n >= 0) {
                nums1[pos--] = nums2[n--];
            }
        }
    }
}
