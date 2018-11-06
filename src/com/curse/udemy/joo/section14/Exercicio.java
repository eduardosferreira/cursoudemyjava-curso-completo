package com.curse.udemy.joo.section14;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/*
Exercício proposto (Set)
http://educandoweb.com.br
Prof. Dr. Nelio Alves
Em um portal de cursos online, cada usuário possui um código único, representado por
um número inteiro.
Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se
matricular em quantos cursos quiser. Assim, o número total de alunos de um instrutor não
é simplesmente a soma dos alunos de todos os cursos que ele possui, pois pode haver
alunos repetidos em mais de um curso.
O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
quantidade total e alunos dele, conforme exemplo.
https://github.com/acenelio/set2-java
How many students for course A? 3
21
35
22
How many students for course B? 2
21
50
How many students for course C? 3
42
35
13
Total students: 6
*/
public class Exercicio {

	public Exercicio() {
		Locale.setDefault(Locale.US);
	}
	
	public static void main(String[] args) {
		new Exercicio();
		Scanner sc = new Scanner(System.in);
		Set<Long> studentSet = new HashSet<>();
		for (char i = 'A'; i <= 'C'; i++) {
			System.out.print("How many students for course " + i + " ? ");
			int quantity = sc.nextInt();
			sc.nextLine();
			for (int j = 1; j <= quantity; j++) {
				System.out.print("Enter number, Student [" + j + "] course " + i + " : ");
				studentSet.add(sc.nextLong());
				sc.nextLine();
			}
		}
		System.out.println();
		System.out.println("List Number Student");
		System.out.println();
		for (Long long1 : studentSet) {
			System.err.println(long1);
		}
		System.out.println("Total Student : " + studentSet.size());
		sc.close();		
	}
}
