package com.lone.leetcode.j;


/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 思路: 和前中后序遍历的代码都很像,需要注意的点是算左右子树时要记住最后只会走其中一条路
 */
public class Solution124 {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;

    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,maxSum(root.left));
        int right = Math.max(0,maxSum(root.right));
        int sum = root.val + left + right;
        max = Math.max(sum, max);
        return root.val + Math.max(left, right);
    }

}
