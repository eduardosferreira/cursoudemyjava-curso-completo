package com.curse.udemy.joo.classAll;

import java.util.Locale;
import java.util.Scanner;

public class ProgramClass69VetoresParte1 {

	public static void main(String[] args) {

		Locale.setDefault(new Locale ("pt", "BR"));
		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com o tamanho do vetor: ");
		int n = sc.nextInt();
		sc.nextLine();
		double[] vet = new double[n];
		double sum = 0;
		for (int i = 0; i < n; i++) {
			System.out.print("Entre com o valor do vetor [ " + i + " ]: ");
			vet[i] = sc.nextDouble();
			sc.nextLine();
		}
		for (int i = 0; i < vet.length; i++) {
			System.out.println(" valor do vetor [ " + i + " ]: " + vet[i]);
			sum += vet[i];
		}
		System.out.println("soma: " + sum);
		System.out.println("media: " + ((double) (sum/n)));
		
		sc.close();
		
	}

}
