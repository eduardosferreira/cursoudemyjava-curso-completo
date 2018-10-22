package com.curse.udemy.joo.section8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section8.entities.Department;
import com.curse.udemy.joo.section8.entities.HourContract;
import com.curse.udemy.joo.section8.entities.Worker;
import com.curse.udemy.joo.section8.entities.enums.WorkerLevel;

public class Program {
	
	private Program() {
		Locale.setDefault(Locale.US);
		System.out.println("Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar\r\n" + 
				"do usuário um mês e mostrar qual foi o salário do funcionário nesse mês");
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Program();
		SimpleDateFormat sdf;
		Scanner in;
		
		Worker worker;
		String name;
		Long level;
		Double baseSalary;
		String department;
		
		String data;
		Date date = new Date();
		Double valuePerHour = 0d;
		Integer hours = 0;
		
		Integer c = 0;
		Integer q = 0;
		do {
			System.out.println("-----------------------------------------");
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			in = new Scanner(System.in);
			System.out.print("Enter department's name: ");
			department = in.nextLine();
			System.out.println();
			System.out.println("Enter worker data:");
			System.out.print("Name: ");
			name = in.nextLine();
			System.out.print("Number Level " + 
			        		 "\n[ 1 - JUNIOR " + 
			        		 "\n  2 - MID_LEVEL " + 
					         "\n  3 - SENIOR ]: ");
			level = in.nextLong();
			in.nextLine();
			System.out.print("Base salary [US] $: ");
			baseSalary = in.nextDouble();
			in.nextLine();
	
			
			worker = new Worker(name, WorkerLevel.toEnum(level) , baseSalary, new Department(department));
			System.out.print("How many contracts to this worker? ");
			q = in.nextInt();
			in.nextLine();
			
			for (int i = 1; i <= q; i++) {
				System.out.println("Enter contract #" + i +" data:");
				System.out.print("Date (DD/MM/YYYY): ");
				data = in.nextLine();
				try {
					date = sdf.parse(data);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print("Value (US $) per hour: ");
				valuePerHour = in.nextDouble();
				in.nextLine();
				System.out.print("Duration (hours): ");
				hours = in.nextInt();
				in.nextLine();
				worker.addContract(new HourContract(date, valuePerHour, hours));
			}
			System.out.println();
			System.out.println("");
			System.out.print("Enter month and year to calculate income (MM/YYYY): ");
			data = in.nextLine().trim();
			System.out.println(worker  
							   + "\n Income for " + data + " : " + worker.income(Integer.parseInt(data.substring(3,7)) ,Integer.parseInt(data.substring(0, 2)) ) 
							   + "\n Income for Year " + data.substring(3,7) + " : " + worker.incomeFilterYear(data.substring(3,7) ) 
							   + "\n Income for Year " + data.substring(3,7) + " and Month " + data.substring(0, 2) +  " : " + worker.incomeFilterYearMonth(data.substring(3,7),data.substring(0, 2) ) 
							   + "");
			//worker.income(data.substring(3,7));
			System.out.println();
			try {
				System.out.print("Enter zero (0) to continue: ");
				c = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				c = 1;
			}
		
			in.close();
		} while (c.equals(0));

		System.out.println("END");
	}
	
	

}
