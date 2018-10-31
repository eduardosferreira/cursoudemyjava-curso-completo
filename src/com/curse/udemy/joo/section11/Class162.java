package com.curse.udemy.joo.section11;

import java.io.File;
import java.util.Scanner;

public class Class162 {
	
	public static void main(String[] args) {
	
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a file path: ");
			String filePath = sc.nextLine();
			
			File path = new File(filePath);
			
			// 
			System.out.println("--------------------");
			System.out.println(".getName() " + path.getName());
			System.out.println(".getAbsolutePath() " + path.getAbsolutePath());
			System.out.println(".getParent() " + path.getParent());
			System.out.println(".getParentFile() " + path.getParentFile());
				
			System.out.println("--------------------");
			
			
						
		}catch (Exception e) {
			e.printStackTrace();
		} ;
		
		
		
	}
	
}
