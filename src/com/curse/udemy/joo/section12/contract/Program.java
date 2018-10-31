package com.curse.udemy.joo.section12.contract;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section12.contract.model.entities.Contract;
import com.curse.udemy.joo.section12.contract.model.exception.DomainException;
import com.curse.udemy.joo.section12.contract.model.exception.DomainRunTimeException;
import com.curse.udemy.joo.section12.contract.model.services.ContractService;
import com.curse.udemy.joo.section12.contract.model.services.PaypalService;

public final class Program {

	
	private Program() {
		super();
		Locale.setDefault(Locale.US);
		System.out.println("Enter contract data");
	}
	
	public static void main(String[] args) {
		new Program();
		
		Long number;
		Date date;
		Double totalValue;
		Long months;
		Contract contract = null; 
		ContractService contractService = null;
		long error = 0;
		
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Number: ");
			number = sc.nextLong();
			sc.nextLine();
			System.out.print("Date (dd/MM/yyyy): ");
			date = Contract.sdf.parse(sc.nextLine().trim());
			System.out.print("Contract value: ");
			totalValue = sc.nextDouble();
			sc.nextLine();
			System.out.print("Enter number of installments: ");
			months = sc.nextLong();
			sc.nextLine();
			contract = new Contract(number, date, totalValue);
			contractService = new ContractService(new PaypalService());
			contractService.processContract(contract, months);
		} catch (ParseException|DomainRunTimeException|DomainException e) {
			System.err.println("ATTENTION " + " - >  " + e.getMessage());
			error = 1;
		} catch (Exception e) {
			e.printStackTrace();
			error = 1;
		}
			
		if (error > 0 ) 
			return;
		
		System.out.println(contract);
		System.out.println("*** END *** ");
		
	}
}
