package com.curse.udemy.joo.section15;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import com.curse.udemy.joo.section15.model.entities.Product;
import com.curse.udemy.joo.section15.model.util.ProductConsumer;

public class Program5 {
	
	public Program5() {
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
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();

		System.out.println("+ 10%");
		list.forEach(new ProductConsumer());
		list.forEach(System.out::println);
		System.out.println();
		
		System.out.println("+ 15%");
		list.forEach(Product::staticProductConsumer);
		list.forEach(System.out::println);
		System.out.println();

		System.out.println("+ 20%");
		list.forEach(Product::nonStaticProductConsumer);
		list.forEach(System.out::println);
		System.out.println();
		
		Double percentage = 1d;
		System.out.println("+ 1%");
		Consumer<Product> consumerProduct = p -> {
			p.addPercentagePrice(percentage);
		};
		list.forEach(consumerProduct);
		list.forEach(System.out::println);
		System.out.println();
		
		System.out.println("+ 2%");
		Consumer<Product> consumerProduct2 = p -> {
			p.addPercentagePrice(2d);
		};
		list.forEach(consumerProduct2);
		list.forEach(System.out::println);
		System.out.println();
		

		System.out.println("+ 3%");
		Consumer<Product> consumerProduct3 = p -> p.addPercentagePrice(3d);
		list.forEach(consumerProduct3);
		list.forEach(System.out::println);
		System.out.println();
		

		System.out.println("+ 4%");
		list.forEach(p -> p.addPercentagePrice(4d));
		list.forEach(System.out::println);
		System.out.println();

		
	}
	
	public static void main(String[] args) {
		new Program5();
		ex1();
		
	}
}
