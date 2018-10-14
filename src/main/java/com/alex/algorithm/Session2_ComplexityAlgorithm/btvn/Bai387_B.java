package com.alex.algorithm.Session2_ComplexityAlgorithm.btvn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bai387_B {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> numberOfProblems = NumberUtil.convertByString(scanner.nextLine());
        final List<Integer> requireComplexities = NumberUtil.convertByString(scanner.nextLine());
        final List<Integer> prepareComplexities = NumberUtil.convertByString(scanner.nextLine());

        if (prepareComplexities.get(0) > requireComplexities.get(numberOfProblems.get(0) - 1)) {

        }

        final int countNotPrepareComplexities = countNotPrepareComplexities(requireComplexities, prepareComplexities);
        System.out.println(countNotPrepareComplexities);

        scanner.close();

    }

    /**
     * Two pointers technique. 1 pointer to traverse from end to zero of require
     * complexities. It's a loop 2 pointer traverse from end to zero of prepare
     * complexities but not loop.
     *
     * @param requireComplexities
     * @param prepareComplexities
     * @return
     */
    private static int countNotPrepareComplexities(List<Integer> requireComplexities,
                                                   List<Integer> prepareComplexities) {

        int missingPrepare = 0;
        int iterateOfPrepareComp = prepareComplexities.size() - 1;
        for (int iter = requireComplexities.size() - 1; iter >= 0; iter--) {
            final int requireComp = requireComplexities.get(iter);
            final int prepareComp = prepareComplexities.get(iterateOfPrepareComp);
            if (requireComp != prepareComp) {
                missingPrepare++;
            } else if (iterateOfPrepareComp > 0) {
                final Optional<Integer> indexOfFoundPrepareComp = findWithSmallerPrepareComplexity(iterateOfPrepareComp,
                        prepareComplexities, requireComp);
                iterateOfPrepareComp = indexOfFoundPrepareComp.get();
            }
        }

        return missingPrepare;
    }

    private static Optional<Integer> findWithSmallerPrepareComplexity(final int lastIndexOfPrepareComp,
                                                                      List<Integer> prepareComplexities, final int findRequireComplexity) {
        for (int iterateOfPrepareComp = lastIndexOfPrepareComp - 1; iterateOfPrepareComp > 0; iterateOfPrepareComp--) {
            if (prepareComplexities.get(iterateOfPrepareComp) < findRequireComplexity) {
                return Optional.of(iterateOfPrepareComp);
            }
        }
        return Optional.of(0);
    }

    static class NumberUtil {
        public static List<Integer> convertByString(final String str) {
            return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
                    .collect(Collectors.toList());
        }

    }

}
