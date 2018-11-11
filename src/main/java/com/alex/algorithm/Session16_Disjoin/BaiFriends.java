package com.alex.algorithm.Session16_Disjoin;

import com.alex.algorithm.NumberUtil;

import java.util.List;
import java.util.Scanner;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1549
 */
public class BaiFriends {

    private static final int MAX = 20;
    private static final int JOIN_ACTION = 1;
    private static final int FIND_ACTION = 2;

    private static final int FOUND_RESULT = 1;
    private static final int NOT_FOUND_RESULT = 1;

    private static int[] parent = new int[MAX + 5];
    private static int[] ranks = new int[MAX + 5];
    private static int[] friendCount = new int[MAX + 5];

    private static Scanner scanner = new Scanner(System.in);

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
            friendCount[parentOfElem1] += friendCount[parentOfElem2]; //increase children nodes
        } else if (ranks[parentOfElem1] < ranks[parentOfElem2]) {
            parent[parentOfElem1] = parentOfElem2;
        } else {
            parent[parentOfElem1] = parentOfElem2;
            ranks[parentOfElem2]++; //increase level of parent of element2
            friendCount[parentOfElem2] += friendCount[parentOfElem1]; //increase children nodes
        }
    }

    public static void main(String[] args) {
        final int numOfTestCase = scanner.nextInt();
        for (int i = 0; i < numOfTestCase; i++) {
            executeTestCase();
        }
    }

    private static void executeTestCase() {
        final int numOfFriends = scanner.nextInt();
        final int numOfRelations = scanner.nextInt();
        for (int i = 0; i < numOfRelations; i++) {
            final List<Integer> eachRelation = NumberUtil.convertByString(scanner.nextLine());

            //clean and refresh data
            DisjoinUtil.makeSet();

            //join relation
            DisjoinUtil.unionSet(eachRelation.get(0), eachRelation.get(1));

            //check the result
            int maxOfFriends = 0;
            for (int friendIndex = 1; i <= numOfFriends; i++) {
                //find max count nodes by friend
                if (friendCount[friendIndex] > maxOfFriends) {
                    maxOfFriends = friendCount[friendIndex];
                }
            }
            System.out.println(maxOfFriends);


        }
    }
}
