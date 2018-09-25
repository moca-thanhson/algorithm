package week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmbosserRotate {

	private static Map<Character, Integer> allCharacters = new HashMap<>();

	static {
		final String allLowerCase = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < allLowerCase.length(); i++) {
			allCharacters.put(allLowerCase.charAt(i),i);
		}
	}

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final String nameOfExhibits = scanner.nextLine();
		checkValidName(nameOfExhibits);
		
		System.out.println("All lower case");
		allCharacters.forEach((k,v) -> System.out.println(String.format("%s->%s", k,v)));
		
		final char[] charArrOfNameExhibit = nameOfExhibits.toCharArray();
		
		final int countMove = countMoveAndMoveBack(charArrOfNameExhibit);
	}

	private static int countMoveAndMoveBack(char[] charArrOfNameExhibit) {
		int initPosition = 0;
		for(char characterOfName : charArrOfNameExhibit) {
			int posOfCurrChar = allCharacters.get(characterOfName);
			if(Math.abs(posOfCurrChar - initPosition) > Math.abs(charArrOfNameExhibit.length - posOfCurrChar)) {
				
			}
		}
		
		return 0;
	}

	private static void checkValidName(String nameOfExhibits) {
		if (nameOfExhibits == null || nameOfExhibits.isEmpty()) {
			throw new RuntimeException(String.format("Name of exhibit %s must be not empty", nameOfExhibits));
		}
		if (nameOfExhibits.length() > 100) {
			throw new RuntimeException(String.format("Name of exhibit %s must be less than 100", nameOfExhibits));
		}
	}

}
