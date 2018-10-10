package com.alex.algorithm.Session7.onClass;


import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/practice-problems/algorithm/monk-and-multiplication/
 * 1
 * /  \
 * 2   3
 * /   /
 * 4   5
 */
public class Bai_MonkAndMultiplication {

    private static final int REQUIRED_INDEX = 3;

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int totalOfNum = Integer.valueOf(scanner.nextLine());
        final List<Integer> numbers = NumberUtil.convertByString(scanner.nextLine());

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MaxComparator());
        numbers.forEach(
                num -> priorityQueue.add(num)
        );


        int prevNum1;
        int prevNum2;
        while (!priorityQueue.isEmpty()) {
            final int currNum = priorityQueue.remove();
            prevNum1 = priorityQueue.remove();
            prevNum2 = priorityQueue.remove();

            System.out.println(currNum * prevNum1 * prevNum2 + " ");
        }

        System.out.print("-1 -1");

    }

    static final class NumberUtil {

        public static List<Integer> convertByString(final String str) {
            return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
                    .collect(Collectors.toList());
        }

    }

    static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
