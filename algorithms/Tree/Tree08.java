/**
 * 找到二叉树的下一个节点
 */
public class Tree08 {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        TreeLinkNode cur = pNode;
        // 如果有右子树，下一个节点就在右子树中
        if (pNode.right != null) {
            cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 当前节点没有右子树，如果当前节点是父节点的左子树，则当前节点的下一个节点就是父节点
        // 如果当前节点处于父节点的右子树，则当前节点的下一个节点就需要继续往上找。找到一个节点，当前节点所处的子树是这个节点的左子树
        TreeLinkNode p = pNode.next;
        TreeLinkNode s = pNode;
        while (p != null && p.right == s) {
            s = p;
            p = p.next;
        }
        return p;

    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
