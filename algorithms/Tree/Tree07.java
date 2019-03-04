import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的z形遍历
 */
public class Tree07 {
    // 借助队列
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        boolean isLeftToRight = true;
        if(root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(isLeftToRight) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            isLeftToRight = !isLeftToRight;
            res.add(subList);
        }
        return res;
    }

    // 使用递归
    public List<List<Integer>> zigzagLevelOrderByRecursive(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> subList = new LinkedList<>();
            sol.add(subList);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
