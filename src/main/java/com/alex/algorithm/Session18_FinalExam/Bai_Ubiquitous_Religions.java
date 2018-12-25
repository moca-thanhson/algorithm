package com.alex.algorithm.Session18_FinalExam;

import com.alex.algorithm.NumberUtil;
import com.alex.algorithm.Session16_Disjoin.DisjoinUtil;

import java.util.List;
import java.util.Scanner;

public class Bai_Ubiquitous_Religions {

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    int numberOfStudent = scanner.nextInt();
    int numberOfPairs = scanner.nextInt();
    if (numberOfStudent != 0 && numberOfPairs != 0) {

      DisjoinUtil.makeSet();
      for (int i = 0; i < numberOfPairs; i++) {
        final List<Integer> students = NumberUtil.convertByString(scanner.nextLine());
        DisjoinUtil.unionSet(students.get(0), students.get(1));
      }

      final int maximumReligious = DisjoinUtil.countDistinctParent();
      System.out.println(maximumReligious);

    }
  }
}
