package com.alex.algorithm.Session3_Sorting.onClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bai169_A {


    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final List<Integer> firstInputNums = NumberUtil.convertByString(scanner.nextLine());
        final List<Integer> secondInputNums = NumberUtil.convertByString(scanner.nextLine());

        Collections.sort(secondInputNums);

//        secondInputNums.forEach(num -> System.out.print(num + " "));

        final int choresOfYounger = firstInputNums.get(2);
        final int numberOfBetweenChores = findBetweenNumber(choresOfYounger, secondInputNums);
//        System.out.print("Result:" + numberOfBetweenChores);
        System.out.print(numberOfBetweenChores);
    }

    private static int findBetweenNumber(int choresOfYounger, List<Integer> secondInputNums) {
        final int maxComplexOfYounger = secondInputNums.get(choresOfYounger - 1);
        final int easiesComplexOfElder = secondInputNums.get(choresOfYounger);
        return easiesComplexOfElder - maxComplexOfYounger;
    }

    static class NumberUtil {

        public static List<Integer> convertByString(final String str) {
            return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
                    .collect(Collectors.toList());
        }

    }
}
