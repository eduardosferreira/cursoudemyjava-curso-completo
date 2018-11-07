package com.curse.udemy.joo.section15;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Program8 {
	
	public Program8() {
		Locale.setDefault(Locale.US);
	}
	
	public static void ex1() {
		System.out.println();
		List<Integer> list = Arrays.asList(3,4,11,5,33,6,7,8,80);
		Stream<Integer> st1 = list.stream();
		System.out.println(Arrays.toString(st1.toArray()));
	}

	public static void ex2() {
		System.out.println();
		List<Integer> list = Arrays.asList(3,4,11,5,33,6,7,8,80);
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		Stream<String> st2 = Stream.of("Maria","Eduardo","Jose","Marcelo");
		System.out.println(Arrays.toString(st2.toArray()));
		
		Stream<Integer> st3 = Stream.iterate(0, x -> x+10);
		System.out.println(Arrays.toString( st3.limit(50).toArray() ));
			
		
		Stream<Long> st4 = Stream.iterate(new Long[] {0l,1l}, f -> new Long[] {f[1], f[0]+f[1]}).map(f -> f[0]);
		System.out.println(Arrays.toString( st4.limit(50).toArray() ));
		
		
	}
	
	public static void main(String[] args) {
		new Program8();
		ex1();
		ex2();
		
	}
}
