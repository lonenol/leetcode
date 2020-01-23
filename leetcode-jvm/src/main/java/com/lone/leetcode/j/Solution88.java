package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 思路:从前往后合并要么需要额外的空间,要么需要移动很多元素,所以考虑从后向前合并
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1, i = m -1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }
}
