package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 思路:第一感觉就是求深度的逆向,但是要处理单边为空的情况,直接递归最小深度是 1,但其实不是叶子节点
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
}
