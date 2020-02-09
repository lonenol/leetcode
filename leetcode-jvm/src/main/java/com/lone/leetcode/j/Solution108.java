package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 思路:取中间一点作为根,然后左边是左子树,右边是右子树
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return genTree(nums, 0, nums.length - 1);
    }

    private TreeNode genTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = genTree(nums, start, mid - 1);
        root.right = genTree(nums, mid + 1, end);
        return root;
    }
}
