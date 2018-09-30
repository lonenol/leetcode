package com.lone.leetcode.k

import sun.security.util.Length

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 以每个字符为中心向两边查,需要考虑基数和偶数
 *
 * @author lone
 * @date 2018/9/18
 */
class Solution5 {

    fun longestPalindrome(s: String): String {
        if (s.length <= 1) {
            return s
        }
        var str = "^"
        s.forEach { str += "#$it" }
        str +="$"
        val p = IntArray(str.length){1}
        var id = 0
        var mx = 0
        var maxIndex = 0
        var max = 1
        for(i in 1 until str.length) {
            if(mx <= i) {
                p[i] = calRadius(str,i,1)
            } else {
                val left = 2*id - i

                if(mx -i < p[left]) {
                    p[i] = p[left]
                } else {
                    p[i] = calRadius(str,i,p[left])
                }
            }
            if(p[i] >=  max) {
                max = p[i]
                maxIndex = i
            }
        }
        var ret = ""
        for (i in (maxIndex - p[maxIndex] + 1) .. (maxIndex + p[maxIndex] -1)) {
            if(str[i] != '#') {
                ret +=str[i]
            }
        }
        return ret
    }

    private fun calRadius(s: String, i: Int, minLength: Int): Int {
        var len = minLength
        while(true) {
            if(i-len < 0 || i+len >= s.length || s[i-len] != s[i+len]) {
                break
            }
            len++
        }
        return len

    }
}

fun main(args: Array<String>) {
    val so = Solution5()
    println(so.longestPalindrome("abba"))
    println(so.longestPalindrome("babad"))
    println(so.longestPalindrome("bb"))
}