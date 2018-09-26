package com.alex.algorithm.Session3.onClass;

import com.alex.algorithm.Session2.onClass.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bai451_B {

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int numberOfArr = Integer.valueOf(scanner.next());
        final List<Integer> lstOfNumbers = NumberUtil.convertByString(scanner.nextLine());

    }

    private static List<Integer> findSeqment(final int numberOfArr, List<Integer> lstOfNumbers) {
        int startIndex = 0;
        int endIndex = 0;
        boolean isFoundSeqment = false;
        for (int i = numberOfArr - 1; i > 0; i--) {
            if (!isFoundSeqment) {
                final int currNum = lstOfNumbers.get(i);
                final int j = i--;
                if (currNum < lstOfNumbers.get(j) && endIndex == 0) {
                    endIndex = i;
                } else if (endIndex > 0) {
                    startIndex = i;
                    isFoundSeqment = true;
                }
            }
        }

        Arrays.sort(lstOfNumbers.toArray(), startIndex, endIndex + 1);

        return null;
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