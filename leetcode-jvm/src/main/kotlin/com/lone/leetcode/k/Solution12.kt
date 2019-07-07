package com.lone.leetcode.k

/**
 * @author lone
 * @date  2018/10/30
 */
class Solution12 {
    fun intToRoman(num: Int): String {

        var nums = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        var symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var result = ""
        var tmp = num
        for (i in 0 until nums.size) {
            while (tmp >= nums[i]) {
                result += symbols[i]
                tmp -= nums[i]
            }

        }
        return result
    }
}