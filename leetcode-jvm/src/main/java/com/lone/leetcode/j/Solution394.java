package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * 思路:就是循环处理,看题目描述不用考虑各种边界条件
 * ps:好吧,需要处理嵌套..比如: 3[a2[c]] ,需要输出: accaccacc
 */
public class Solution394 {
    public String decodeString(String s) {
        return repeatDecode(s, 1, 0, s.length());
    }

    private String repeatDecode(String s, int times, int start, int end) {
        StringBuilder sb = new StringBuilder();
        String sub = doDecode(s, start, end);
        while (times > 0) {
            sb.append(sub);
            times--;
        }
        return sb.toString();
    }

    private String doDecode(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start < end) {
            char c = s.charAt(start);
            if (c >= '1' && c <= '9') {
                int times = c - '0';
                while (s.charAt(++start) != '[') {
                    times = 10*times + (s.charAt(start) - '0');
                }
                int nextStart = ++start;
                int nextEnd = endOfSquare(s, start);
                sb.append(repeatDecode(s, times, nextStart, nextEnd));
                start = nextEnd + 1;
            } else {
                sb.append(c);
                start++;
            }
        }
        return sb.toString();
    }

    private int endOfSquare(String s, int start) {
        int i = 1, res = -1;
        while (i > 0 && start < s.length()) {
            if (s.charAt(start) == '[') {
                i++;
            } else if (s.charAt(start) == ']') {
                i--;
                res = start;
            }
            start++;
        }
        return res;
    }
}
