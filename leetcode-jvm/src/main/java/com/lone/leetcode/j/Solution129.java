package com.lone.leetcode.j;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 思路:本质上还是对树的遍历,但是要保存结果
 */
public class Solution129 {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node,int pre) {
        if (node == null) {
            return;
        }
        int cur = pre*10 + node.val;
        if (node.left == null && node.right == null) {
            ans += cur;
        }
        dfs(node.left, cur);
        dfs(node.right, cur);
    }

    public int sumNumbers_iterator(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair<TreeNode, Integer> cur = queue.poll();
                TreeNode node = cur.getKey();
                int next = cur.getValue() * 10 + node.val;
                if (node.left == null && node.right == null) {
                    sum += next;
                }
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, next));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, next));
                }
            }
        }
        return sum;

    }
}
