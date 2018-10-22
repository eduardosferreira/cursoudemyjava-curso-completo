package com.curse.udemy.joo.classAll;

import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.classAll.entities.Product;

public class ProgramClass70VetoresParte2 {

	public static void main(String[] args) {

		Locale.setDefault(new Locale ("pt", "BR"));
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com o tamanho do vetor: ");
		int n = sc.nextInt();
		
		String name;
		Double price;
		Long   quantity=0l;

		
		sc.nextLine();
		Product[] vet = new Product[n];
		double sum = 0d;
		long   tot = 0l;
		for (int i = 0; i < vet.length; i++) {
			System.out.print("* Entre com o valor do vetor [ " + i + " ]\n Nome: ");
			name = sc.nextLine();
			System.out.print(" Preço: " );
			price = sc.nextDouble();
			sc.nextLine();
			System.out.print(" Quantidade: " );
			quantity = sc.nextLong();
			sc.nextLine();
			System.out.println();
			vet[i] = new Product(name,price,quantity);
		}
		for (int i = 0; i < vet.length; i++) {
			System.out.println("- Vetor [ " + i + " ]: " + vet[i]);
			sum += vet[i].getPrice();
			tot += vet[i].getQuantity();
		}
		System.out.println("soma preco: " + sum);
		System.out.println("soma quantidade: " + tot);
		System.out.println("media preco: " + ((double) (sum/n)));
		System.out.println("media quantidade: " + ((double) (tot/n)));
		
		sc.close();
		
	}

}
