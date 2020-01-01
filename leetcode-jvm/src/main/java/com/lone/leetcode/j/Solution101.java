package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 思路：左中右和右中左得到的结果一样
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
