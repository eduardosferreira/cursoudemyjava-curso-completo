package com.curse.udemy.joo.section15;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import com.curse.udemy.joo.section15.model.entities.Product;
import com.curse.udemy.joo.section15.model.util.ProductPredicate;

public class Program4 {
	
	public Program4() {
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
		
		System.out.println("Remove < 50");
		list.removeIf(x -> x.getPrice() < 50d);
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();

		System.out.println("Remove >= 100");
		list.removeIf(new ProductPredicate());
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();

		System.out.println("Remove >= 80");
		list.removeIf(Product::staticProductPredicate);
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();

		System.out.println("Remove >= 70");
		list.removeIf(Product::nonStaticProductPredicate);
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();

		System.out.println("Remove >= 67");
		Predicate<Product> predicateProduct = p -> p.getPrice() >= 67d;
		list.removeIf(predicateProduct);
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();

		double min66 = 66d;
		Predicate<Product> predicateProduct66 = p -> p.getPrice() >= min66;
		System.out.println("Remove >= 66");
		list.removeIf(predicateProduct66);
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();
		
		System.out.println("Remove >= 60");
		list.removeIf(p -> p.getPrice() >= 60);
		
		System.out.println();
		System.out.println("LIST");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		new Program4();
		ex1();
		
	}
}
