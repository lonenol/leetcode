package com.lone.leetcode.j;

/**
 * @author 诗翁
 * @date 2022/3/22
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int level = level(root);
        int low = 1 << (level - 1);
        int hi = 1 << (level) - 1;
        while(low < hi) {
            int mid = (low + hi + 1) / 2;
            if(exists(root,level,mid)) {
                low = mid;
            } else {
                hi = mid - 1;
            }
        }
        return low;
    }


    private int level(TreeNode root) {
        TreeNode node = root;
        int level = 0;
        while(node != null) {
            level++;
            node = node.left;
        }
        return level;
    }

    private boolean exists(TreeNode root, int level, int val) {
        int flag = 1 << (level - 2) ;
        TreeNode node = root;
        for(int i = 1; i < level - 1; i++) {
            if((flag & val) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            flag >>= 1;
        }
        return node != null;
    }
}
