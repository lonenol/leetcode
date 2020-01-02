package com.lone.leetcode.j;

/**
 * 优化点： 某一个节点不平衡即可认为不平衡，不需要全部比较
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left,right) + 1;
    }


    public boolean isBalanced_1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced_1(root.left) && isBalanced_1(root.right);

    }

    private int maxHeight(TreeNode node){
        if (node == null) {
            return 0;
        }
        return Math.max(maxHeight(node.left), maxHeight(node.right));

    }
}
