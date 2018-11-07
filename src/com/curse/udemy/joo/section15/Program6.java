package com.curse.udemy.joo.section15;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.curse.udemy.joo.section15.model.entities.Product;
import com.curse.udemy.joo.section15.model.util.ProductFunction;
import com.curse.udemy.joo.section15.model.util.ProductNameFunction;

public class Program6 {
	
	public Program6() {
		Locale.setDefault(Locale.US);
	}
	
	public static void ex1() {
		List<Product> list = new ArrayList<>();
		System.out.println("ADD LIST");
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("Hd Case", 80.90));
		list.add(new Product("Monitor", 1900.00));
		list.add(new Product("Smartfone", 510.00));
		list.add(new Product("Teclado", 10.50));
		list.add(new Product("Hd", 180.92));
		list.add(new Product("Mouse 1", 60.00));
		list.add(new Product("Mouse 2", 70.00));
		list.add(new Product("Mouse 66", 66.00));
		list.add(new Product("Mouse 67", 67.00));
		System.out.println();
		

		System.out.println();
		list.forEach(System.out::println);
		System.out.println();

		
		System.out.println("*********Ex1 - NAMES **************");
		List<String> names1 = list.stream().map(new ProductNameFunction()).collect(Collectors.toList());
		names1.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*********Ex1 - PRODUCT **************");
		List<Product> productFunction1 = list.stream().map(new ProductFunction()).collect(Collectors.toList());
		productFunction1.forEach(System.out::println);
		System.out.println();
		

		System.out.println("*********Ex2 - NAMES **************");
		List<String> names2 = list.stream().map(Product::staticProductNameFunction).collect(Collectors.toList());
		names2.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*********Ex2 - PRODUCT **************");
		List<Product> productFunction2 = list.stream().map(Product::staticProductFunction).collect(Collectors.toList());
		productFunction2.forEach(System.out::println);
		System.out.println();
		

		System.out.println("*********Ex3 - NAMES **************");
		List<String> names3 = list.stream().map(Product::nonStaticProductNameFunction).collect(Collectors.toList());
		names3.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*********Ex3 - PRODUCT **************");
		List<Product> productFunction3 = list.stream().map(Product::nonStaticProductFunction).collect(Collectors.toList());
		productFunction3.forEach(System.out::println);
		System.out.println();
	
		System.out.println("*********Ex4 - NAMES **************");
		Function<Product, String> productNameFunction11 = t -> {
			return t.getName().toUpperCase().trim();
		};
		List<String> names4 = list.stream().map(productNameFunction11).collect(Collectors.toList());
		names4.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*********Ex4 - PRODUCT **************");
		Function<Product, Product> productFunction11 = t -> {
			return new Product(t.getName().trim().toUpperCase(), t.getPrice() - ((t.getPrice()*10d/100d)));
		};
		List<Product> productFunction4 = list.stream().map(productFunction11).collect(Collectors.toList());
		productFunction4.forEach(System.out::println);
		System.out.println();

		System.out.println("*********Ex41 - NAMES **************");
		Function<Product, String> productNameFunction111 = t -> t.getName().toUpperCase().trim();
		List<String> names41 = list.stream().map(productNameFunction111).collect(Collectors.toList());
		names41.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*********Ex41 - PRODUCT **************");
		Function<Product, Product> productFunction111 = t -> new Product(t.getName().trim().toUpperCase(), t.getPrice() - ((t.getPrice()*10d/100d)));
		List<Product> productFunction41 = list.stream().map(productFunction111).collect(Collectors.toList());
		productFunction41.forEach(System.out::println);
		System.out.println();

		
		
		
		System.out.println("*********Ex5 - NAMES **************");
		List<String> names5 = list.stream().map(t -> t.getName().toUpperCase().trim()).collect(Collectors.toList());
		names5.forEach(System.out::println);
		System.out.println();
		
		System.out.println("*********Ex5 - PRODUCT **************");
		List<Product> productFunction51 = list.stream().map( t -> new Product(t.getName().trim().toUpperCase(), t.getPrice() - ((t.getPrice()*10d/100d)))  ).collect(Collectors.toList());
		productFunction51.forEach(System.out::println);
		System.out.println();
		
		
	}
	
	public static void main(String[] args) {
		new Program6();
		ex1();
		
	}
}
