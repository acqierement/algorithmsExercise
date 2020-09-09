package com.exercise.Tree;

public class BinarySearchTree {
    private Node tree;

    public Node root() {
        return tree;
    }

    public Node find(int value) {
        Node p = tree;
        while (p != null) {
            if (p.value > value) {
                p = p.left;
            } else if (p.value < value) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int value) {
        if (tree == null) {
            tree = new Node(value);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (p.value > value) {
                if (p.left == null) {
                    p.left = new Node(value);
                    return;
                }
                p = p.left;
            } else { //value >= p.value
                if (p.right == null) {
                    p.right = new Node(value);
                    return;
                }
                p = p.right;
            }
        }
    }

    public void delete(int value) {
        Node p = tree;// p 指向要删除的节点
        Node pp = null; // pp是p的父节点
        while (p != null && p.value != value) {
            pp = p;
            if (p.value < value) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) return; // 没有找到要删除的节点

        if (p.right != null && p.left != null) {
            // 找右子树中最小的节点(就是右子树中最左边的节点）
            Node minP = p.right;
            Node minPP = p; // minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value; // 把要删除的节点的值替换成minP的值
            p = minP;
            pp = minPP; // 接下去就是删除minP了
        }

        // 没有子节点或者只有一个子节点的情况
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) { // 删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    public Node findMin() {
        Node p = tree;
        if(p == null) return null;
        while(p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        Node p = tree;
        if(p == null) return null;
        while(p.right != null) {
            p = p.right;
        }
        return p;
    }

    public static class Node {
        // 这里应该是private的，我为了方便测试，就用了public
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
