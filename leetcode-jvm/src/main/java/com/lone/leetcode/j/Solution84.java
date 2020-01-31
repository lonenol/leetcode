package com.lone.leetcode.j;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 思路:
 * 1. 暴力法, 每个点都算一次最大值,求最大的
 */
public class Solution84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }

    public int largestRectangleArea_divide(int[] heights) {
        return divide(heights, 0, heights.length - 1);
    }

    private int divide(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int min = start;
        for (int i = start + 1; i <= end; i++) {
            if (heights[i] < heights[min]) {
                min = i;
            }
        }
        int area = (end - start + 1) * heights[min];
        return Math.max(area, Math.max(divide(heights, start, min - 1), divide(heights, min + 1, end)));
    }

    public int largestRectangleArea_brute(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                area = Math.max(area, (j - i + 1) * minHeight);
            }
        }
        return area;
    }
}
