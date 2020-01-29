package com.lone.leetcode.j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * 思路:
 * 1. 写一个比较器,给数组排序,然后取第 k 个
 * 2. 参考字典树
 */
public class Solution440 {

    public int findKthNumber(int n, int k) {
        int p = 1, prefix = 1;
        while (p < k) {
            int count = count(prefix, n);
            if (p + count < k) {
                prefix *= 10;
                p++;
            } else {
                prefix++;
                p = p+count;
            }
        }
        return prefix;

    }

    private int count(int prefix, int n) {
        long cur = prefix, next = cur + 1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(next, n + 1) - cur;
            cur = cur * 10;
            next = next * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution440 solution440 = new Solution440();
        solution440.findKthNumber(1, 1);
    }
}
