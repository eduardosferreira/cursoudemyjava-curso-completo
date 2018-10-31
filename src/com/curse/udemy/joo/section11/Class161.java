package com.curse.udemy.joo.section11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Class161 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final String SUBFOLDER = "\\OUT_" + sdf.format(new Date());
	
	public static void main(String[] args) {
	
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a folder path: ");
			String folderPath = sc.nextLine();
			
			File path = new File(folderPath);
			
			File[] folders = path.listFiles(File::isDirectory);
		
			System.out.println();
			System.out.println("FOLDERS: ");
			System.out.println("-------------------------");
			for (File folder : folders) {
				System.out.println(folder);
			}
			System.out.println("-------------------------");
			System.out.println();
		
			File[] files = path.listFiles(File::isFile);
			
			System.out.println();
			System.out.println("FILES: ");
			System.out.println("-------------------------");
			for (File file : files) {
				System.out.println(file);
			}
			System.out.println("-------------------------");
			System.out.println();

			System.out.println();
			System.out.println("CREATE SUB-FOLDER: " + folderPath + SUBFOLDER);
			try {
				boolean subfolders = new File(folderPath + SUBFOLDER).mkdirs();
				if (subfolders) 
					System.out.println("SUCESS - Create");
				else 
					System.err.println("NOT SUCESS - Create");
				
			} catch (Exception e11) {
				System.out.println("Create Erro [Sub Folder] - > " + e11.getMessage());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} ;
		
		
		
	}
	
}
