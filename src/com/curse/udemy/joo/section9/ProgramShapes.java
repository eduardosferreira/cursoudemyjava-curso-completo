package com.curse.udemy.joo.section9;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section9.entities.Circle;
import com.curse.udemy.joo.section9.entities.Rectangle;
import com.curse.udemy.joo.section9.entities.Shape;
import com.curse.udemy.joo.section9.entities.enums.Color;

public final class ProgramShapes {

	private ProgramShapes() {
		Locale.setDefault(Locale.US);
	}
	
	private static void Ex1() throws Exception {
		new ProgramShapes();
		Scanner sc;
		
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Shape> listShape = new ArrayList<>();
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Shape shape;
				System.out.println("Shape #" + i + " data:");
				System.out.print("Color"
						+ "\n 1 - BLACK"  
						+ "\n 2 - BLUE"
						+ "\n 3	- RED:");
				Color  color = Color.toEnum(sc.nextLong());
				sc.nextLine();
				
				System.out.print("Rectangle or Circle (r/c)?: ");
				Character alternative = sc.nextLine().trim().toUpperCase().charAt(0); 
				switch (alternative) {
					case 'R':
						System.out.print("Width: ");
						Double width = sc.nextDouble();
						sc.nextLine();
						System.out.print("Height: ");
						Double height = sc.nextDouble();
						sc.nextLine();
						shape = new Rectangle(color, width, height);
						break;
					default:
						System.out.print("Radius: ");
						Double radius = sc.nextDouble();
						sc.nextLine();
						shape = new Circle(color, radius);
						break;
				}
				listShape.add(shape);
				
				System.out.println();
			}
			
			System.out.println("SHAPE AREAS:");
			for (Shape e : listShape) {
				System.out.println(e);
			}
			
			try {
				System.out.println();
				System.out.print("Enter 0 for continue: ");
				continueLoop = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				continueLoop = 1;
			}
			System.out.println();
			sc.close();
		} while (continueLoop.equals(0));
		System.out.println();
		System.out.println("END");
		
	}
	
	public static void main(String[] args) throws Exception {
		Ex1();
		
	}

	
	
}
