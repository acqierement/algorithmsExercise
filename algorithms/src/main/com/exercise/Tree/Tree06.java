package com.exercise.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层级遍历（从下到上）
 */
public class Tree06 {
    // 借助队列
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(0, subList);
        }
        return res;
    }

    // 记录层数，递归实现
    public List<List<Integer>> levelOrderBottomByRecursive(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;
        if(level >= res.size()) {
            res.add(0, new LinkedList<Integer>());
        }
        res.get(res.size() - level - 1).add(node.val);
        levelHelper(res, node.left, level + 1);
        levelHelper(res, node.right, level + 1);
    }


}
