package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 思路： 其实就是广度优先搜索，但是需要知道层的信息
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<List<TreeNode>> nodes = new ArrayList<>();
        List<TreeNode> first = new ArrayList<>();
        first.add(root);
        nodes.add(first);
        while (!nodes.isEmpty()) {
            List<TreeNode> nextNode = new ArrayList<>();
            List<Integer> nextRet = new ArrayList<>();
            for (TreeNode node : nodes.remove(0)) {
                nextRet.add(node.val);
                if (node.left != null) {
                    nextNode.add(node.left);
                }
                if (node.right != null) {
                    nextNode.add(node.right);
                }
            }
            if (!nextNode.isEmpty()) {
                nodes.add(nextNode);
            }
            ret.add(nextRet);
        }
        return ret;
    }
}
