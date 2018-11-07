package com.curse.udemy.joo.section15;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.curse.udemy.joo.section15.model.entities.Product;

public class Program {
	
	public Program() {
		Locale.setDefault(Locale.US);
	}
	
	public static void ex1() {
		List<Product> list = new ArrayList<>();
		System.out.println("ADD LIST");
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		list.add(new Product("Monitor", 1900.00));
		list.add(new Product("Smartfone", 510.00));
		list.add(new Product("Teclado", 10.50));
		list.add(new Product("HD", 180.92));
		list.add(new Product("Mouse 1", 60.00));
		list.add(new Product("Mouse 2", 70.00));
		list.add(new Product("Mouse 66", 66.00));
		list.add(new Product("Mouse 67", 67.00));
		System.out.println();
		

		System.out.println();
		list.forEach(System.out::println);
		System.out.println();

		
		System.out.println("*********Ex1 **************");
		System.out.println();

	
	}
	
	public static void main(String[] args) {
		new Program();
		ex1();
		
	}
}
