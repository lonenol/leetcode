package com.lone.leetcode.j;

/**
 * @author lone
 * @date 2018/9/30
 */
public class Solution7 {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int mod = x % 10;
            x /= 10;
            //正数溢出 mod > Integer.MAX_VALUE - Integer.MAX_VALUE / 10
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && mod > 7)) {
                return 0;
            }
            //负数溢出 mod < Integer.MIN_VALUE - Integer.MIN_VALUE / 10
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && mod < -8)) {
                return 0;
            }
            ret = ret * 10 + mod;
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE / 10);
    }
}
