package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 思路: 这道题核心的点是要计算每一个坐标能放下的水,而不是整体考虑,因为每一个坐标都可能影响整体
 * 1. 暴力循环. 就当前坐标左边  右边的最大值,然后能算出当前位置能装的水是多少
 * 2. 先循环记录左右最大值,然后直接取,类似 dp
 * 3. 双指针法
 */
public class Solution42 {

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0,rightMax = 0,sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;

    }

    public int trap_dp_maybe(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        int l = height[0],r = height[n-1];
        for (int i = 0; i < n; i++) {
            l = Math.max(l, height[i]);
            lMax[i] = l;
        }
        for (int i = n - 1; i >= 0; i--) {
            r = Math.max(height[i], r);
            rMax[i] = r;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return sum;
    }
}
