package com.alex.algorithm.Session4_StackAndQueue.onclass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1876
 */
public class Bai_ThrowCardAway {

    public static void main(String[] args) {
        final Scanner scannner = new Scanner(System.in);
        while (true) {
            int number = Integer.valueOf(scannner.nextLine());
            if (number == 0) {
                break; //exit
            }

            //add numbers into queue
            final Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= number; i++) {
                queue.add(i);
            }

            //Retrieve discarding cards
            System.out.print("Discarded cards:");
            while (queue.size() > 1) {
                int showCard = queue.element();
                queue.remove();
                System.out.print(" " + showCard);

                int movedCard = queue.element();
                queue.add(movedCard); //move to end of queue
                queue.remove();
            }

            //Retrieve Remaining card
            System.out.print("\nRemaining card: " + queue.element() + "\n");
            queue.remove(); //remove the last card
        }
    }
}
