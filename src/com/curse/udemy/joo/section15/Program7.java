package com.curse.udemy.joo.section15;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.curse.udemy.joo.section15.model.entities.Product;
import com.curse.udemy.joo.section15.model.services.ProductService;

public class Program7 {
	
	public Program7() {
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

		
		System.out.println("*********Ex1 **************");
		System.out.println();
		ProductService ps = new ProductService();
		Double sum = ps.filteredSum(list);
		System.out.println("Total <T>: " + String.format("%.2f", sum));
		Double sum1 = ps.filteredSum(list,product -> product.getName().trim().toUpperCase().charAt(0) == 'T');
		System.out.println("Total 1 <T>: " + String.format("%.2f", sum1));
		Double sum2 = ps.filteredSum(list,product -> product.getName().trim().toUpperCase().charAt(0) == 'M');
		System.out.println("Total 2 <M>: " + String.format("%.2f", sum2));
		Double sum3 = ps.filteredSum(list,product -> product.getPrice() < 100D);
		System.out.println("Total 3 : " + String.format("%.2f", sum3));

		
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Program7();
		ex1();
		
	}
}
