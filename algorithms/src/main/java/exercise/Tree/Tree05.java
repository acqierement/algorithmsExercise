import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层级遍历（从上到下）
 */
public class Tree05 {
    // 借助队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            res.add(subList);
        }
        return res;
    }

    public List<List<Integer>> levelOrderByRecursive(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;
        if(level >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(node.val);
        levelHelper(res, node.left, level + 1);
        levelHelper(res, node.right, level + 1);
    }
}
