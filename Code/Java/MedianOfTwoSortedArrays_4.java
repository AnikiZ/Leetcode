/*
 * @Author: Zeping Zhu
 * @Andrew ID: zepingz
 * @Date: 2022-06-27 18:26:46
 * @LastEditTime: 2022-06-27 18:26:47
 * @LastEditors: Zeping Zhu
 * @Description: 
 * @FilePath: /Code/Java/MedianOfTwoSortedArrays_4.java
 */
public class MedianOfTwoSortedArrays_4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int totalLen = len1 + len2;
            if ((totalLen) % 2 == 1) {
                return getKthElement(nums1, nums2, (totalLen) / 2 + 1);
            } else {
                int mid1 = totalLen / 2;
                int mid2 = totalLen / 2 + 1;
                return (getKthElement(nums1, nums2, mid1) + getKthElement(nums1, nums2, mid2)) / 2.0;
            }
        }
        public int getKthElement(int[] nums1, int[] nums2, int kth) {
            /* 主要思路：要找到第 k (k>1) 小的元素，(k为1就直接比较当前nums1和nums2的index元素返回)
             * 那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 
             * (k/2-1) + (k/2-1) <= k-2 个
             * 这样 pivot 本身最大也只能是第 k-1 小的元素
             * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。
             * 把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。
             * 把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             */
            int index1 = 0, index2 = 0;
            int len1 = nums1.length, len2 = nums2.length;
            while (true) {
                // corner case
                if (index1 == len1) {
                    return nums2[index2 + kth - 1];
                }
                if (index2 == len2) {
                    return nums1[index1 + kth - 1];
                }
                if (kth == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                // normal case (kth > 1)
                int half = kth / 2;
                int realIndex1 = Math.min(index1 + half - 1, len1 - 1);
                int realIndex2 = Math.min(index2 + half - 1, len2 - 1);
                if (nums1[realIndex1] <= nums2[realIndex2]) {
                    kth -= realIndex1 - index1 + 1;
                    index1 = realIndex1 + 1;
                } else {
                    kth -= realIndex2 - index2 + 1;
                    index2 = realIndex2 + 1;
                }
            }
        }
    }
}
