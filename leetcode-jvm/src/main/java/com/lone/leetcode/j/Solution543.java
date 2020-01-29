package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 思路:左边最大深度加上右边最大深度
 */
public class Solution543 {
    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        height(root);
        return ans;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        ans = Math.max(ans, left + right);
        return Math.max(left,right) +1;
    }
}
