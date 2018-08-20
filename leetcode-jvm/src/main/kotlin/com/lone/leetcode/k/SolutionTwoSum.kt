package com.lone.leetcode.k

/**
 * @author liujinlong
 * @date  2018/8/20
 */
class SolutionTwoSum {
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
    SolutionTwoSum().twoSum(intArrayOf(2,7,1,2),9).forEach { print(it) }
}