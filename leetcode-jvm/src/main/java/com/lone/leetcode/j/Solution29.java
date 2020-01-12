package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 思路：就是用减法算除法，溢出情况是Integer.MIN_VALUE /-1
 *  所以转为负数计算会更容易处理，只要在最后处理符号的时候处理一下这个边界就行
 *  ps:这里需要一些提速的技巧，否则会超出时间限制
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int sign = (dividend ^ divisor) >> 31;
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int result = 0;
        while (dividend <= divisor) {
            int tmpResult = -1;
            int tmpDivisor = divisor;
            while(dividend <= (tmpDivisor << 1)) {
                if(tmpDivisor <= (Integer.MIN_VALUE>>1)) break;
                tmpDivisor <<= 1;
                tmpResult <<= 1;
            }
            result += tmpResult;
            dividend -= tmpDivisor;
        }
        if(sign == -1) {
            return result;
        } else if(result == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        solution29.divide(7, -3);
    }
}
