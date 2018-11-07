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

import com.curse.udemy.joo.section15.model.entities.Employee;

public class Program202 {

	public Program202() {
		Locale.setDefault(Locale.US);
	}

	private static void ex1() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		String line = "";
		Set<Employee> listHashSet = new HashSet<>();
		Set<Employee> listTreeSet = new TreeSet<>();
		Set<Employee> listLinkedHashSet = new LinkedHashSet<>();
		List<Employee> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			do {
				line = br.readLine();
				if (line != null && !line.trim().equals("")) {
					String[] fields = line.split(",");
					listHashSet.add(new Employee(fields[0].trim().toUpperCase(),fields[1].trim().toLowerCase(),
							Double.parseDouble(fields[2].trim().toUpperCase())));
					listTreeSet.add(new Employee(fields[0].trim().toUpperCase(),fields[1].trim().toLowerCase(),
							Double.parseDouble(fields[2].trim().toUpperCase())));
					listLinkedHashSet.add(new Employee(fields[0].trim().toUpperCase(),fields[1].trim().toLowerCase(),
							Double.parseDouble(fields[2].trim().toUpperCase())));
					list.add(new Employee(fields[0].trim().toUpperCase(),fields[1].trim().toLowerCase(),
							Double.parseDouble(fields[2].trim().toUpperCase())));
				}
			} while (line != null && !line.trim().equals(""));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found!  " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		double avg = 0d; // media
		double tot = 0d; // media
		avg = list.stream().map(x -> x.getSalary()).reduce(0d, (x, y) -> x + y) / list.size();
		tot = list.stream().map(x -> x.getSalary()).reduce(0d, (x, y) -> x + y);

		System.out.println("---------ArrayList -----------------");
		for (Employee employee : list) {
			System.out.println(employee);
		}
		System.out.println("Total Element: " + list.size());
		System.out.println("Total        : " + String.format("%.2f", tot));
		System.out.println("Average      : " + String.format("%.2f", avg));

			
		Comparator<Employee> comparator = (o1, o2) -> {
			return o1.getEmail().trim().compareToIgnoreCase(o2.getEmail().trim());
		};
		
		System.out.println();
		System.out.print("Enter salary: ");
		double salaryFinal = sc.nextDouble();
		sc.nextLine();
		System.out.printf("Email of people whose salary is more than %.2f:\n", salaryFinal);
		List<String> listString = list.stream().filter(x -> x.getSalary() > salaryFinal).sorted(comparator.reversed())
				.map(x -> x.getEmail()).collect(Collectors.toList());
		listString.forEach(System.out::println);
		avg = list.stream().filter(x -> x.getSalary() > salaryFinal).map(x -> x.getSalary()).reduce(0d, (x, y) -> x + y) / listString.size();
		tot = list.stream().filter(x -> x.getSalary() > salaryFinal).map(x -> x.getSalary()).reduce(0d, (x, y) -> x + y);
		System.out.println("Total Element: " + listString.size());
		System.out.println("Total        : " + String.format("%.2f", tot));
		System.out.println("Average      : " + String.format("%.2f", avg));

		System.out.println();
		System.out.print("Enter starts with: ");
		Character character = sc.nextLine().trim().toUpperCase().charAt(0); 
		System.out.printf("List of people whose name starts with %s:\n",character);
		List<Employee> list2 = list.stream().filter(x -> x.getName().trim().toUpperCase().charAt(0) == character)
				.sorted((o1, o2) -> o1.getName().trim().compareToIgnoreCase(o2.getName().trim()))
				.collect(Collectors.toList());
		list2.forEach(System.out::println);
		avg = list2.stream().map(x -> x.getSalary()).reduce(0d, (x, y) -> x + y) / list2.size();
		tot = list2.stream().map(x -> x.getSalary()).reduce(0d, (x, y) -> x + y);
		System.out.println("Total Element: " + listString.size());
		System.out.println("Total        : " + String.format("%.2f", tot));
		System.out.println("Average      : " + String.format("%.2f", avg));

		
		System.out.println("----------------------------------------");

		System.out.println("---------HashSet -----------------");
		for (Employee employee : listHashSet) {
			System.out.println(employee);
		}
		System.out.println("Total Element: " + listHashSet.size());
		System.out.println("----------------------------------------");

		System.out.println("---------TreeSet -----------------");
		for (Employee employee : listTreeSet) {
			System.out.println(employee);
		}
		System.out.println("Total Element: " + listTreeSet.size());
		System.out.println("----------------------------------------");

		System.out.println("---------LinkedHashSet -----------------");
		for (Employee employee : listLinkedHashSet) {
			System.out.println(employee);
		}
		System.out.println("Total Element: " + listLinkedHashSet.size());
		System.out.println("----------------------------------------");

		sc.close();
		System.out.println("--- end ---");

	}

	public static void main(String[] args) {
		new Program202();
		ex1();

	}
}
