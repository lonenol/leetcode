package com.lone.leetcode.k

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author lone
 * @date  2018/11/14
 */
class Solution14 {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 0) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        var ret = ""
        var idx = 0
        while (idx < strs[0].length) {
            val cur = strs[0][idx]
            for( start in 1 until  strs.size ) {
                if (idx >= strs[start].length || strs[start][idx] != cur) {
                    return ret
                }
            }
            ret += cur
            idx++
        }
        return ret
    }
}