package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 实现字典树，虽然不难但是这种数据结构需要记住
 */
public class Trie {

    private static int SIZE = 26;

    static class TrieNode {

        char val;
        int matchWord = 0;
        TrieNode[] nextNode;

        public TrieNode(char val) {
            this.val = val;
            nextNode = new TrieNode[SIZE];
        }
    }

    TrieNode head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new TrieNode('0');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode trieNode = head;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (trieNode.nextNode[tmp - 'a'] == null) {
                trieNode.nextNode[tmp - 'a'] = new TrieNode(tmp);
            }
            trieNode = trieNode.nextNode[tmp - 'a'];
        }
        trieNode.matchWord++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trieNode.nextNode[c - 'a'] != null) {
                trieNode = trieNode.nextNode[c - 'a'];
            } else {
                return false;
            }
        }
        return trieNode.matchWord > 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = head;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (trieNode.nextNode[c - 'a'] != null) {
                trieNode = trieNode.nextNode[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }


}

