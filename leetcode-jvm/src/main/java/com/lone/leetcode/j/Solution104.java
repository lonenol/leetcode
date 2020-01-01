package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 求深度，常规写法
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
