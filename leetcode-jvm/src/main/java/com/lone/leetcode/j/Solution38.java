package com.lone.leetcode.j;

/**
 * https://leetcode.com/problems/count-and-say/
 *
 * @author ljl133110
 * @date 2019-07-20
 */
public class Solution38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String ret = "1";
        for (int i = 2; i <= n; i++) {
            ret = say(ret);
        }
        return ret;
    }

    private String say(String str) {
        char tmp = str.charAt(0);
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (tmp == c) {
                cur++;
            } else {
                sb.append(cur).append(tmp);
                tmp = c;
                cur = 1;
            }
            if (i == str.length() - 1) {
                sb.append(cur).append(tmp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.say("21"));
        for (int i = 3; i <= 10; i++) {
            System.out.println(solution38.countAndSay(i));
        }
    }
}
