package com.lone.leetcode.k

/**
 *
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 * @author lone
 * @date  2018/9/27
 */
class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows <= 1) {
            return s
        }
        val cols = (numRows - 1) * (s.length / (2 * numRows - 2) + 1)
        val chars = Array(numRows){CharArray(cols)}
        var curCols = 0
        var i = 0
        var j = 0
        while (i < s.length) {
            while (j < numRows && i < s.length) {
                chars[j++][curCols] = s[i++]
            }
            j -= 2
            while (j > 0 && i < s.length) {
                chars[j--][++curCols] = s[i++]
            }
            curCols++
        }
        val result = CharArray(s.length)
        var idx = 0
        for (row in 0 until numRows) {
            for (col in 0 until chars[row].size) {
                if (chars[row][col] != '\u0000') {
                    result[idx++] = chars[row][col]
                }
            }
        }
        return String(result)
    }
}

fun main(args: Array<String>) {
    val so = Solution6()
    println(so.convert("PAYPALISHIRING",3))

}