package com.alex.algorithm.Session2.onClass;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class NumberUtil {

	public static List<Integer> convertByString(final String str) {
		return Arrays.asList(str.split(" ")).stream().map(interestStr -> Integer.valueOf(interestStr))
				.collect(Collectors.toList());
	}

}
