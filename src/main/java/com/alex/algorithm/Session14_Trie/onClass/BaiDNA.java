package com.alex.algorithm.Session14_Trie.onClass;

import java.util.Scanner;

public class BaiDNA {

    static int answer = 0;
    static int[] arrOfLexicalValue = new int[26];

    static void add(Node root, String str) {
        Node currNode = root;
        for (int i = 0; i < str.length(); i++) {
            final int valueOfCurrLexical = str.charAt(i) - 'A';
            int nextLexicalValue = arrOfLexicalValue[valueOfCurrLexical];
            if (currNode.children[nextLexicalValue] == null) {
                currNode.children[nextLexicalValue] = new Node(); //create new node
            }

            currNode = currNode.children[nextLexicalValue]; // continue to loop
            currNode.numberOfChild++;

            answer = Math.max(currNode.numberOfChild * (i + 1), answer);
        }
    }

    static void delete(Node delNode) {
        for (int i = 0; i < 4; i++) {
            if (delNode.children[i] != null) {
                delete(delNode.children[i]);
            }
        }

        delNode = null;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //init value of DNA lexical
        arrOfLexicalValue['A' - 'A'] = 0;
        arrOfLexicalValue['C' - 'A'] = 1;
        arrOfLexicalValue['G' - 'A'] = 2;
        arrOfLexicalValue['T' - 'A'] = 3;

        int numOfTestCase = scanner.nextInt();
        for (int testCase = 1; testCase <= numOfTestCase; testCase++) {
            answer = 0;
            Node root = new Node();
            int numOfDNAString = scanner.nextInt();
            for (int i = 0; i < numOfDNAString; i++) {
                final String dnaString = scanner.next();
                add(root, dnaString);
            }

            System.out.println("Case " + testCase + ": " + answer);
            //refresh test data
            delete(root);
            root = null;
        }

        System.exit(0);
    }

    static class Node {
        Node[] children = new Node[4]; //because one node has maximum A,C,G,T lexicals
        int numberOfChild;
    }


}
