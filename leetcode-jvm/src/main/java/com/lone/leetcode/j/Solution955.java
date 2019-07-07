package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 *
 * 难点在于大小比较某一列是否删除时,依赖前边所有未删除的列,
 * 所以可以不复制数组,而是用一个 boolean 数组记录某一列是否被删除
 * @author ljl133110
 * @date 2019-07-07
 */
public class Solution955 {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 1 || A[0].length() == 0) {
            return 0;
        }
        int ans = 0;
        String[] left = new String[A.length];
        for (int i = 0; i < A[0].length(); i++) {
            String[] tmp = Arrays.copyOf(left, left.length);
            for (int j = 0; j < A.length; j++) {
                tmp[j] = tmp[j] == null?  ""+A[j].charAt(i) :(tmp[j] + A[j].charAt(i));
            }
            boolean isSorted = true;
            for (int k = 1; k < A.length; k++) {
                if (tmp[k - 1].compareTo(tmp[k]) > 0) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                left = tmp;
            } else {
                ans++;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        Solution955 solution955 = new Solution955();
//        String[] input =  {"zyx","wvu","tsr"};
        String[] input = { "ca","bb","ac" };
        System.out.println(solution955.minDeletionSize(input));
    }
}
