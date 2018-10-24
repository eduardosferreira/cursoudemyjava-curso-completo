package com.curse.udemy.joo.section9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section9.entities.Employee;
import com.curse.udemy.joo.section9.entities.OutsourcedEmployee;

public final class ProgramEmployee {

	private ProgramEmployee() {
		Locale.setDefault(Locale.US);
	}
	
	private static void Ex1() {
		new ProgramEmployee();
		Scanner sc;
		
		Integer continueLoop = 0;
		Integer quantityEmployee =0;
		List<Employee> listEmployee = new ArrayList<>();
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter the number of employees: ");
			quantityEmployee = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityEmployee; i++) {
				
				Employee employee;
				System.out.print("Employee #" + i + " data:");
				System.out.print("Name: ");
				String  name = sc.nextLine();
				
				System.out.print("Hours: ");
				Integer hours = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Value per hour: ");
				Double  valuePerHour = sc.nextDouble();				
				sc.nextLine();
				
				System.out.print("Outsourced (y/n)?: ");
				Character outsourced = sc.nextLine().trim().toUpperCase().charAt(0); 
				if (outsourced.equals('Y')) {
					System.out.print("Additional charge: ");
					Double additionalCharge = sc.nextDouble();
					sc.nextLine();
					employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				} else {
					employee = new Employee(name, hours, valuePerHour);
				}
				listEmployee.add(employee);
				
				System.out.println();
			}
			
			System.out.println("PAYMENTS:");
			for (Employee e : listEmployee) {
				System.out.println(e);
			}
			
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
	
	public static void main(String[] args) {
		Ex1();
		
	}

	
	
}
