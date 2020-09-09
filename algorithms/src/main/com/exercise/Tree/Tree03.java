package com.exercise.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Tree03 {

    // 递归实现中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            helper(res, root.left);
        }

        res.add(root.val);
        if (root.right != null) {
            helper(res, root.right);
        }
    }

    // 迭代实现中序遍历(借助栈实现)
    public List<Integer> inorderTraversalByIteration(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
