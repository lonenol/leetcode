package com.lone.leetcode.j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 思路:
 * 全局排序，O(n*lg(n))
 *
 * 局部排序，只排序TopK个数，O(n*k) 冒泡维护前 k 个的顺序
 *
 * 堆，TopK个数也不排序了，O(n*lg(k))
 *
 * TopK的另一个解法：随机选择+partition
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        return findTopK(nums, 0, nums.length - 1,k);
    }

    public int findTopK(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int part = partition(nums, start, end);
        if (part == k - 1) {
            return nums[k - 1];
        } else if(part > k - 1) {
            /*在前半部分*/
            return findTopK(nums, start, part-1, k);

        } else {
            /*在后半部分*/
            return findTopK(nums, part+1, end, k);
        }
    }
    public int partition(int[] nums, int start, int end) {
        int left = start, right = end + 1;
        int tar = nums[start];
        while (true) {
            while (nums[++left] > tar) {
                if(left >= end) break;
            }
            while (nums[--right] < tar) {
                if(right <= start) break;
            }
            if (left >= right) {
                break;
            }
            exchange(nums, left, right);
        }
        exchange(nums, start, right);
        return right;
    }

    private void exchange(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public int findKthLargest_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
        for (int i : nums) {
            pq.offer(i);
        }
        while (k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        solution215.findKthLargest(new int[] {7,6,5,4,3,2,1}, 2);
    }
}
