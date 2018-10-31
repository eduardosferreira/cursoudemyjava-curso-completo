package com.curse.udemy.joo.section11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section11.model.entities.Product;
import com.curse.udemy.joo.section11.model.exception.DomainRunTimeException;

public final class Section11 {

	private static List<Product> list = new ArrayList<>();
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final String SUBFOLDER = "\\OUT_" + SDF.format(new Date());
	private static final String FILE = "\\OUT_" + SDF.format(new Date()) + ".csv";

	private Section11() {
		Locale.setDefault(Locale.US);
		System.out.println("File Product");
	}

	private static String Path() {
		String filePath = null;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a file path: ");
			filePath = sc.nextLine();
		} catch (Exception e) {
			throw new DomainRunTimeException("Read path error: " + e.getMessage());
		}
		;
		return filePath;
	}

	private static void ReadFile(String path) {

		String step = "Path : " + path;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = null;
			do {
				step = "Read Line";
				line = br.readLine();
				if ((line != null) && (!(line.trim().equals("")))) {
					step = "Split File : " + line;
					String[] product = line.split(",");
					list.add(new Product(product[0], Double.parseDouble(product[1]), Long.parseLong(product[2])));
				}
			} while (line != null);
		} catch (FileNotFoundException e) {
			throw new DomainRunTimeException("File Not Found [ " + step + " ]: " + e.getMessage());
		} catch (IOException e) {
			throw new DomainRunTimeException("File Error [ " + step + " ]: " + e.getMessage());
		} catch (Exception e) {
			throw new DomainRunTimeException("Error [ " + step + " ]: " + e.getMessage());
		}

	}

	private static void ListProduct() {
		System.out.println("---------------------");
		System.out.println("LIST:");
		for (Product product : list) {
			System.out.println(product.getName() + "," + String.format("%.2f", product.total()));
		}
		System.out.println("---------------------");
	}

	private static void WriteFile(String path) {

		String step = "Path : " + path;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Product product : list) {
				bw.write(product.getName() + "," + String.format("%.2f", product.total()));
				bw.newLine();
			}
		} catch (Exception e) {
			throw new DomainRunTimeException("Error [ " + step + " ]: " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		new Section11();
		try {
			
			String filePath = Path();
			System.out.println("Read File: " + filePath);
			ReadFile(filePath);
			ListProduct();
			File path = new File(filePath);
			System.out.println("Create Sub-Folder: " + path.getParent() + SUBFOLDER);

			File file = new File(filePath + SUBFOLDER);
			if (!file.canWrite()) { // check if user have write permissions
				if (!(file.exists() && file.isDirectory())) {
					if (file.mkdirs()) {
						System.out.println("Success ! Folders created.");
						System.out.println("Write File : " + path.getParent() + SUBFOLDER + FILE);
						String writerPath = path.getParent() + SUBFOLDER + FILE;
						WriteFile(writerPath);
					} else
						throw new DomainRunTimeException("Failure ! Folders not created.");
				} else {
					throw new DomainRunTimeException("Exist Directory or Not Directory");
				}				
			} else {
				System.out.println("PERMISSION DENIED");
			}
			
			System.out.println("FIM");
		} catch (DomainRunTimeException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
