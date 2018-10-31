package com.curse.udemy.joo.section11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Class158 {

	public Class158() {
		super();		
	}
	
	public static void Ex1() {
		new Class158();
		String path = "C:\\eclipse-workspace\\application\\src\\com\\curse\\udemy\\joo\\section11\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		String line = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
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
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		
	}
	
	public static void main(String[] args) {
		Ex1();
		
	}
	
}
