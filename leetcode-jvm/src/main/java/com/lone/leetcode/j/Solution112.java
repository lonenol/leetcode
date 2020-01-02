package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * 思路:就是遍历,老生常谈,核心是判断到叶子节点
 */
public class Solution112 {
    boolean result = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

}
