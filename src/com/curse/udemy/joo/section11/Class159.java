package com.curse.udemy.joo.section11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Class159 {

	public Class159() {
		super();		
	}
	
	public static void Ex1() {
		new Class159();
		String path = "C:\\eclipse-workspace\\application\\src\\com\\curse\\udemy\\joo\\section11\\in.txt";
		String line = null;

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			do {
				try {
					line = br.readLine();
					if ((line != null) && (!(line.trim().equals("")))) {
						System.out.println(line);
					}
				} catch (IOException e) {
					System.out.println("Error reading file: " + e.getMessage()); 
				}

			} while (line != null); 		
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found: " + e.getMessage());
		} catch (IOException e1) {
			System.out.println("File Error: " + e1.getMessage());
		} 		
		
	}
	
	public static void main(String[] args) {
		Ex1();
		
	}
	
}
