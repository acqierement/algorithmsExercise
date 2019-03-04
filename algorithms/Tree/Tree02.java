import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历，递归和使用栈迭代
 */
public class Tree02 {

    // 使用递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    // 使用迭代实现，借助栈
    public List<Integer> preorderTraversalByIteration(TreeNode root) {
        TreeNode cur = root;
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null) {
            res.add(cur.val);
            if(cur.right != null) {
                stack.push(cur.right);
            }

            cur = cur.left;
            if(cur == null && !stack.isEmpty()) {
                cur = stack.pop();
            }
        }
        return res;
    }
}
