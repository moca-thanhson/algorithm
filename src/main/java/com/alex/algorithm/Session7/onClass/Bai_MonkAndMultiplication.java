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
    private static final String DEF_OUTPUT = "-1";

    private static int MAX = 100005;
    private static Long[] arr = new Long[MAX];


    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int totalOfNum = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < totalOfNum; i++) {
            arr[i] = scanner.nextLong();
        }

        final PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });

        //traverse priority queue
        for (int i = 0; i < totalOfNum; i++) {
            queue.add(arr[i]);
            if (i < REQUIRED_INDEX - 1) {
                System.out.println(DEF_OUTPUT);
            } else {
                final List<Long> threeTopNumbers = new ArrayList<>();

                int count = 0;
                long sum = 0;
                while (count < REQUIRED_INDEX) {
                    final long num = queue.peek();
                    threeTopNumbers.add(num);
                    queue.remove(); //move to next number;

                    sum += num; //update sum
                    count++;
                }
                System.out.println(sum); //output sum

                //add these number again into queue
                queue.addAll(threeTopNumbers);

            }
        }


    }

    static final class NumberUtil {

        public static List<Integer> convertByString(final String str) {
            return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
                    .collect(Collectors.toList());
        }

    }

}
