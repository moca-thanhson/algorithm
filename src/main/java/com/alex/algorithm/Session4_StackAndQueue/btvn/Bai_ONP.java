package com.alex.algorithm.Session4_StackAndQueue.btvn;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.spoj.com/problems/ONP/
 */
public class Bai_ONP {

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final Stack<Character> stack = new Stack<>();
            String expression = scanner.nextLine();
            if (expression.equals("0")) {
                break; //exit
            }

            for (int i = 0; i < expression.length(); i++) {
                char currChar = expression.charAt(i);
                if (Character.isLetter(currChar)) {
                    System.out.print(currChar);
                } else if (currChar == ')') { // execute calculate
                    System.out.print(stack.pop());
                } else if (currChar != '(')// in case current char is operator such as : +, -, * , / , ^ ryv..
                {
                    stack.push(currChar);
                }
            }
        }
    }

}

