package com.alex.algorithm.Session14_Trie.onClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaiSearchEngine {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numOfText = scanner.nextInt();
        int numOfQuery = scanner.nextInt();
        final List<Word> lstWords = new ArrayList<>();

        //read list of words
        for (int i = 0; i < numOfText; i++) {
            final String word = scanner.next();
            int weight = scanner.nextInt();
            lstWords.add(new Word(word, weight));
        }

        //sorting
        Collections.sort(lstWords);

        //Put list words into trie
        final Trie trie = new Trie();
        for (final Word word : lstWords) {
            trie.addText(word.word, word.weight);
        }

        //execute query
        for (int i = 0; i < numOfQuery; i++) {
            final String textQuery = scanner.next();
            final int weightSortedByDesc = trie.getWeight(textQuery);
            System.out.println(weightSortedByDesc);
        }
    }

    static class Trie {
        private static final int NOT_FOUND_RESULT = 0;
        private static final int FOUND_RESULT = 1;

        Node root;

        public Trie() {
            root = new Node();
        }

        public void addText(String str, int newWeight) {
            Node currNode = root;
            for (int i = 0; i < str.length(); i++) {
                int currChar = str.charAt(i) - 'a'; //convert to int to easy handle
                if (currNode.children[currChar] == null) { //if found new character
                    currNode.children[currChar] = new Node();
                    currNode.children[currChar].weight = newWeight;
                }
                currNode = currNode.children[currChar]; //continue loop
            } //end loop
        }


        public int getWeight(String str) {
            Node currNode = root;
            int result = FOUND_RESULT;

            for (int i = 0; i < str.length(); i++) {
                int currChar = str.charAt(i) - 'a'; //convert to int to easy handle
                if (currNode.children[currChar] == null) {
                    return NOT_FOUND_RESULT;
                }
                currNode = currNode.children[currChar];
                result = currNode.weight;
            }

            return result;
        }
    }


    static class Word implements Comparable<Word> {
        public String word;
        public Integer weight;

        public Word(final String word, final int weight) {
            this.word = word;
            this.weight = weight;
        }

        @Override
        public int compareTo(Word obj) {
            return obj.weight.compareTo(this.weight); //sort descending
        }
    }

    static class Node {
        static final int MAX = 26;

        public Node[] children;
        public int weight;

        public Node() {
            children = new Node[MAX];
        }
    }
}
