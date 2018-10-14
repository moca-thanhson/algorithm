package com.alex.algorithm.Session3_Sorting.btvn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bai551_A {

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int allRatings = Integer.valueOf(scanner.nextLine());
    final List<Integer> originalRatings = NumberUtil.convertByString(scanner.nextLine());
    final List<Integer> sortingRating = new ArrayList<>(originalRatings);

    // sorting
    Collections.sort(sortingRating);

    final Map<Integer, Integer> mapRateToCountHigherRates = new HashMap<>();
    for (int currentIndex = 0; currentIndex < sortingRating.size(); currentIndex++) {
      if (currentIndex == sortingRating.size() - 1) {
        final int lastRating = sortingRating.get(currentIndex);
        mapRateToCountHigherRates.put(lastRating, 1);
      } else {
        final int currentRating = sortingRating.get(currentIndex);
        final int nextRating = sortingRating.get(currentIndex + 1);
        if (currentRating < nextRating) {
          final int higherRating = allRatings - currentIndex; // as formula higher rating + 1
          mapRateToCountHigherRates.put(currentRating, higherRating);
        }
      }
    }

    // print result
    originalRatings.forEach(
        rating -> System.out.print(mapRateToCountHigherRates.get(rating) + " "));
  }

  static class NumberUtil {

    static List<Integer> convertByString(final String str) {
      return Arrays.asList(str.split(" "))
          .stream()
          .map(interestStr -> Integer.valueOf(interestStr))
          .collect(Collectors.toList());
    }
  }
}
