import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreeTest {
    @Test
    public void TestBinarySearchTree() {
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
}
