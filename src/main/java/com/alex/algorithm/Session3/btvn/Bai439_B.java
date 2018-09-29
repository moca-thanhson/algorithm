package com.alex.algorithm.Session3.btvn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bai439_B {

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final List<Integer> firstInputNumbers = NumberUtil.convertByString(scanner.nextLine());
    final List<Integer> lstOfChapers = NumberUtil.convertByString(scanner.nextLine());

    final int countSubjects = firstInputNumbers.get(0);
    final int initialTime = firstInputNumbers.get(1);

    Collections.sort(lstOfChapers);

    final long sumOfLearningTime = calculateLearningTime(initialTime, lstOfChapers);
    System.out.println(sumOfLearningTime);
  }

  private static long calculateLearningTime(int initialTime, final List<Integer> lstAllChapers) {

    long sum = 0L;

    for (int chaptersOfSubject : lstAllChapers) {
      final int timeOfSubject = chaptersOfSubject * initialTime;
      sum += timeOfSubject;
      if (initialTime - 1 >= 1) {
        initialTime--;
      }
    }

    return sum;
  }

  static class NumberUtil {

    public static List<Integer> convertByString(final String str) {
      return Arrays.asList(str.split(" "))
          .stream()
          .map(interestStr -> Integer.valueOf(interestStr))
          .collect(Collectors.toList());

    }
  }
}
