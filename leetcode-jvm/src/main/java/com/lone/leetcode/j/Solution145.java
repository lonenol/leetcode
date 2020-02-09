package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 思路:
 * 递归: 太简单
 * 迭代: 试试,用栈
 */
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.peek();
                if(tmp.right != null && tmp.right != last) {
                    cur = last.right;
                } else {
                    res.add(tmp.val);
                    last = tmp;
                    stack.pop();
                }
            }
        }
        return res;
    }


    public List<Integer> postorderTraversal_(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(res, root);
        return res;
    }
    public List<Integer> postorderTraversal_recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(res, root);
        return res;
    }

    private void postOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(res, root.left);
        postOrder(res, root.right);
        res.add(root.val);
    }
}
