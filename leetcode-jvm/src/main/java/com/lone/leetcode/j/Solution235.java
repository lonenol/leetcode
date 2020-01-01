package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 思路： 二叉搜索树有序，左子树都小于根节点，右子树都大于根节点，
 * 因此递归比较当前节点和p q的值就指导p q是否还有更低级别的祖先
 * ps：如果分叉就没有了
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
