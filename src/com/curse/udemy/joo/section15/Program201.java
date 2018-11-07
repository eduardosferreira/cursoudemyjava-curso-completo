package com.curse.udemy.joo.section15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.curse.udemy.joo.section15.model.entities.Product;

public class Program201 {

	public Program201() {
		Locale.setDefault(Locale.US);
	}

	private static void ex1() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		String line = "";
		Set<Product> listHashSet = new HashSet<>();
		Set<Product> listTreeSet = new TreeSet<>();
		Set<Product> listLinkedHashSet = new LinkedHashSet<>();
		List<Product> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			do {
				line = br.readLine();
				if (line != null && !line.trim().equals("")) {
					String[] fields = line.split(",");
					listHashSet.add(new Product(fields[0].trim().toUpperCase(),
							Double.parseDouble(fields[1].trim().toUpperCase())));
					listTreeSet.add(new Product(fields[0].trim().toUpperCase(),
							Double.parseDouble(fields[1].trim().toUpperCase())));
					listLinkedHashSet.add(new Product(fields[0].trim().toUpperCase(),
							Double.parseDouble(fields[1].trim().toUpperCase())));
					list.add(new Product(fields[0].trim().toUpperCase(),
							Double.parseDouble(fields[1].trim().toUpperCase())));
				}
			} while (line != null && !line.trim().equals(""));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found!  " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();

		double avg = 0d; // media
		double tot = 0d; // media
		avg = list.stream().map(x -> x.getPrice()).reduce(0d, (x, y) -> x + y) / list.size();
		tot = list.stream().map(x -> x.getPrice()).reduce(0d, (x, y) -> x + y);

		System.out.println("---------ArrayList -----------------");
		for (Product product : list) {
			System.out.println(product);
		}
		System.out.println("Total Element: " + list.size());
		System.out.println("Total        : " + String.format("%.2f", tot));
		System.out.println("Average      : " + String.format("%.2f", avg));

		Comparator<Product> comparator = (o1, o2) -> {
			return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
		};

		double avgFinal = avg;
		System.out.println("Print names products:");
		List<String> namesProducts = list.stream().filter(x -> x.getPrice() < avgFinal).sorted(comparator)
				.map(x -> x.getName()).collect(Collectors.toList());
		namesProducts.forEach(System.out::println);

		System.out.println("----------------------------------------");

		System.out.println("---------HashSet -----------------");
		for (Product product : listHashSet) {
			System.out.println(product);
		}
		System.out.println("Total Element: " + listHashSet.size());
		System.out.println("----------------------------------------");

		System.out.println("---------TreeSet -----------------");
		for (Product product : listTreeSet) {
			System.out.println(product);
		}
		System.out.println("Total Element: " + listTreeSet.size());
		System.out.println("----------------------------------------");

		System.out.println("---------LinkedHashSet -----------------");
		for (Product product : listLinkedHashSet) {
			System.out.println(product);
		}
		System.out.println("Total Element: " + listLinkedHashSet.size());
		System.out.println("----------------------------------------");

		System.out.println("--- end ---");

	}

	public static void main(String[] args) {
		new Program201();
		ex1();

	}
}
