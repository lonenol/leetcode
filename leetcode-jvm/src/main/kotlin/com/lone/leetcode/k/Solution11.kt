package com.lone.leetcode.k

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * @author lone
 * @date  2018/10/27
 */
class Solution11 {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = -1
        while (left < right) {
            max = maxOf(max,(right - left) * minOf(height[left],height[right]))
            if (height[left] <= height[right]) {
                left++
            } else {
                right--
            }
        }
        return max

    }
}