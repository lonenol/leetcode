package com.lone.leetcode.j;

/**
 *  https://leetcode.com/problems/invert-binary-tree/
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}


