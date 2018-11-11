package com.alex.algorithm.Session16_Disjoin;

import java.util.Scanner;

public class BaiVirtualFriend {

    private static final int MAX = 20;
    private static final int JOIN_ACTION = 1;
    private static final int FIND_ACTION = 2;

    private static final int FOUND_RESULT = 1;
    private static final int NOT_FOUND_RESULT = 1;

    private static int[] parent = new int[MAX + 5];
    private static int[] ranks = new int[MAX + 5];
    private static int[] friendCount = new int[MAX + 5];

    public static void makeSet() {
        for (int i = 1; i <= MAX; i++) {
            parent[i] = i;
            ranks[i] = 0;
            friendCount[i] = 0;
        }
    }

    public static int findSet(int element) {
        if (parent[element] != element) {
            parent[element] = findSet(parent[element]); //loop until find the parent
        }
        return parent[element];
    }

    public static void unionSet(int element1, int element2) {
        int parentOfElem1 = findSet(element1);
        int parentOfElem2 = findSet(element2);

        if (parentOfElem1 == parentOfElem2) {
            return;
        }

        if (ranks[parentOfElem1] > ranks[parentOfElem2]) {
            parent[parentOfElem2] = parentOfElem1;
            friendCount[parentOfElem1] += friendCount[parentOfElem2];
        } else if (ranks[parentOfElem1] < ranks[parentOfElem2]) {
            parent[parentOfElem1] = parentOfElem2;
        } else {
            parent[parentOfElem1] = parentOfElem2;
            ranks[parentOfElem2]++; //increase level of parent of element2
            friendCount[parentOfElem2] += friendCount[parentOfElem1];
        }
    }

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int numOfTestcases = scanner.nextInt();
        for(int i = 0 ;i<numOfTestcases;i++) {
            executeTestCase();
        }

    }

    private static void executeTestCase() {

    }
}
