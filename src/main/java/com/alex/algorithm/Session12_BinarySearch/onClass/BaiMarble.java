package com.alex.algorithm.Session12_BinarySearch.onClass;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://uva.onlinejudge.org/external/104/10474.pdf
 */
public class BaiMarble {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int testCount = 0;
        List<Integer> numbersInputLine = NumberUtil.convertByString(scanner.nextLine());
        while (numbersInputLine.get(0) != 0 && numbersInputLine.get(1) != 0) {
            final int numOfMarbles = numbersInputLine.get(0);
            final int numOfQueries = numbersInputLine.get(1);

            //input data with marbles
            final int[] arrMarbles = new int[numOfMarbles];


            //fill data
            for (int i = 0; i < numOfMarbles; i++) {
                arrMarbles[i] = Integer.valueOf(scanner.nextLine());
            }
            Arrays.sort(arrMarbles); //sort

            //input data with numbers which need to be searched in arrMarbles
            final int[] arrQueries = new int[numOfQueries];
            for (int i = 0; i < numOfQueries; i++) {
                arrQueries[i] = Integer.valueOf(scanner.nextLine());
            }

            //search
            System.out.println(String.format("CASE# %s:", testCount));
            for (int i = 0; i < arrQueries.length; i++) {
                int searchNumber = arrQueries[i];
                int indexOfSearchNumber = Arrays.binarySearch(arrMarbles, searchNumber);
                if (indexOfSearchNumber >= 0 && indexOfSearchNumber < arrMarbles.length) {
                    //need to find the first position
//                    int firstIndex = findFirstIndex(searchNumber, indexOfSearchNumber, arrMarbles);
                    System.out.println(String.format("%s found at %s", searchNumber, indexOfSearchNumber + 1));
                } else {
                    System.out.println(String.format("%s not found", searchNumber));
                }
            }

            //continue test case
            numbersInputLine = NumberUtil.convertByString(scanner.nextLine());
        }

    }

    private static int findFirstIndex(int searchNumber, int foundIndex, int[] arrMarbles) {
        if (foundIndex == 0) {
            return foundIndex;
        }
        if (foundIndex == arrMarbles[arrMarbles.length - 1] && searchNumber > arrMarbles[foundIndex - 1]) {
            return foundIndex;
        }

        if (arrMarbles[foundIndex - 1] == searchNumber) {
            int moveback = foundIndex - 1;
            while (arrMarbles[--moveback] == searchNumber && moveback != 0) {
                foundIndex = moveback;
            }
        }
        return foundIndex;
    }

    public static class NumberUtil {

        public static List<Integer> convertByString(final String str) {
            return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
                    .collect(Collectors.toList());
        }

    }


}
