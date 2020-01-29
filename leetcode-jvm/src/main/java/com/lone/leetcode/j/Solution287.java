package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 思路:
 * 1. 用数组下标计数
 * 2. 双指针法,看成一个链表, 和 142题就变成了一个问题
 * 肯定有环在于肯定有两个相同的值  nums[i] 的值 等于链表中的 node.next ,有两个相同的值就代表数组中有两个 next 指向同一个节点,因此构成了环
 */
public class Solution287 {

    public int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int pt1 = tortoise;
        int pt2 = nums[0];
        while (pt1 != pt2) {
            pt1 = nums[pt1];
            pt2 = nums[pt2];
        }
        return pt1;
    }

    public int findDuplicate_space(int[] nums) {
        int[] count = new int[nums.length];
        for (int i : nums) {
            if (count[i] == 1) {
                return i;
            } else {
                count[i] = 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        int[] nums = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        solution287.findDuplicate(nums);
    }
}
