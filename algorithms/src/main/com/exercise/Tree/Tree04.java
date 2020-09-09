package com.exercise.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class Tree04 {
    // 递归实现
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    // 迭代实现

    public List<Integer> postorderTraversalByIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        Queue<Integer> queue = new LinkedList<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                res.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur = cur.left;

        }
        return res;
    }
}
