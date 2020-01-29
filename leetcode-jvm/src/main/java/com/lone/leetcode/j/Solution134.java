package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/gas-station/
 * 思路:
 * 1. 唯一的思路就是每个都走一遍..
 * 2. 得自题解
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0, total = 0, curr = 0;
        for (int i = 0; i < gas.length; i++) {
            total = total + gas[i] - cost[i];
            curr = curr + gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                res = i + 1;
            }
        }
        return total < 0 ? -1 : res;
    }
    public int canCompleteCircuit_brute(int[] gas, int[] cost) {
        int res = -1;
        for (int i = 0; i < gas.length; i++) {
            int step = gas.length;
            int leftGas = 0;
            int next = i;
            do {
                leftGas += gas[next];
                leftGas = leftGas - cost[next];
                if (leftGas < 0) {
                    break;
                } else {
                    next = (next + 1) % step;
                }
                if (next == i) {
                    res = i;
                }
            } while (next != i);
        }
        return res;
    }
}
