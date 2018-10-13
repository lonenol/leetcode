package com.lone.leetcode.k

import java.lang.Exception

/**
 * https://leetcode.com/problems/reverse-integer/
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * @author lone
 * @date  2018/9/30
 */
class Solution7 {
    fun reverse(x: Int): Int {
        if (x > -9 && x < 9) {
            return x
        }
        return try {
            if (x < 0) -1 * reverseInt(x.toString().substring(1)) else reverseInt(x.toString())
        } catch (e: Exception) {
            0
        }
    }

    private fun reverseInt(str: String): Int = str.reversed().toInt()
}
