package com.alex.algorithm.Session2_ComplexityAlgorithm.onClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Because N,K <= 10^5 => complexity must be NlogN or N . Can not be N^N.
 * 
 * @author thanhson
 *
 */
public final class Bai224_B {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final List<Integer> numberOfFirstInput = NumberUtil.convertByString(scanner.nextLine());
		final List<Integer> numberOfSecondInput = NumberUtil.convertByString(scanner.nextLine());

		final int totalNums = numberOfFirstInput.get(0);
		final int lenOfSeqment = numberOfFirstInput.get(1);

		findSeqment(lenOfSeqment, numberOfSecondInput);
	}

	private static void findSeqment(int lenOfSeqment, List<Integer> numberOfSecondInput) {
		final List<Integer> seqment = new ArrayList<>();
		int leftIndex = 0;
		int rightIndex = 0;
		int countDistinctNumber = 0;
		for (int currentIndex = 0; currentIndex < numberOfSecondInput.size(); currentIndex++) {
			final int currNumber = numberOfSecondInput.get(currentIndex);
			if (!seqment.contains(currNumber)) {
				seqment.add(currNumber);
				rightIndex = currentIndex;
				countDistinctNumber++;
			} else {
				leftIndex = currentIndex;
			}

			if (countDistinctNumber == lenOfSeqment) {
				break;
			}
		}

		System.out.println(normalizeIndex(leftIndex) + " " + normalizeIndex(rightIndex));

	}

	/**
	 * Increase index position to output as format from exercise.
	 * 
	 * @param index
	 * @return
	 */
	private static int normalizeIndex(int index) {
		return index + 1;
	}

}
