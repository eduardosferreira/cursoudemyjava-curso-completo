package com.curse.udemy.joo.section15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.curse.udemy.joo.section15.model.entities.MyComparator;
import com.curse.udemy.joo.section15.model.entities.Product;

public class Program1 {

	public Program1() {
		Locale.setDefault(Locale.US);
	}

	public static void ex1() {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1l, "TV", 900.11d));
		list.add(new Product(2l, "Tablet", 1000.201d));
		list.add(new Product(3l, "IPhone", 1200.000d));
		list.add(new Product(4l, "Mouse", 14.000d));
		list.add(new Product(5l, "Notebook", 1800.000d));

		list.sort(new MyComparator());
		System.out.println();
		System.out.println("LIST<<name>>:");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("");

		Comparator<Product> comparator1 = new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getId().compareTo(o2.getId());
			}
		};

		list.sort(comparator1);
		System.out.println();
		System.out.println("LIST<<id>>:");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("");

		Comparator<Product> comparator2 = (o1, o2) -> {
			return o1.getPrice().compareTo(o2.getPrice());
		};

		list.sort(comparator2);
		System.out.println();
		System.out.println("LIST<<price>>:");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("");

		Comparator<Product> comparator3 = (Product o1, Product o2) -> {
			return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
		};

		list.sort(comparator3);
		System.out.println();
		System.out.println("LIST<<name>>:");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("");

		Comparator<Product> comparator4 = (o1, o2) -> o1.getPrice().compareTo(o2.getPrice());
		list.sort(comparator4);
		System.out.println();
		System.out.println("LIST<<price>>:");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("");

		list.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
		System.out.println();
		System.out.println("LIST<<id>>:");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("");
		
		System.out.println("END");
	}

	public static void main(String[] args) {
		new Program1();
		ex1();

	}

}
