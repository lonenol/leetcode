package com.lone.leetcode.j;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 思路:
 * 1. 双重循环
 * 2. set 记录每个数的值,循环时,去 map 里找 target-numbers[i]的下标
 * 3. 有序数组,另一个用二分查找找
 * 4. 由于是有序数组,所以可以头尾双指针遍历,哪里不合格动哪里
 *
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public int[] twoSum_map(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            Integer sec = map.get(target - numbers[i]);
            if (sec != null) {
                res[0] = i + 1;
                res[1] = sec + 1;
                break;
            }
        }
        return res;
    }
}
