package com.curse.udemy.joo.section14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.curse.udemy.joo.section14.model.entities.LogEntry;

public class Set2 {

	
	public Set2() {
		Locale.setDefault(Locale.US);
		System.out.println("Diretorio atual: " + new java.io.File(".").getAbsolutePath());
	}
	
	private static void ex1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		String line = "";
		Set<LogEntry>  listHashSet = new HashSet<>();
		Set<LogEntry>  listTreeSet = new TreeSet<>();
		Set<LogEntry>  listLinkedHashSet = new LinkedHashSet<>();

		List<LogEntry> list    = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path)) )  {
			do {
				line = br.readLine();
				if (line != null && !line.trim().equals(" ")) {
					String[] fields = line.split(" ");
					listHashSet.add(new LogEntry(fields[0].trim().toUpperCase(), Date.from(Instant.parse(fields[1].trim().toUpperCase()))    )  );
					listTreeSet.add(new LogEntry(fields[0].trim().toUpperCase(), Date.from(Instant.parse(fields[1].trim().toUpperCase()))    )  );
					listLinkedHashSet.add(new LogEntry(fields[0].trim().toUpperCase(), Date.from(Instant.parse(fields[1].trim().toUpperCase()))    )  );
					list.add(new LogEntry(fields[0].trim().toUpperCase(), Date.from(Instant.parse(fields[1].trim().toUpperCase()))    )  );
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
		
		System.out.println("---------HashSet -----------------");
		for (LogEntry logEntry : listHashSet) {
			System.out.println(logEntry);
		}
		System.out.println("Total users: " + listHashSet.size());
		System.out.println("----------------------------------------");

		System.out.println("---------TreeSet -----------------");
		for (LogEntry logEntry : listTreeSet) {
			System.out.println(logEntry);
		}
		System.out.println("Total users: " + listTreeSet.size());
		System.out.println("----------------------------------------");
		
		System.out.println("---------LinkedHashSet -----------------");
		for (LogEntry logEntry : listLinkedHashSet) {
			System.out.println(logEntry);
		}
		System.out.println("Total users: " + listLinkedHashSet.size());
		System.out.println("----------------------------------------");

		
		System.out.println("---------ArrayList -----------------");
		for (LogEntry logEntry : list) {
			System.out.println(logEntry);
		}
		System.out.println("Total users: " + list.size());
		System.out.println("----------------------------------------");
		
		
		
		System.out.println("--- end ---");
		
		
	}

	public static void main(String[] args) {
		new Set2();
		ex1();
	}
	
}
