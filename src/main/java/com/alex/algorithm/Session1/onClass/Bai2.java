package com.alex.algorithm.Session1.onClass;

import java.util.Scanner;

/** http://codeforces.com/problemset/problem/518/A */
public class Bai2 {

  private static final String NOT_FOUND_RESULT = "No such string";
  private static final int MAX_LEN = 100;

  public static void main(final String[] args) {

    final Scanner scanner = new Scanner(System.in);
    final String firstStr = scanner.next();

    final String secondStr = scanner.next();

    checkSameLengthInputStr(firstStr, secondStr);
    checkContainOnlyLowerCase(firstStr);
    checkContainOnlyLowerCase(secondStr);

    final String betweenStr = findBetweenLexicoes(firstStr, secondStr);
    System.out.println(String.format("%s", betweenStr));
  }

  private static String findBetweenLexicoes(final String firstStr, final String secondStr) {
    final StringBuilder sb = new StringBuilder();
    boolean foundAnyBetweenLexico = false;
    for (int currentIndexOfChar = 0; currentIndexOfChar < firstStr.length(); currentIndexOfChar++) {
      final char firstChar = firstStr.charAt(currentIndexOfChar);
      final char secondChar = secondStr.charAt(currentIndexOfChar);

      if (!existAnyBetweenLexico(firstChar, secondChar)) {
        return NOT_FOUND_RESULT;
      }

      if (!foundAnyBetweenLexico) {
        if (foundAnyLexicoNotAtLastChar(firstStr, currentIndexOfChar, firstChar, secondChar)) {
          foundAnyBetweenLexico = true;
        }
      }

      final char betweenChar =
          findBetweenLexico(
              firstStr.charAt(currentIndexOfChar),
              secondStr.charAt(currentIndexOfChar),
              (currentIndexOfChar == firstStr.length() - 1));
      sb.append(betweenChar);
    }

    if (!foundAnyBetweenLexico) {
      return NOT_FOUND_RESULT;
    }
    return sb.toString();
  }

  private static boolean foundAnyLexicoNotAtLastChar(
      final String firstStr,
      final int currentIndexOfChar,
      final char firstChar,
      final char secondChar) {
    if (firstStr.length() == 1) {
      return (firstChar < secondChar);
    }

    if (!isLastChar(firstStr, currentIndexOfChar)) {
      return firstChar < secondChar;
    }

    return foundAtLastCharOfLongString(firstChar, secondChar);
  }

  private static boolean foundAtLastCharOfLongString(final char firstChar, final char secondChar) {
    final int distance = secondChar - firstChar;
    if (distance == 1) {
      return false;
    }
    return true;
  }

  private static boolean isLastChar(final String firstStr, final int currentIndexOfChar) {
    return currentIndexOfChar == firstStr.length() - 1;
  }

  private static char findBetweenLexico(
      final char firstChar, final char secondChar, final boolean isLastChar) {
    if (isLastChar) {
      return (char) (firstChar + 1);
    }
    if (firstChar == secondChar) {
      return firstChar;
    }
    return (char) (firstChar + 1);
  }

  private static boolean existAnyBetweenLexico(final char firstChar, final char secondChar) {
    return firstChar > secondChar ? false : true;
  }

  private static void checkSameLengthInputStr(final String firstStr, final String secondStr) {
    if (firstStr.isEmpty() || secondStr.isEmpty()) {
      throw new IllegalArgumentException(String.format("Input string length must be not empty"));
    }
    if (firstStr.length() > MAX_LEN || secondStr.length() > MAX_LEN) {
      throw new IllegalArgumentException(
          String.format("Input length must be less than %s", MAX_LEN));
    }
    if (firstStr.length() != secondStr.length()) {
      throw new IllegalArgumentException(
          String.format(
              "First string length is %s, second string length is %s. They should be same length"));
    }
  }

  private static void checkContainOnlyLowerCase(final String str) {
    final char[] charArr = str.toCharArray();
    for (char c : charArr) {
      if (c < 'a' || c > 'z') {
        throw new IllegalArgumentException("Input string must be contain only lower case");
      }
    }
  }
}
