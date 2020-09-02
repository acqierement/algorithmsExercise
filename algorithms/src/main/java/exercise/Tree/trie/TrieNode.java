package src.main.java.exercise.Tree.trie;

/**
 * @Author:
 * @date: 2019/10/16 11:14
 * @Version: 1.0
 */
public class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode() {}
    public TrieNode(char val) {
        this.val = val;
    }

}

