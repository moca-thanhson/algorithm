package com.alex.algorithm.Session14_Trie;

public class TrieTest {

    public static void main(final String[] args) {
        final Trie trie = new Trie();
        trie.addWord("the");
        trie.addWord("then");
        trie.addWord("bigo");


        System.out.println("Find words:");
        System.out.println(String.format("Find word %s : %s", "there", trie.findWord("there")));
        System.out.println(String.format("Find word %s : %s", "the", trie.findWord("the")));
        System.out.println(String.format("Find word %s : %s", "then",trie.findWord("then")));


        System.out.println("Remove words:");
        System.out.println(String.format("Remove %s : %s", "bigo", trie.removeWord("bigo")));
        System.out.println(String.format("Remove %s : %s", "the", trie.removeWord("the")));
        System.out.println(String.format("Remove %s : %s", "then", trie.removeWord("then")));

    }

}
