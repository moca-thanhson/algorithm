package com.alex.algorithm.Session09_MidTerm;

import java.util.*;

/**
 * 65 -> 90  : Ascii of uppercase
 * 97 -> 122 : Ascii of lowercase
 * <p>
 * Sample 1: <br/>
 * <p>
 * 12
 * toosmallword
 * NO
 * <p>
 * Sample 2: <br/>
 * 35
 * TheQuickBrownFoxJumpsOverTheLazyDog
 * YES
 */
public class Pangram {

    private static final int NUMBER_OF_LATIN_CHARS = 26;

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numOfChars = Integer.valueOf(scanner.nextLine());
        if (numOfChars < 26) {
            System.out.print("NO");
            return;
        }

        final String str = scanner.nextLine();
        final List<Character> uniqueChars = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            final char currChar = str.charAt(i);
            if (Character.isLetter(currChar)) {
                if (!uniqueChars.contains(Character.toLowerCase(currChar))) {
                    uniqueChars.add(Character.toLowerCase(currChar));
                }
            }
        }

        if (uniqueChars.size() == NUMBER_OF_LATIN_CHARS) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

    }
}
