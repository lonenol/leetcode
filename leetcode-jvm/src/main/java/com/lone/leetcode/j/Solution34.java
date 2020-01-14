package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 思路: 就是二分查找,可以写个最简单的,然后分别向左右循环,找到第一个和最后一个.
 * 也可以利用小技巧,直接找到第一个或者最后一个元素,然后向一个方向循环找另外一个.
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                first = last = mid;
                while (first - 1 >=0 &&nums[first - 1] == target) {
                    first--;
                }
                while(last + 1 < nums.length && nums[last+1] == target) {
                    last++;
                }
                break;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }

        }
        return new int[] {first, last};
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(solution34.searchRange(arr, 8));
    }
}
