package com.lone.leetcode.j;

/**
 * @author liujinlong
 * @date 2018/9/11
 */
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1,nums2);
        int first,second;
        int total = merged.length;
        if(total % 2 == 0) {
            first = total / 2 -1;
            second = first + 1;
        } else {
            first = total / 2;
            second = first;
        }
        return (merged[first] + merged[second])/2.0;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] > nums2[j]) {
                merged[k++] = nums2[j++];
            } else {
                merged[k++] = nums1[i++];
            }
        }
        while(i<nums1.length) {
            merged[k++] = nums1[i++];
        }
        while(j<nums2.length) {
            merged[k++] = nums2[j++];
        }
        return merged;

    }
}
