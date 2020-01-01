package com.lone.leetcode.j;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 二叉搜索树中序遍历是顺序的，因此可以先中序遍历，查看遍历出来的是否有序，为了节省空间，理论上只保留上一个值就行了
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (node.val <= min) {
                return false;
            }
            min = node.val;
            root = node.right;
        }
        return true;
    }
}
