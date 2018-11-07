package com.curse.udemy.joo.section15;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program9 {
	
	public Program9() {
		Locale.setDefault(Locale.US);
	}
	
	public static void ex1() {
		System.out.println();
		List<Integer> list = Arrays.asList(3,4,11,5,33,6,7,8,80);
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
	
		int sum = list.stream().reduce(0, (x,y) -> x+y);
		System.out.println("Total: " + sum);
		
		List<Integer> newList = list.stream()
								.filter(x -> x%2 == 0)
								.map(x -> x*10)
								.collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));
		newList.forEach(System.err::print);
	}

	public static void ex2() {
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Program9();
		ex1();
		ex2();
		
	}
}
