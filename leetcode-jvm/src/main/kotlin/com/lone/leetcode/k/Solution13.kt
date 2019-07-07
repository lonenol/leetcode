package com.lone.leetcode.k

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author lone
 * @date  2018/11/5
 */
class Solution13 {
    fun romanToInt(s: String): Int {
        var nums = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        var symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var idx = 0
        var result = 0
        var i = 0
        while (i < s.length) {
            while (s.startsWith(symbols[idx], i)) {
                result += nums[idx]
                i += symbols[idx].length
            }
            idx++
        }
        return result

    }
}