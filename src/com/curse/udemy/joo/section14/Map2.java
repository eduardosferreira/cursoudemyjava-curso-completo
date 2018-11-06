package com.curse.udemy.joo.section14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Map2 {

	
	public Map2() {
		Locale.setDefault(Locale.US);
		System.out.println("Diretorio atual: " + new java.io.File(".").getAbsolutePath());
	}
	
	private static void ex1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		String line  = "";
		Long   total = 0l;
		Map<String, Long>  listMap = new TreeMap<>();
	
		try (BufferedReader br = new BufferedReader(new FileReader(path)) )  {
			
			do {
				line = br.readLine();
				if (line != null && !line.trim().equals(" ")) {
					
					String[] fields = line.split(",");
					if (listMap.containsKey(fields[0].trim().toUpperCase())) 
						total = listMap.get(fields[0].trim().toUpperCase()) + Long.parseLong(fields[1].trim());
					else
						total = Long.parseLong(fields[1].trim());
					
					listMap.put(fields[0].trim().toUpperCase(), total);
				}
			} while (line != null && !line.trim().equals(""));
			
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found!  " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		sc.close();
		
		System.out.println("---------Map -----------------");
		for (String key : listMap.keySet()) {
			System.out.println(key + " , " + listMap.get(key));
		}		
		System.out.println("Total: " + listMap.size());
		System.out.println("----------------------------------------");

		
		
		System.out.println("--- end ---");
		
		
	}

	public static void main(String[] args) {
		new Map2();
		ex1();
	}
	
}
