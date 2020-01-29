package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 思路:回溯
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        int[] tmp = new int[4];
        backtrace(res, s, 0, tmp, 0);
        return res;
    }

    private void backtrace(List<String> res, String s,  int ss, int[] tmp, int ts) {
        for (int i = 1; i <= 3; i++) {
            int end = ss + i;
            if (end > s.length()) {
                continue;
            }
            String cur = s.substring(ss, end);
            if (cur.length() > 1 && cur.startsWith("0")) {
                break;
            }
            int num = Integer.parseInt(cur);
            if (num > 255) {
                continue;
            }
            tmp[ts] = num;
            if (end == s.length() && ts == 3) {
                res.add(toIp(tmp));
            } else if(ts < 3){
                backtrace(res, s, end, tmp, ts + 1);
            }
            tmp[ts] = 0;
        }
    }

    private String toIp(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
