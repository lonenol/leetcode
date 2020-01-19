package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int n = A.length;
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i] + A[i - 1];
        }
        int max = A[n - 1];
        if (max % 3 != 0) {
            return false;
        }
        int first = max / 3;
        int second = first * 2;
        int fi = n+1, si = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == first) {
                fi= Math.min(i,fi);
            }
            if (A[i] ==  second) {
                si = Math.max(si, i);
            }
        }
        return fi >= 0 && si >= 0 && fi < si;

    }

    public static void main(String[] args) {
        int[] arr = {12,-4,16,-5,9,-3,3,8,0};
        Solution1013 solution1023 = new Solution1013();
        solution1023.canThreePartsEqualSum(arr);
    }
}
