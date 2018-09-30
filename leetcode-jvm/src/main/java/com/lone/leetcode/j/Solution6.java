package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author lone
 * @date 2018/9/27
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int cols = (numRows-1)*(s.length() / (2 * numRows - 2) + 1);
        char[][] chars = new char[numRows][cols];
        int curCols = 0;
        int i = 0,j = 0;
        while (i < s.length()) {

            while (j < numRows && i < s.length()) {
                chars[j++][curCols] = s.charAt(i++);
            }
            j = j -2;
            while (j > 0 && i < s.length()) {
                chars[j--][++curCols] = s.charAt(i++);
            }
            curCols++;

        }
        char[] result = new char[s.length()];
        int idx = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < chars[row].length; col++) {
                if (chars[row][col] != '\u0000') {
                    result[idx++] = chars[row][col];
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();

        System.out.println(solution6.convert("PAYPALISHIRING", 3));
        System.out.println(solution6.convert("PAYPALISHIRING", 4));
    }

    private void printArr(char[][] chars) {
        for (int row = 0; row < chars.length; row++) {
            for (int cols = 0; cols < chars[row].length; cols++) {
                System.out.print(chars[row][cols]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
