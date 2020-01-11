package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Solution912_quicksort {
    public List<Integer> sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        sort(nums, 0, nums.length - 1);
        List<Integer> ret = new ArrayList<>();
        for (int i : nums) {
            ret.add(i);
        }
        return ret;
    }

    private void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }
        int pa = partition(nums, low, hi);
        sort(nums,low,pa - 1);
        sort(nums, pa + 1, hi);
    }

    private int partition(int[] nums, int low, int hi) {
        int i = low, j = hi + 1;
        int part = nums[low];
        while(true) {
            while (nums[++i] < part) {
                if (i >= hi) {
                    break;
                }
            }
            while(nums[--j] > part) {
                if(j <= low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(nums, i, j);
        }
        exchange(nums, low, j);
        return j;
    }

    private void exchange(int[] num,int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
