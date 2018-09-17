package com.lone.leetcode.k

import kotlin.math.max

/**
 *
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", which the length is 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 * @author lonenol
 * @date  2018/9/6
 */
class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var curStart = 0
        var longest = 0

        for ((idx,value) in s.withIndex()) {
            val preIndex = map[value]
            if (preIndex == null|| preIndex < curStart) {
                map[value] = idx
            } else {
                longest = maxOf(longest,(idx - curStart))
                curStart = preIndex + 1
                map[value] = idx
            }
        }
        return maxOf(longest, s.length - curStart)
    }
}

fun main(args: Array<String>) {
    val solution3 = Solution3()
    print(solution3.lengthOfLongestSubstring("abba"))
}