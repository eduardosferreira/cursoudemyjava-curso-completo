package com.curse.udemy.joo.section11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Class157 {

	public Class157() {
		super();		
	}
	
	public static void Ex1() {
		new Class157();
		File file = new File("C:\\eclipse-workspace\\application\\src\\com\\curse\\udemy\\joo\\section11\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				/*
				String string = (String) sc.next();
				System.out.print(string);
				*/
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e.getMessage()); 
		} finally {
			if (sc != null) {
				sc.close();
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		Ex1();
		
	}
	
}
