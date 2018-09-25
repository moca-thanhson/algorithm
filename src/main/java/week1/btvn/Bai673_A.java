package week1.btvn;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bai673_A {

	private static final int BORING_MINUTES_TO_TURNOFF = 15;
	private static final int FULL_MATCH_TIME = 90;

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final String firstInputStr = scanner.nextLine();
		final String secondInputStr = scanner.nextLine();

		final List<Integer> interestMinutes = Arrays.asList(secondInputStr.split(" ")).stream()
				.map(interestStr -> Integer.valueOf(interestStr)).collect(Collectors.toList());
		final int watchTvMinutes = calculateWatchMinutes(Integer.valueOf(firstInputStr), interestMinutes);
		System.out.println(watchTvMinutes);

		scanner.close();
	}

	private static int calculateWatchMinutes(Integer totalInterestMinute, List<Integer> interestMinutes) {
		int watchingTime = 0;
		int previousInterest = 0;
		for (int currInterestTime : interestMinutes) {
			final int boringTime = currInterestTime - previousInterest;
			if (boringTime > BORING_MINUTES_TO_TURNOFF) {
				return watchingTime += BORING_MINUTES_TO_TURNOFF;
			} else {
				watchingTime += boringTime;
				previousInterest = currInterestTime;
			}
		}

		// check last interest time point
		final int lastBoringTime = FULL_MATCH_TIME - previousInterest;
		if (lastBoringTime < BORING_MINUTES_TO_TURNOFF) {
			return FULL_MATCH_TIME;
		} else {
			watchingTime += BORING_MINUTES_TO_TURNOFF;
		}
		return watchingTime;
	}

}
