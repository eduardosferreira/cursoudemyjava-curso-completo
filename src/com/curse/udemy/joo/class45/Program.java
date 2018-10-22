package com.curse.udemy.joo.class45;

import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.class45.entities.Triangle;

public class Program {

	public Program() {
		super();
		Locale.setDefault(Locale.US);
	}
	
	public static void main(String[] args) {
	
		new Program();
		Scanner sc = new Scanner(System.in);
	
		Triangle x, y;
		
		y = new Triangle();
		
		x = new Triangle();
		
		System.out.print(" Enter the measyres of triangle X: ");
		
		x.setA(sc.nextDouble());
		x.setB(sc.nextDouble()); 
		x.setC(sc.nextDouble()); 


		System.out.print("\n Enter the measyres of triangle Y: ");
		y.setA(sc.nextDouble());
		y.setB(sc.nextDouble()); 
		y.setC(sc.nextDouble()); 
		
		System.out.println("");
		System.out.printf("\n Values <<X>>: \nA: %.2f \nB: %.2f \nC: %.2f \nArea: %.4f",x.getA(),x.getB(),x.getC(),x.areaTriangle());
		System.out.println("");
		System.out.printf("\n Values <<Y>>: \nA: %.2f \nB: %.2f \nC: %.2f \nArea: %.4f",y.getA(),y.getB(),y.getC(),y.areaTriangle());
		System.out.println("");
		System.out.println((x.areaTriangle() > y.areaTriangle()) ? "Area X é a maior": "Area Y é a maior");
		
		sc.close();
		
	}
	
}
