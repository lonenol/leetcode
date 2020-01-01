package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 * 思路： 由于二叉搜索树的性质，每个节点等于它自己和它右侧所有节点的和，考虑到避免重复计算导致时间复杂度过高的问题，因该从最右面开始计算。
 *  也就是后续遍历，每个节点就等于自己和它的上个节点的和（右面所有的值都已经加到上个节点）
 */
public class Solution1038 {

    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        root.val += sum;
        sum  = root.val;
        bstToGst(root.left);
        return root;
    }


}
