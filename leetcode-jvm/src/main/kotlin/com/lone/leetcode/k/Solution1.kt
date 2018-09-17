package com.lone.leetcode.k

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @date 2018/8/20
 */
class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed{idx, value->
            if (map[value] != null) {
                return intArrayOf(map[value]!!,idx)
            } else {
                map[target - value] = idx
            }
        }
        throw IllegalArgumentException("No two sum solution")

    }
}

fun main(args: Array<String>) {
    Solution1().twoSum(intArrayOf(2,7,1,2),9).forEach { print(it) }
}