package com.alex.algorithm.Session7_Heap_PriorityQueue.btvn;

import com.alex.algorithm.NumberUtil;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Source:
 * <a>
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1895
 * </a>
 */
public class BaiAddAll {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        while (true) {
            int totalNumbers = Integer.valueOf(scanner.nextLine());
            if (totalNumbers == 0) {
                break; //exit
            }

            final PriorityQueue<Integer> queue = new PriorityQueue<>();
            //Read input
            final List<Integer> lineInput = NumberUtil.convertByString(scanner.nextLine());
            lineInput.forEach(
                    number -> queue.add(number)
            );

            int result = 0;
            while (queue.size() > 1) {
                int firstSmallNumber = queue.peek();
                queue.remove();
                int secondSmallNumber = queue.peek();
                queue.remove();

                int sumOfTwoSmallestNums = firstSmallNumber + secondSmallNumber;
                queue.add(sumOfTwoSmallestNums);

                //update total sum
                result += sumOfTwoSmallestNums;
            }

            //write output of total sum
            System.out.println(result);


        }

    }
}
