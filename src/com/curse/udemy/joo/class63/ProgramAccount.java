package com.curse.udemy.joo.class63;

import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.class63.entities.Account;
import com.curse.udemy.joo.class63.util.Utilites;

public class ProgramAccount {

	
	public ProgramAccount() {
		Locale.setDefault(Locale.US);
	}

	public static void main(String[] args) {
	
		new ProgramAccount();
		Account a;
		
		Integer number;
		String  holder;
		Double  value = 0d;		
		
		Scanner sc;
		Integer flag = 0;
		Character dep = 'S';
		
		System.out.println("******* Account **************** ");
		do {
			
			System.out.print("--------------------------- ");
			System.out.println("");
			sc = new Scanner(System.in);
			
			System.out.print("Enter account number: ");
			number = sc.nextInt();
			System.out.print("Enter account holder: ");
			sc.nextLine();
			holder = sc.nextLine();
			System.out.print("Is there na initial deposit (y/n)?: ");
			dep = sc.nextLine().trim().toUpperCase().charAt(0);
			if (dep=='Y') {
				System.out.print("Enter initial deposit value: ");
				value = sc.nextDouble();
				a = new Account(number, holder,value);
			} else { 
				value =0d;
				a = new Account(number, holder);
			}
			System.out.printf("\n" + a + "\n - 1 Dolar R$ : %.2f\n - Total (Dolar) R$: %.2f\n",
					           Utilites.MOEDA_DOLLAR,  Utilites.ConverterDollar(a.getValue()));
			System.out.println();
			System.out.print("Enter a deposit value: ");
			value = sc.nextDouble();
			a.deposit(value);
			System.out.println("UPDATE " + a);
			System.out.println();
			System.out.print("Enter a withdraw value: ");
			value = sc.nextDouble();
			a.withDra(value);
			System.out.println("UPDATE " + a);
			System.out.println("");
			try {
				System.out.print("Digite zero (0) para continuar: ");
				flag = sc.nextInt();
			} catch (Exception e) {
				flag = 1;
			}
			a = null;
		} while (flag.equals(0));
		
		System.out.println("\nFIM");
		sc.close();
		
	}
	
	
}
