package com.curse.udemy.joo.classAll;

import java.util.Locale;
import java.util.Scanner;

public class ProgramClass77ExercicioFixacaoMatriz {

	
	private static void printMat(int mat[][]) {
		System.out.println("******* PRINT MATRIX *****");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print("[" + i + "][" + j + "]: " + mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("**********************");
		
	}
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt","br"));
		Scanner in = new Scanner(System.in);
		System.out.println("*******MATRIX*****");
		System.out.print("Number Lines : ");
		int i = in.nextInt();
		in.nextLine();
		System.out.print("Number Colluns: ");
		int j = in.nextInt();
		in.nextLine();		
		int mat[][] = new int[i][j];
		for (int i1 = 0; i1 < mat.length; i1++) {
			for (int j1 = 0; j1 < mat[i1].length; j1++) {
				System.out.print("Enter values [" + i1 + "][" + j1 + "]: " );
				mat[i1][j1] = in.nextInt();
				in.nextLine();
			}
		}
		printMat(mat);
		int f;
		do {
			System.out.println();
			System.out.print("Number find [0 exit]: ");
			f = in.nextInt();
			in.nextLine();
			for (int i1 = 0; i1 < mat.length; i1++) {
				for (int j1 = 0; j1 < mat[i1].length; j1++) {
					if (mat[i1][j1] == f) {
						System.out.println("Position find [" + i1 + "][" + j1 + "] " );
						int l = j1-1;
						if (l <= (mat[i1].length-1) && l >= 0) {
							System.out.println("Left [" + i1 + "][" + l + "] : " + mat[i1][l]);
						}
						int r = j1+1;
						if (r <= (mat[i1].length-1) && r >= 0) {
							System.out.println("Right [" + i1 + "][" + r + "] : " + mat[i1][r]);
						}
						int a = i1-1;
						if (a <= (mat.length-1) && a >= 0) {
							System.out.println("Above [" + a + "][" + j1 + "] : " + mat[a][j1]);
						}
						int d = i1+1;
						if (d <= (mat.length-1) && d >= 0) {
							System.out.println("Down [" + d + "][" + j1 + "] : " + mat[d][j1]);
						}
	
						System.out.println();
										
					}
				}
			}
		
		} while (f !=0);


		System.out.println();
		System.out.println("END");
		
		in.close();
		
	}
	
}
