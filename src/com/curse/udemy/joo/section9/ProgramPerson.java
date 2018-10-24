package com.curse.udemy.joo.section9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section9.entities.Person;
import com.curse.udemy.joo.section9.entities.LegalPerson;
import com.curse.udemy.joo.section9.entities.PhysicalPerson;

public final class ProgramPerson {

	private ProgramPerson() {
		Locale.setDefault(Locale.US);
	}
	
	private static void Ex1() throws Exception {
		new ProgramPerson();
		Scanner sc;
		
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Person> list = new ArrayList<>();
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Person person;
				System.out.println("Person #" + i + " data:");
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Annual Income: ");
				Double annualIncome = sc.nextDouble();
				sc.nextLine();
				System.out.print("Physical Person or Legal person (P/L)?: ");
				Character alternative = sc.nextLine().trim().toUpperCase().charAt(0); 
				switch (alternative) {
					case 'L':
						System.out.print("Number Of Employees: ");
						Long numberOfEmployees = sc.nextLong();
						sc.nextLine();
						person = new LegalPerson(name, annualIncome, numberOfEmployees);
						break;
					default:
						System.out.print("Spending On Health: ");
						Double spendingOnHealth = sc.nextDouble();
						sc.nextLine();
						person = new PhysicalPerson(name, annualIncome, spendingOnHealth);
						break;
				}
				list.add(person);
				
				System.out.println();
			}
			
			System.out.println("TAXES PAID:");
			Double sum=0d;
			for (Person e : list) {
				System.out.println(e);
				sum += e.taxAmount();
			}
			System.out.println("TOTAL TAXES: " + String.format("%.2f", sum));
				
			try {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}
			System.out.println();
			sc.close();
		} while (continueLoop.equals(0));
		System.out.println();
		System.out.println("END");
		
	}
	
	public static void main(String[] args) throws Exception {
		Ex1();
		
	}

	
	
}
