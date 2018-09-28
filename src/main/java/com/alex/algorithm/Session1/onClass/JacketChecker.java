package com.alex.algorithm.Session1.onClass;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JacketChecker {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final int numberOfButtons = Integer.parseInt(scanner.nextLine());
		checkValidNumberOfButton(numberOfButtons);
		final List<Integer> buttonsStatus = convertStringToList(scanner.nextLine());
		checkValidButtonStatus(buttonsStatus, numberOfButtons);

		if (isFastenJacket(numberOfButtons, buttonsStatus)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean isFastenJacket(final int numberOfButtons, final List<Integer> buttonsStatus) {
		if (oneButtonIsFasten(numberOfButtons, buttonsStatus)) {
			return true;
		}

		if (multipleButtonsHasAtLeastOneFasten(numberOfButtons, buttonsStatus)) {
			return true;
		}

		return false;
	}

	private static boolean multipleButtonsHasAtLeastOneFasten(final int numberOfButtons,
			final List<Integer> buttonsStatus) {
		return numberOfButtons > 1 && countOpenningButton(buttonsStatus) == 1;
	}

	private static boolean oneButtonIsFasten(final int numberOfButtons, final List<Integer> buttonsStatus) {
		return numberOfButtons == 1 && buttonsStatus.get(0) == 1;
	}

	private static int countOpenningButton(List<Integer> buttonsStatus) {
		int numOfOpenButtons = 0;
		for (int button : buttonsStatus) {
			if (button == 0) {
				numOfOpenButtons++;
			}
		}
		return numOfOpenButtons;
	}

	private static void checkValidButtonStatus(final List<Integer> buttonsStatus, final int numberOfButtons) {
		if (buttonsStatus.size() != numberOfButtons) {
			throw new RuntimeException(
					String.format("Status of buttons %s is invalid. It must equal number of buttons as %s",
							buttonsStatus, numberOfButtons));
		}
	}

	private static void checkValidNumberOfButton(final int numberOfButtons) {
		if (numberOfButtons < 1 || numberOfButtons > 1000) {
			throw new RuntimeException(String.format(
					"Number of button %s is invalid. It must be at least 1 and less than 1000", numberOfButtons));
		}

	}

	private static List<Integer> convertStringToList(final String buttonStatusStr) {
		final String[] buttonStatusArr = buttonStatusStr.split(" ");
		return Arrays.asList(buttonStatusArr).stream().map(status -> Integer.parseInt(status))
				.collect(Collectors.toList());
	}

}
