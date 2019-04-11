## 树相关题目

1. 实现二叉查找树，支持插入、删除、查找、查找最大值最小值操作 
    代码实现：BinarySearchTree类
    
2. 二叉树的前序遍历 LeetCode[144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)

3. 二叉树的中序遍历 LeetCode[94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

4. 二叉树的后序遍历 LeetCode[145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)

5. 二叉树的层级遍历（从上到下）LeetCode[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
    层级遍历主要有两种方法。
    - 使用队列，每层从左到右把节点加入队列。
    - 通过记录每次的层数，使用递归实现。
6. 二叉树的层级遍历（从下到上）方法同上 LeetCode[107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

7. 二叉树的z型遍历 (和层级遍历类似) LeetCode[103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

8. 实现二叉查找树中某个节点的后继、前驱节点。其实就是中序遍历的前后节点，因为二叉查找树中序遍历是有顺序的。