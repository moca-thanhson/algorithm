package com.alex.algorithm.Session14_Trie;

public class Trie {

    public static final int MAX = 26;

    private static final int IS_ENDNODE_OF_WORD = 1;
    private static final int IS_LEXICAL = 0;

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void addWord(String str) {
        int currentLexical;
        Node temp = root;
        for (int i = 0; i < str.length(); i++) {
            currentLexical = str.charAt(i) - 'a'; //store number for easy
            if (temp.child[currentLexical] == null) {
                Node newNode = new Node();
                temp.child[currentLexical] = newNode; //point current lexical to new created node
            }
            temp = temp.child[currentLexical]; //continue for loop
        }

        temp.wordMarker = IS_ENDNODE_OF_WORD;

    }

    public boolean findWord(String str) {
        int currentLexica;
        Node temp = root;
        for (int i = 0; i < str.length(); i++) {
            currentLexica = str.charAt(i) - 'a'; //store number for easy
            if (temp.child[currentLexica] == null) {
                return false;
            }
            temp = temp.child[currentLexica]; //continue to loop
        }

        //check last lexical
        return temp.wordMarker == IS_ENDNODE_OF_WORD ? true : false;
    }

    public boolean removeWord(String string) {
        return removeWord(root, string, 0, string.length());
    }

    private boolean isWord(Node pNode) {
        return (pNode.wordMarker == IS_ENDNODE_OF_WORD);
    }

    private boolean isEmpty(Node pNode) {
        for (int i = 0; i < MAX; i++) {
            if (pNode.child[i] == null) {
                return false;
            }
        }
        return true;
    }

    private boolean removeWord(Node root, String string, int level, int length) {
        if (root == null) {
            return false;
        }

        if (level == length && root.wordMarker == IS_ENDNODE_OF_WORD) {
            root.wordMarker = IS_LEXICAL;
            return true;
        }

        if (level == length && root.wordMarker == IS_LEXICAL) {
            return false;
        }

        int currentLexical = string.charAt(level) - 'a'; //convert to int
        boolean flag = removeWord(root.child[currentLexical], string, level + 1, length); //loop to find word to remove
        //process after execution return from recursive based on flag
        if (flag && !isWord(root.child[currentLexical]) && isEmpty(root.child[currentLexical])) {
            root.child[currentLexical] = null; //delete word and re-assign point to null
        }
        return flag;
    }


    class Node {
        static final int MAX = 26;
        public Node[] child;
        public int wordMarker;

        public Node() {
            wordMarker = 0;
            child = new Node[MAX];
        }
    }
}
