package com.curse.udemy.joo.classAll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.classAll.entities.Employee;;

public class ProgramClass76ExercicioFixacaoListas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	private static void printListemployee(List<Employee> employee) {
		System.out.println();
		System.out.println("************** List of Employees *****************");
		for (Employee e : employee) {
			System.out.println(e);
		}
		System.out.println("*******************************");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		List<Employee> employeeList = new ArrayList<>();
		Long idEmployee;
		String nameEmployee;
		Double salaryEmployee;
		Double percentage = 0d;
		System.out.println("******Employees******");
		System.out.print("How many employees will be registered? : ");
		int n = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= n; i++) {
			System.out.println("employee #" + i + ": ");
			System.out.print("Id: ");
			idEmployee = in.nextLong();
			in.nextLine();
			System.out.print("Name: ");
			nameEmployee = in.nextLine();
			System.out.print("Salary $: ");
			salaryEmployee = in.nextDouble();
			in.nextLine();
			employeeList.add(new Employee(idEmployee, nameEmployee, salaryEmployee));
		}
		printListemployee(employeeList);
		System.out.print("Enter the employee id that will have salary increase: ");
		final Long id  = in.nextLong();
		in.nextLine();
		Employee e = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (!(e==null)) {
			int index = employeeList.indexOf(e);
			employeeList.remove(e);
			System.out.print("Enter the percentage: ");
			percentage = in.nextDouble();
			e.increaseSalary(percentage);
			System.out.println("Change: " + e);
			employeeList.add(index, e);
		} else {
			System.out.println("Not Found : Employee");
		}
		
		printListemployee(employeeList);
		System.out.println();
		System.out.println("END");
		in.close();
	}

	
	
}
