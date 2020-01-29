package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 思路:广度优先遍历,取每层最后一个元素(从左向右遍历)
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if (i == len - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
