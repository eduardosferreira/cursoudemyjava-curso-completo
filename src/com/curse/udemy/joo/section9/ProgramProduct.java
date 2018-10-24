package com.curse.udemy.joo.section9;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section9.entities.Product;
import com.curse.udemy.joo.section9.entities.ImportedProduct;
import com.curse.udemy.joo.section9.entities.UsedProduct;

public final class ProgramProduct {

	private ProgramProduct() {
		Locale.setDefault(Locale.US);
	}
	
	private static void Ex1() throws Exception {
		new ProgramProduct();
		Scanner sc;
		
		Integer continueLoop = 0;
		Integer quantityList =0;
		List<Product> listProduct = new ArrayList<>();
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Enter the number of element: ");
			quantityList = sc.nextInt();
			sc.nextLine();
			System.out.println();
			for (int i = 1; i <= quantityList; i++) {
				
				Product product;
				System.out.println("Product #" + i + " data:");
				System.out.print("Name: ");
				String  name = sc.nextLine();
				
				
				System.out.print("Price: ");
				Double  price = sc.nextDouble();				
				sc.nextLine();
				
				System.out.print("Common, used or imported (c/u/i)?: ");
				Character alternative = sc.nextLine().trim().toUpperCase().charAt(0); 
				switch (alternative) {
					case 'I':
						System.out.print("Customs fee: ");
						Double customsFee = sc.nextDouble();
						sc.nextLine();
						product = new ImportedProduct(name, price,customsFee);
						break;
					case 'U':
						System.out.print("Manufacture date (DD/MM/YYYY): ");
						Date manufactureDate = UsedProduct.sdf.parse(sc.nextLine());
						product = new UsedProduct(name, price,manufactureDate);
						break;	
					default:
						product = new Product(name, price);
						break;
				}
				listProduct.add(product);
				
				System.out.println();
			}
			
			System.out.println("PRICE TAGS:");
			for (Product e : listProduct) {
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
