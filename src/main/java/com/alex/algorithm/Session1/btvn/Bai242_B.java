package com.alex.algorithm.Session1.btvn;

import com.alex.algorithm.Session2.onClass.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * Link submit: http://codeforces.com/problemset/problem/242/B
 *
 * @author thanhson
 */
public class Bai242_B {

  private static final int INDEX_OF_LEFT_VALUE = 0;
  private static final int INDEX_OF_RIGHT_VALUE = 0;
  private static final int NOT_FOUND_SEQMENT_INDEX = 0;

  public static void main(String[] args) {

    final Scanner scanner = new Scanner(System.in);
    final int totalOfSeqments = Integer.valueOf(scanner.next());

    final List<List<Integer>> listSeqments = new ArrayList<>();
    for (int i = 0; i <= totalOfSeqments; i++) {
      listSeqments.add(NumberUtil.convertByString(scanner.nextLine()));
    }

    final int indexOfCoverSeqment = findCoverSeqment(listSeqments);
    if (indexOfCoverSeqment != NOT_FOUND_SEQMENT_INDEX) {
      System.out.println(indexOfCoverSeqment + 1);
    } else {
      System.out.println(NOT_FOUND_SEQMENT_INDEX);
    }

    scanner.close();
  }

  private static int findCoverSeqment(final List<List<Integer>> listSeqments) {
    final List<Integer> leftPositions = collectPosition(listSeqments, INDEX_OF_LEFT_VALUE);
    final List<Integer> rightPositions = collectPosition(listSeqments, INDEX_OF_RIGHT_VALUE);
    final int lessMostPosition =
        leftPositions.stream().mapToInt(position -> position).min().getAsInt();
    final int greaterMostPosition =
        rightPositions.stream().mapToInt(position -> position).max().getAsInt();
    final List<Integer> coverIndexSeqment = Arrays.asList(lessMostPosition, greaterMostPosition);
    return listSeqments.indexOf(coverIndexSeqment);
  }

  private static List<Integer> collectPosition(
      final List<List<Integer>> listSeqments, final int indexOfLeftValue) {
    return listSeqments
        .stream()
        .map(seqment -> seqment.get(indexOfLeftValue))
        .collect(Collectors.toList());
  }
}
