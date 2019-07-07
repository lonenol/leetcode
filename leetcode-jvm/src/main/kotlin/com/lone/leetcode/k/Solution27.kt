package com.lone.leetcode.k

/**
 * @author ljl133110
 * @date  2018-12-31
 */
class Solution27 {
    fun removeElement(nums: IntArray, value: Int): Int {
        var i = 0
        for (j in 0 until nums.size) {
            if(nums[j] != value) {
                nums[i++] = nums[j]
            }
        }
        return i

    }
}