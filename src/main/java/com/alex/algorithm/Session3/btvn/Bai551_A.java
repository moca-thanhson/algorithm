package com.alex.algorithm.Session3.btvn;

import com.alex.algorithm.Session2.onClass.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 *
 * <pre>
 * 3 5 3 4 5
 * step 1 : sorting increase
 *  3 3 4 5 5
 *  step 2 :
 *   - declare Map<Number, countRating> mapRating
 *   - iterator : i from index = 0 -> length
 *     int countAppear++
 *     if(a[i + 1] > a[i]) {
 *       mapRating.put(a[i], (sum - i) + 1);
 *      //number of students higher + 1 as defined fomula in exam
 *     }
 *   - step 3 :
 *     Count i : from index = 0 => length of listRating
 *     Show value by : map.get(i) -> value as (sum-i_
 * </pre>
 */
public class Bai551_A {

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int allRatings = Integer.valueOf(scanner.nextLine());
    final List<Integer> originalRatings = NumberUtil.convertByString(scanner.nextLine());
    final List<Integer> sortingRating = new ArrayList<>(originalRatings);

    // sorting
    Collections.sort(sortingRating);

    final Map<Integer, Integer> mapRateToCountHigherRates = new HashMap<>();
    for (int currentIndex = 0; currentIndex < sortingRating.size() - 1; currentIndex++) {
      final int currentRating = sortingRating.get(currentIndex);
      final int nextRating = sortingRating.get(currentIndex + 1);
      if (currentRating < nextRating) {
        final int higherRating = allRatings - currentIndex; // as formula higher rating + 1
        mapRateToCountHigherRates.put(currentRating, higherRating);
      }
    }

    // handle last position
    final int lastRating = originalRatings.get(allRatings - 1);
    mapRateToCountHigherRates.put(lastRating, 1);

    // print result
    originalRatings.forEach(
        rating -> System.out.print(mapRateToCountHigherRates.get(rating) + " "));
  }
}
