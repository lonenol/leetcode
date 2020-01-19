package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * 思路:
 * 1. 暴力乘 n 次 需要注意 n 为负数时,要取倒数
 * 2. 两倍两倍的乘,否则太慢
 * ps: 注意转换丢失的问题 Integer.MIN_VALUE 的相反数会溢出,因此需要用 long
 */

public class Solution50 {
    public double myPow(double x, int n) {
        long y = n;
        if (n < 0) {
            x = 1 / x;
            y = -y;
        }
        double res = 1;
        double temp = x;
        for (long i = y; i >0; i = i / 2) {
            if (i % 2 == 1) {
                res = res * temp;
            }
            temp = temp * temp;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}

