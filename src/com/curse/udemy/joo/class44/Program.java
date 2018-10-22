package com.curse.udemy.joo.class44;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	
	public Program() {
		super();
		Locale.setDefault(Locale.US);
	}

	public static void main(String[] args) {
		
		new Program();
		Scanner sc = new Scanner(System.in);
		double areaY, pY,  areaX, pX, xA, xB, xC, yA, yB, yC; 

		System.out.print(" Enter the measyres of triangle X: ");
		
		xA = sc.nextDouble();
		xB = sc.nextDouble(); 
		xC = sc.nextDouble(); 


		System.out.print("\n Enter the measyres of triangle Y: ");
		yA = sc.nextDouble(); 
		yB = sc.nextDouble(); 
		yC = sc.nextDouble();
		
		pX = (xA + xB + xC) / 2.0d;
		areaX = Math.sqrt(pX * (pX-xA) * (pX-xB) * (pX-xC));
		
		pY = (yA + yB + yC) / 2.0d;
		areaY = Math.sqrt(pY * (pY-yA) * (pY-yB) * (pY-yC));

		System.out.println("");
		System.out.printf("\n Values <<X>>: \nA: %.2f \nB: %.2f \nC: %.2f \nP: %.4f \nArea: %.4f",xA,xB,xC,pX,areaX);
		System.out.println("");
		System.out.printf("\n Values <<Y>>: \nA: %.2f \nB: %.2f \nC: %.2f \nP: %.4f \nArea: %.4f",yA,yB,yC,pY,areaY);
		System.out.println("");
		System.out.println((areaX > areaY) ? "Area X é a maior": "Area Y é a maior");
		
		sc.close();
		
	}
	
	
}
