package com.curse.udemy.joo.classAll;

import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.classAll.util.CurrencyConverter;

public class ExercicioFixacaoMembrosEstaticos {

	public static final Double PI = 3.14d;
	
	public ExercicioFixacaoMembrosEstaticos() {
		super();
		Locale.setDefault(Locale.US);
		System.out.println("*****EXERCICIO*****");
	}
	
	public static void main(String[] args) {
		new ExercicioFixacaoMembrosEstaticos();
		
		Integer flag = 0;
		Double value, converter;
		Long quantity=(long) 0;
		
		do {
			System.out.print("--------------------------- ");
			System.out.println();			
			CurrencyConverter.sc = new Scanner(System.in);
			System.out.println("Entre com os valores:");
			System.out.print(" Quanto que vale um dollar em Real (não utilize \",\"): ");
			converter = CurrencyConverter.sc.nextDouble();
			System.out.print("\n Quantidade: ");
			quantity = CurrencyConverter.sc.nextLong();
			value = quantity*CurrencyConverter.MOEDA_EUROS;
						
			System.out.println("Um EURO, equivale a " + String.format("%.2f", CurrencyConverter.MOEDA_EUROS) + ". Com a quantidade " + quantity + ", daria um total de " + String.format("%.2f", value) );
			System.out.printf("O valor total em reais seria %.2f\n" , CurrencyConverter.ConverterDollar(quantity, converter) );
			
			System.out.println();
			System.out.print("Digite zero (0) para continuar: ");
			try {
				flag = CurrencyConverter.sc.nextInt();
			} catch (Exception e) {
				flag = 1;
			}
			CurrencyConverter.sc.close();
			
		} while (flag.equals(0));
		
		System.out.println("\nFIM");
		
	}
	

}
