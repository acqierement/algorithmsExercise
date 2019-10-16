package src.main.java.exercise.Tree;

import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreeTest {
    @Test
    public void TestBinarySearchTree() {
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(6);
        BinarySearchTree.Node root = bst.root();

        assertEquals(root.value,5);
        assertEquals(root.left.value, 3);
        assertEquals(root.left.left.value, 1);
        assertEquals(root.right.value, 6);
        assertNull(root.left.right);
        assertEquals(bst.findMax().value, 6);
        assertEquals(bst.findMin().value, 1);

        bst.delete(1);
        assertEquals(bst.findMin().value, 3);
        assertEquals(bst.findMax().value, 6);

        bst.delete(6);
        assertEquals(bst.findMin().value, 3);
        assertEquals(bst.findMax().value, 5);

        bst.delete(5);
        assertEquals(bst.findMin().value, 3);
        assertEquals(bst.findMax().value, 3);

        bst.delete(3);
        assertNull(bst.findMin());
        assertNull(bst.findMax());
    }
@Test
    public void test() {
        TreeNode root1 = new TreeNode(8);
        TreeNode right = new TreeNode(8);
        TreeNode left = new TreeNode(7);
        root1.right = right;
        root1.left = left;
        TreeNode rr = new TreeNode(9);
        TreeNode rl = new TreeNode(2);
        right.right = rr;
        right.left = rl;
    System.out.println(isSubtree(root1, root1.right));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if(s.val == t.val && isSubtree(s.left, t.left) &&  isSubtree(s.right, t.right)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
