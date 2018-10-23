package com.alex.algorithm.Session09_MidTerm;

import com.alex.algorithm.NumberUtil;

import java.util.List;
import java.util.Scanner;

/**
 * 3 17 4
 * cost : 3 6 9 12
 * result = [ (3 + 12) + (6 + 9) ] - 17 = 13
 */
public class SoldierAndBananas {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> inputLine = NumberUtil.convertByString(scanner.nextLine());

        final int initPrice = inputLine.get(0);
        final int money = inputLine.get(1);
        final int numOfBananas = inputLine.get(2);

        int sum = calculateSum(initPrice, numOfBananas);

        if (sum <= money) {
            System.out.print(0);
        } else {
            System.out.println(sum - money);
        }

    }

    private static int calculateSum(int initPrice, int numOfBananas) {
        if (numOfBananas == 1) {
            return initPrice;
        }

        if (numOfBananas % 2 == 0) {
            return sumOfEvenNumber(initPrice, numOfBananas);
        } else {
            int sum = sumOfEvenNumber(initPrice, numOfBananas);
            int costByMiddle = initPrice * (numOfBananas / 2 + 1);
            return sum + costByMiddle;
        }
    }

    private static int sumOfEvenNumber(int initPrice, int numOfBananas) {
        return ((initPrice * 1) + (initPrice * numOfBananas)) * (numOfBananas / 2);
    }
}
