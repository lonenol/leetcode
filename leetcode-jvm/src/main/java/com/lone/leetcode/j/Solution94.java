package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *  中序遍历，递归和循环两种方式，经典解法，没啥可说的
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traversal(root, ret);
        return ret;
    }

    private void traversal(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        traversal(root.left, ret);
        ret.add(root.val);
        traversal(root.right, ret);
    }
}
