package com.curse.udemy.joo.section10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section10.model.entities.Account;
import com.curse.udemy.joo.section10.model.exception.DomainAccountException;
import com.curse.udemy.joo.section10.model.exception.DomainAccountRunTimeException;

public class ProgramAccount {

	
	public ProgramAccount() {
		super();
		Locale.setDefault(Locale.US);
		System.out.println("Account");
	}
	
	public static void main(String[] args) {
		new ProgramAccount();
		Scanner sc = new Scanner(System.in);
		List<Account> list = new ArrayList<>();
		Integer quantityList = 0;
		Integer continueLoop = 0;
		String alternative;
		int    count;		
			
		do {
				
			list.clear();
			try {					
				System.out.print("Enter the number of element: ");
				quantityList = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Number Invalid: " + e.getMessage());
				quantityList = 0;
				sc.nextLine();
			}
			System.out.println();
			
			for (int i = 1; i <= quantityList; i++) {
				
				Integer number;
				String  holder;
				Double  balance;
				Double  withDrawLimit;
				Double  amount;
				Account account = null;
				
				do {
					
					System.out.println("Account #" + i + " data ");
					count = 0;
					
					try {
						
						System.out.print("Number: ");
						number = sc.nextInt();
						sc.nextLine();

						System.out.print("Holder: ");
						holder = sc.nextLine();
						
						System.out.print("Initial balance: ");
						balance = sc.nextDouble();
						sc.nextLine();

						System.out.print("Withdraw limit: ");
						withDrawLimit = sc.nextDouble();
						sc.nextLine();
						
						account = new Account(number, holder, balance, withDrawLimit);
						System.out.println();
						count=1;
	
						System.out.print("\nDo you want to deposit? (Y/N): ");
						alternative = sc.nextLine();
						if (alternative.trim().toUpperCase().charAt(0) == 'Y') {
							System.out.print("Enter amount for deposit: ");
							amount = sc.nextDouble();
							sc.nextLine();
							account.deposit(amount);
						}
						
						System.out.print("\nDo you want to withdraw? (Y/N): ");
						alternative = sc.nextLine();
						if (alternative.trim().toUpperCase().charAt(0) == 'Y') {
							System.out.print("Enter amount for withdraw: ");
							amount = sc.nextDouble();
							sc.nextLine();
							account.withDraw(amount);
						}			
							
					} catch (DomainAccountException e) {
						System.out.println("Attention  -> " + e.getMessage());
					} catch (DomainAccountRunTimeException e) {
						System.out.println("Attention  -> " + e.getMessage());
					} catch (Exception e) {
						System.out.println("Invalid: " + e.getMessage());
						sc.nextLine();
					}
					
					System.out.print("\nRepeat or Continue (confirm) ? \nR to Repeat or any key to continue : ");
					alternative = sc.nextLine();
					if ((count == 1) && (!(alternative.trim().toUpperCase().charAt(0) == 'R')) ) {
						System.out.println(account);
						list.add(account);
					}
					System.out.println();
					
				} while (alternative.trim().toUpperCase().charAt(0) == 'R');
				
			}

			System.out.println("\nLIST:");
			for (Account listAux : list) {
				System.out.println(listAux);
			}
			
			try  {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}				

			System.out.println();
				
		} while (continueLoop.equals(0));
			
		
		sc.close();		
		System.out.println("\nEND");
	
	}

	
	
}
