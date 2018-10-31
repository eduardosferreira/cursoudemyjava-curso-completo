package com.curse.udemy.joo.section11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Class160 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final String path = "C:\\eclipse-workspace\\application\\src\\com\\curse\\udemy\\joo\\section11\\out_" + sdf.format(new Date()) + ".txt";
	
	public Class160() {
		super();		
	}
	
	public static void GravacaoArquivo() {
		new Class160();
		String[] lines = new String[] 
				{"1.  NppExport v0.2.8 (32-bit x86 only)" , 
				"2.  Converter 4.2.1" , 
				"3.  Mime Tool 2.1 " , 
				"4.  DSpellCheck 1.3.5"}; 		
	
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for (String string : lines) {
				bw.write(string);
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("File Error - > " + e.getMessage());
		}
		
		
	}
	public static void ReGravacaoArquivo() {
		new Class160();
		String[] lines = new String[] 
				{"1.  NppExport v0.2.8 (32-bit x86 only)" , 
				"2.  Converter 4.2.1" , 
				"3.  Mime Tool 2.1 " , 
				"4.  DSpellCheck 1.3.5"}; 		
	
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
			for (String string : lines) {
				bw.write(string);
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("File Error - > " + e.getMessage());
		}
		
		
	}

	private static void LeituraArquivo() {
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
		GravacaoArquivo();
		System.out.println();
		LeituraArquivo(); 	
		System.out.println();
		ReGravacaoArquivo();
		System.out.println();
		LeituraArquivo();

	}
	
}
