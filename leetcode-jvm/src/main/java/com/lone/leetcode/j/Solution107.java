package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 思路：
 * 1. 先自顶向下，然后逆序列表
 * 2. 直接自底向上
 * 2.1 带深度的递归
 *
 */
public class Solution107 {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ret.add(0,new ArrayList<>());
            while (size-- > 0) {
                TreeNode node = queue.poll();
                ret.get(0).add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> levelOrderBottom_recursive(TreeNode root) {
        dfs(root,0);
        return ret;

    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (ret.size() == level) {
            ret.add(0, new ArrayList<>());
        }
        ret.get(ret.size() - level - 1).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

}
