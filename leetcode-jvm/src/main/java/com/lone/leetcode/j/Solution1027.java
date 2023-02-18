package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution1027 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        boolean fromLeftToRight = false;
        nextLevel.add(root);
        while (!nextLevel.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            for (TreeNode node : nextLevel) {
                subResult.add(node.val);
            }
            result.add(subResult);
            List<TreeNode> subs = new ArrayList<>();
            for (int j = nextLevel.size() - 1; j >= 0; j--) {
                TreeNode cur = nextLevel.get(j);
                if (fromLeftToRight) {
                    if (cur.left != null) {
                        subs.add(cur.left);
                    }
                    if (cur.right != null) {
                        subs.add(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        subs.add(cur.right);
                    }
                    if (cur.left != null) {
                        subs.add(cur.left);
                    }
                }
            }
            nextLevel = subs;
            fromLeftToRight = !fromLeftToRight;

        }
        return result;
    }
}
