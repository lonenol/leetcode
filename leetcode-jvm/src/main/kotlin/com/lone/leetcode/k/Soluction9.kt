package com.lone.leetcode.k

/**
 * https://leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * 没有判断溢出的情况,还好leetcode里没有这个用例..
 * Input: -121
 * Output: false
 * @author lone
 * @date  2018/10/15
 */
class Soluction9 {
    fun isPalindrome(x: Int): Boolean {
        return when {
            x < 0 -> false
            x < 10 -> true
            else -> reverse(x) == x

        }
    }

    private fun reverse(x: Int): Int {
        var result = 0
        var tmp = x
        while (tmp != 0) {
            result = result*10 + tmp %10
            tmp /= 10
        }
        return result
    }
}