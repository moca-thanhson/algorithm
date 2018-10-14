package com.alex.algorithm.Session3_Sorting.onClass;

import com.alex.algorithm.Session2_ComplexityAlgorithm.onClass.NumberUtil;

import java.util.*;

public class Bai451_B {

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int numberOfArr = Integer.valueOf(scanner.nextLine());
        final List<Integer> lstOfNumbers = NumberUtil.convertByString(scanner.nextLine());

        findSeqment(numberOfArr, lstOfNumbers);

    }

    private static void findSeqment(final int numberOfArr, List<Integer> lstOfNumbers) {

        final List<Integer> sortedArr = new ArrayList<>(lstOfNumbers);

        Collections.sort(sortedArr);

        int left = 0;
        boolean foundLeft = false;
        int right = 0;
        for (int i = 0; i < sortedArr.size(); i++) {
            final int originalItem = lstOfNumbers.get(i);
            final int sortedItem = sortedArr.get(i);

            if (originalItem != sortedItem) {
                if (!foundLeft) {
                    left = i;
                    foundLeft = true;
                }
                right = i;
            }
        }

        if (left == right) {
            System.out.println("yes");
            System.out.println(String.format("%s %s", left + 1, right + 1));
            return;
        }


        final Integer[] lstNumberArr = lstOfNumbers.toArray(new Integer[lstOfNumbers.size()]);
        Arrays.sort(lstNumberArr, left, right + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        final List<Integer> lstAfterReverse = Arrays.asList(lstNumberArr);


        if (lstAfterReverse.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println(String.format("%s %s", left + 1, right + 1));
        } else {
            System.out.println("no");
        }

    }
}

// Phuong phap biet truoc ket qua. Copy & sort into the second array.
// Find left, and right , continue moving right .
// If found left, fixed left. Try to find right, continue right to the end.
// After that, sort the first array . Then compare with second array
// same : YES
// difference : NO

// 7 9 6 5 10

// => 7| 5 6 9 |10

// => After reverse : checking 7 && 5, checking 9 && 10 . If still can find another seqment => No