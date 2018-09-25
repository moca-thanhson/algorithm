package week1.btvn;

import java.util.Optional;
import java.util.Scanner;

public class Bai518_A {

	private static final String NOT_FOUND_LEXICO = "No such string";

	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final String smallLexicoStr = scanner.next();
		final String bigLexicoStr = scanner.next();

		final Optional<String> betweenLexicoStr = findBetweenLexicoStr(smallLexicoStr, bigLexicoStr);
		if (betweenLexicoStr.isPresent()) {
			System.out.println(betweenLexicoStr.get());
		} else {
			System.out.println(NOT_FOUND_LEXICO);
		}

		scanner.close();
	}

	private static Optional<String> findBetweenLexicoStr(final String smallLexicoStr, final String bigLexicoStr) {
		final char[] smallArrLexico = smallLexicoStr.toCharArray();
		final char[] bigArrLexico = bigLexicoStr.toCharArray();
		if (smallArrLexico.length == 1) {
			final StringBuilder sb = new StringBuilder();
			final String uniWord = sb.append(findNextChar(smallArrLexico[0], bigArrLexico[0])).toString();
			return Optional.of(uniWord);
		}

		if (isSameExceptLasChar(smallLexicoStr, bigLexicoStr)) {
			final String subSmallLexicoStr = smallLexicoStr.substring(0, smallLexicoStr.length() - 1);
			final char nextChar = findNextChar(smallArrLexico[smallLexicoStr.length() - 1]);
			final StringBuilder sb = new StringBuilder(subSmallLexicoStr).append(nextChar);
			return Optional.of(sb.toString());
		}

		return findIfLongSequence(smallArrLexico, bigArrLexico);
	}

	private static boolean isSameExceptLasChar(String smallLexicoStr, String subSBigLexicoStr) {
		final String subSmallLexicoStr = smallLexicoStr.substring(0, smallLexicoStr.length() - 1);
		final String subBigLexicoStr = subSBigLexicoStr.substring(0, smallLexicoStr.length() - 1);
		return subSmallLexicoStr.equals(subBigLexicoStr);
	}

	private static Optional<String> findIfLongSequence(final char[] smallArrLexico, final char[] bigArrLexico) {
		final StringBuilder sb = new StringBuilder();
		int sumOfBetweenSequence = 0;
		int sumOfSmallArrLexico = 0;
		int sumOfBigArrLexico = 0;
		for (int currentIndex = 0; currentIndex < smallArrLexico.length; currentIndex++) {
			final char smallChar = smallArrLexico[currentIndex];
			final char nextSmallChar = getNextSmallChar(smallArrLexico, currentIndex);
			final char bigChar = bigArrLexico[currentIndex];
			if (currentIndex < smallArrLexico.length - 1) {
				final char betweenChar = findWithBetweenChar(smallChar, nextSmallChar, bigChar);
				sb.append(betweenChar);
				sumOfBetweenSequence += betweenChar;
			} else {
				final char betweenChar = findNextChar(smallChar);
				sb.append(betweenChar);
				sumOfBetweenSequence += betweenChar;
			}

			sumOfSmallArrLexico += smallChar;
			sumOfBigArrLexico += bigChar;
		}

//		System.out.println(sb.toString());

		if ((sumOfSmallArrLexico == sumOfBetweenSequence) || (sumOfBetweenSequence == sumOfBigArrLexico)) {
			return Optional.empty();
		}
		return Optional.of(sb.toString());
	}

	private static char getNextSmallChar(final char[] smallArrLexico, int currentIndex) {
		if (currentIndex < smallArrLexico.length - 1) {
			return smallArrLexico[currentIndex + 1];
		}
		return smallArrLexico[currentIndex];

	}

	private static char findWithBetweenChar(char smallChar, char nextChar, char bigChar) {
		if (smallChar == bigChar) {
			return smallChar;
		}
		if (nextChar != 'z') {
			return findNextChar(smallChar);
		}
		return findNextChar(smallChar, bigChar);
	}

	private static char findNextChar(final char smallChar, final char bigChar) {
		if (smallChar == 'z') {
			return 'a';
		}
		if (bigChar == 'z') {
			return 'z';
		} else {
			return (char) (smallChar + 1);
		}
	}

	private static char findNextChar(final char currChar) {
		if (currChar == 'z') {
			return 'a';
		} else {
			return (char) (currChar + 1);
		}
	}

}
