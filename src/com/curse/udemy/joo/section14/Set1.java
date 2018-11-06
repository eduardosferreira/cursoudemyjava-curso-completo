package com.curse.udemy.joo.section14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.curse.udemy.joo.section14.model.entities.Product;
import com.curse.udemy.joo.section14.model.entities.Product2;
import com.curse.udemy.joo.section14.model.entities.Product3;

public class Set1 {

	private static void ex1() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("HashSet");
		Set<String> set = new HashSet<>();
		set.add("Tablet");
		set.add("TV");
		for (int i = 0; i < 20; i++) {
			set.add(String.valueOf(i));
		}
		set.add("Notebook");
		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
		System.out.println("--------------------------------");
	}

	private static void ex2() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("TreeSet");
		Set<String> set = new TreeSet<>();
		set.add("Tablet");
		set.add("TV");
		for (int i = 0; i < 20; i++) {
			set.add(String.valueOf(i));
		}
		set.add("Notebook");

		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
		System.out.println("--------------------------------");
	}

	private static void ex3() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("LinkedHashSet");
		Set<String> set = new LinkedHashSet<>();
		set.add("Tablet");
		set.add("TV");
		for (int i = 0; i < 20; i++) {
			set.add(String.valueOf(i));
		}
		set.add("Notebook");

		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
		System.out.println("--------------------------------");
	}

	private static void ex4() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("remove");
		Set<String> set = new LinkedHashSet<>();
		set.add("Tablet");
		set.add("TV");
		for (int i = 0; i < 20; i++) {
			set.add(String.valueOf(i));
		}
		set.add("Notebook");
		set.remove("TV");
		set.removeIf(x -> x.length() > 3);
		set.removeIf(x -> x.charAt(0) == '1');

		System.out.println(set.contains("Notebook"));
		for (String p : set) {
			System.out.println(p);
		}
		System.out.println("--------------------------------");
	}

	private static void ex5() {
		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
		// union
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println(c);
		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);
	}

	private static void ex6() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("EX6 - HashSet - Equals");
		Set<Product> set = new HashSet<>();
		set.add(new Product("TV", 900.0));
		set.add(new Product("Notebook", 1200.0));
		set.add(new Product("Tablet", 400.0));
		Product prod = new Product("Notebook", 1200.0);
		System.out.println(set.contains(prod));
		for (Product p : set) {
			System.out.println(p);
		}
		System.out.println("--------------------------------");

		Set<Product2> set2 = new HashSet<>();
		set2.add(new Product2("TV", 900.0));
		set2.add(new Product2("Notebook", 1200.0));
		set2.add(new Product2("Tablet", 400.0));
		Product2 prod2 = new Product2("Notebook", 1200.0);
		System.out.println(set2.contains(prod2));
		for (Product2 p : set2) {
			System.out.println(p);
		}

		System.out.println();
		System.out.println("--------------------------------");

	}

	private static void ex7() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("EX7");
		Set<Product3> set = new TreeSet<>();
		set.add(new Product3("Tv", 900.0));
		set.add(new Product3("Notebook", 1200.0));
		set.add(new Product3("Tablet", 400.0));
		for (Product3 p : set) {
			System.out.println(p);
		}
		System.out.println();
		System.out.println("--------------------------------");

	}

	public Set1() {
		Locale.setDefault(Locale.US);
	}

	public static void main(String[] args) {
		new Set1();
		/*
		 * ex1(); 
		 * ex2(); 
		 * ex3(); 
		 * ex4();
		 * ex5();
		 * ex6();
		 */
		ex7();
	}

	
}

