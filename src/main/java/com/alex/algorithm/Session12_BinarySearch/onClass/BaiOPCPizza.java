package com.alex.algorithm.Session12_BinarySearch.onClass;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaiOPCPizza {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int numOfTestCase = Integer.valueOf(scanner.nextLine());
        for (int testCaseCount = 0; testCaseCount < numOfTestCase; testCaseCount++) {
            final List<Integer> inputLine = NumberUtil.convertByString(scanner.nextLine());
            final int numOfFriends = inputLine.get(0);
            final int numOfPriceOfPizza = inputLine.get(1);

            //get moneys then convert to array within sorting
            final List<Integer> moneys = NumberUtil.convertByString(scanner.nextLine());
            int[] arrMoneys = new int[numOfFriends];
            for (int i = 0; i < arrMoneys.length; i++) {
                arrMoneys[i] = moneys.get(i);
            }
            Arrays.sort(arrMoneys);

            //find pair friend equal price of pizza
            int countPair = 0;
            for (int i = 0; i < arrMoneys.length; i++) {
                final int firstMoney = arrMoneys[i];
                final int needToSearchMoney = numOfPriceOfPizza - firstMoney;
                //Need to find the second money to become a pair
                final int indexOfSecondMoney = Arrays.binarySearch(arrMoneys, i + 1, arrMoneys.length,
                        needToSearchMoney);
                if (indexOfSecondMoney > i && indexOfSecondMoney < arrMoneys.length) {
                    countPair++;
                }
            }

            System.out.println(countPair);

        }
    }

    public static class NumberUtil {

        public static List<Integer> convertByString(final String str) {
            return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
                    .collect(Collectors.toList());
        }

    }

}
