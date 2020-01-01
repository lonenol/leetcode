package com.lone.leetcode.j;

import javafx.util.Pair;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 树不是有序的，因此会比较麻烦，需要遍历
 * 解法1： 暴力搜索
 *  利用两个list，一个记录下p的路径，一个记录q的路径，然后比较 p 和 q的路径，找到最后一个不分歧的节点
 *
 *  解法2： 递归
 *  也是O(n)的
 *
 *  解法3： dfs
 *  本质上是一个深度优先遍历，先寻找到任意一个，然后以此为基础，寻找另一个节点
 */
public class Solution236 {


    private static final int BOTH_DONE = 0;
    private static final int ONE_DONE = 1;
    private static final int NO_DONE = 2;


    /*循环*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair<>(root, NO_DONE));
        boolean oneNodeFound = false;
        TreeNode result = null;
        TreeNode child = null;
        while (!stack.isEmpty()) {
            Pair<TreeNode,Integer> top = stack.peek();
            TreeNode node = top.getKey();
            if (top.getValue() != BOTH_DONE) {
                if (top.getValue() == NO_DONE) {
                    if (node == p || node == q) {
                        if (oneNodeFound) {
                            return result;
                        } else {
                            oneNodeFound = true;
                            result = node;
                        }
                    }
                    child = node.left;
                } else {
                    child = node.right;
                }
                stack.pop();
                stack.push(new Pair<>(node, top.getValue() - 1));
                if (child != null) {
                    stack.push(new Pair<>(child, NO_DONE));
                }
            } else {
                if (stack.pop().getKey() == result && oneNodeFound) {
                    result = stack.peek().getKey();
                }
            }

        }
        return null;
    }


    /**
     * recursive
     */
    public TreeNode _lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*由于p q 一定会在树里*/
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

}
