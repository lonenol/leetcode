package com.lone.leetcode.k

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * @author lone
 * @date  2018/10/8
 */
class Solution8 {
    fun myAtoi(str: String): Int {
        var ret = 0
        var positive = true
        var start = 0
        while (start < str.length) {
            val cur = str[start]
            if (cur == ' ') {
                start++
                continue
            } else if (cur == '-') {
                positive = false
                start++
                break
            } else if (cur == '+') {
                start++
                break
            } else {
                break
            }
        }
        if (start >= str.length) {
            return 0
        }
        while (start < str.length) {
            val cur = str[start++] - '0'
            if (cur !in 0..9) {
                break
            }
            val i = if(positive) cur  else cur * -1
            if(isValid(ret,i,positive))  {
                ret = ret * 10 + i
            }else if (positive) {
                ret = Int.MAX_VALUE
                break
            } else {
                ret = Int.MIN_VALUE
                break
            }
        }
        return ret
    }

    private fun isValid(ret: Int, addon: Int,positive: Boolean):Boolean {
        return if (positive) {
            ret  <= Int.MAX_VALUE/10 && addon <= (Int.MAX_VALUE - ret * 10)
        } else {
            ret  >= Int.MIN_VALUE/10 && addon >= (Int.MIN_VALUE - ret * 10)
        }
    }
}

fun main(args: Array<String>) {
 val so8 = Solution8()
    println(so8.myAtoi("2147483646"))
//    -538412641*10
}
