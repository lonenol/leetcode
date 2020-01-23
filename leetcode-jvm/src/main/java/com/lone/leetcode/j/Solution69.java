package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Solution69 {
    public int mySqrt(int x) {
        long left = 0, right = x/2+1;
        while (left < right) {
            long mid1 = left + (right - left) / 2;
            long mid2 = (left + right + 1) >>> 1;
            System.out.println("left: "+left+",right"+right+",mid1:" + mid1 + ",mid2:" + mid2);
            long mid = mid2;
            long sqrt = mid * mid;
            if (sqrt == x) {
                return (int)mid;
            } else if (sqrt > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        solution69.mySqrt(8);
    }
}
