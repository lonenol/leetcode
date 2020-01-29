package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * 思路:
 * 1. 回溯
 * 2  动态规划dp[i] + dp[i-1] +[dp[i-2](i-1 i 能解码的情况下)]
 * 3. 由于动态方程只涉及到 前两个,所以可以压缩空间,不用 dp[n],而是用两个变量
 */
public class Solution91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = canDecode(s, 0, 0) ? 1 : 0;
        if (s.length() == 1) {
            return dp[1];
        }

        for (int i = 2; i <= s.length(); i++) {
            boolean cur = canDecode(s, i - 1, i - 1);
            boolean pre = canDecode(s, i - 2, i - 1);
            if (!cur && !pre) {
                return 0;
            } else if(cur && !pre) {
                dp[i] = dp[i - 1];
            } else if (!cur && pre) {
                dp[i] = dp[i - 2];
            } else if(cur && pre) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[s.length()];

    }

    private boolean canDecode(String s, int start, int end) {
        if (end - start > 1) {
            return false;
        }

        if (end == start) {
            return s.charAt(start) != '0';
        }
        if (end - start == 1) {
            return s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(end) <= '6');
        }
        return false;
    }
}
