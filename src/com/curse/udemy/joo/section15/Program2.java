package com.curse.udemy.joo.section15;

import java.util.Arrays;
import java.util.Locale;

public class Program2 {

	public Program2() {
		Locale.setDefault(Locale.US);
	}

	public static int globalValue = 3;

	public static void main(String[] args) {
		int[] vect = new int[] { 3, 4, 5 };
		changeOddValues(vect);
		System.out.println(Arrays.toString(vect));
	}

	public static void changeOddValues(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 != 0) {
				numbers[i] += globalValue;
			}
		}
	}

}
