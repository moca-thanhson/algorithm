package com.alex.algorithm.Session4_StackAndQueue.onclass;

import com.alex.algorithm.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.spoj.com/problems/STPAR/
 */
public class Bai_STPAR {

    private static final Stack<Integer> stack = new Stack<>();
    private static final List<Integer> streetCars = new ArrayList<>();

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final int numOfCar = Integer.valueOf(scanner.nextLine());
            if (numOfCar == 0) {
                break; //exit
            }

            //input data
            final List<Integer> pendingCars = NumberUtil.convertByString(scanner.nextLine());


            boolean canBeShow = true; //assume can be shown all cars
            for (int i = 0; i < pendingCars.size(); i++) {
                final int currCar = pendingCars.get(i);
                if (currCar == 1 || isNextCar(currCar)) {
                    streetCars.add(currCar);
                    continue;
                }

                //in case : current car is not available for streetCar
                // get the list of accepted cars in stack put into street car
                while (!stack.isEmpty()) {
                    int carInStack = stack.peek();
                    if (isNextCar(carInStack)) {
                        streetCars.add(stack.pop());
                    } else {
                        break; // get out loop
                    }
                }

                //check current car can add into street after adding stack or not.
                if (isNextCar(currCar)) {
                    streetCars.add(currCar);
                } else if (stack.isEmpty()) {
                    stack.add(currCar);
                } else if (currCar > stack.peek()) {
                    //check the rest car in stack with current car
                    // can not add current car , and current car > head car of stack.
                    canBeShow = false;
                    break;
                } else {
                    stack.add(currCar);
                }
            }

            //traverse stack in case there's some waiting cars in stack
            while (!stack.isEmpty() && canBeShow == true) {
                if (!isNextCar(stack.peek())) {
                    canBeShow = false;
                    break;
                } else {
                    streetCars.add(stack.pop());
                }
            }

            //write output
            if (canBeShow) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            //reset
            stack.clear();
            streetCars.clear();


        }
    }

    private static boolean isNextCar(int car) {
        if (streetCars.isEmpty()) {
            return false;
        }
        return car - streetCars.get(streetCars.size() - 1) == 1;
    }


}
