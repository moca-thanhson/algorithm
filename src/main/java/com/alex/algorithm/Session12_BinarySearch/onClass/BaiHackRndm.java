package com.alex.algorithm.Session12_BinarySearch.onClass;

import com.alex.algorithm.NumberUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.spoj.com/problems/HACKRNDM/fbclid=IwAR1p7Y_4azMOWVG2vLciQTfsWdD_b-jUnjISfdGOwF5eEByHnwzK3Xic5ZM
 */
public class BaiHackRndm {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<Integer> lineInput = NumberUtil.convertByString(scanner.nextLine());
        final int totalNumbers = lineInput.get(0);
        final int difference = lineInput.get(1);

        //get numbers and sort them
        final List<Integer> lstNumbers = NumberUtil.convertByString(scanner.nextLine());
        Collections.sort(lstNumbers);
        final Integer[] arrNumbers = lstNumbers.toArray(new Integer[lstNumbers.size()]);

        //count pairs
        int count = 0;
        for (int i = 0; i < totalNumbers - 1; i++) {
            int pairNumber = lstNumbers.get(i) + difference;
            final int indexOfPairNum = Arrays.binarySearch(arrNumbers, i + 1,
                    arrNumbers.length, pairNumber);
            if (indexOfPairNum >= i && indexOfPairNum < arrNumbers.length) {
                count++;
            }
        }

        System.out.print(count);

    }

}
