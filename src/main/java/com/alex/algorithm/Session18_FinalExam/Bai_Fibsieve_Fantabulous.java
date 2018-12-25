package com.alex.algorithm.Session18_FinalExam;

import java.util.Scanner;

public class Bai_Fibsieve_Fantabulous {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(final String[] args) {

    int numOfTestCases = scanner.nextInt();
    int testCase = 0;
    while (testCase < numOfTestCases) {
      int timeUp = scanner.nextInt();
      predictNumber(testCase, timeUp);
      testCase++;
    }

  }

  /**
   * We see the way build chess board in a order so we tried to predict the position based on the way in picture.
   *
   * @param testCase
   * @param timeUp
   */
  private static void predictNumber(int testCase, int timeUp) {
    double lineOfSquare = Math.ceil(Math.sqrt(timeUp));
    double radius = lineOfSquare * lineOfSquare - timeUp;
    double column, row;
    if (radius < lineOfSquare) {
      row = radius + 1;
      column = lineOfSquare;
    } else {
      column = 2 * lineOfSquare - radius - 1;
      row = lineOfSquare;
    }
    if (lineOfSquare == 1) {
      double temp = column;
      column = row;
      row = temp;
    }
    System.out.println(String.format("Case %s: %s %s", testCase, column, row));
  }

}
