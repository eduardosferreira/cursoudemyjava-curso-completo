package com.curse.udemy.joo.classAll;

import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.classAll.entities.Student;

public class ProgramClass71ExercicioFixacaoVetores {

	/*
	 *
Exercício de fixação
http://educandoweb.com.br
Prof. Dr. Nelio Alves
A dona de um pensionato possui dez quartos para alugar para estudantes,
sendo esses quartos identificados pelos números 0 a 9.
Fazer um programa que inicie com todos os dez quartos vazios, e depois
leia uma quantidade N representando o número de estudantes que vão
alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
N estudantes. Para cada registro de aluguel, informar o nome e email do
estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
um relatório de todas ocupações do pensionato, por ordem de quarto,
conforme exemplo. 
	 */
	
	public ProgramClass71ExercicioFixacaoVetores() {
		Locale.setDefault(new Locale ("pt", "BR"));
		System.out.println("******** SISTEMA ALUGUEL DE QUARTOS ********");
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Entre com a quantidade de quartos : ");
		int q = sc.nextInt();
		sc.nextLine();

		System.out.print("Entre com a quantidade de reservas realidas : ");
		int n = sc.nextInt();
		sc.nextLine();

		Student[] vet = new Student[q];

		String name, email;
		int    quarto=0;
		
		for (int i = 0; i < n; i++) {
			System.out.print("* Entre com o(s) valor(s) do(s) hóspede(s) [ " + (i+1) + " ]\n Nome: ");
			name = sc.nextLine();
			System.out.print(" Email: " );
			email = sc.nextLine();
			System.out.print(" Numero do Quarto Reservado: ");
			quarto = sc.nextInt();
			sc.nextLine();
			System.out.println();
			vet[quarto] = new Student(name,email);
		}
		for (int i = 0; i < vet.length; i++) {
			if (!(vet[i]== null)) {
				System.out.println("- Reservas do Quarto [ " + i + " ]: " + vet[i]);
			} 
		}
		sc.close();
		
	}

}
