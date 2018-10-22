package com.curse.udemy.joo.classAll;

import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.classAll.entities.Product;

public class ProgramProduct {

	public ProgramProduct() {
		Locale.setDefault(Locale.US);
		System.out.println("*****SISTEMA DE PRODUTO*****");
	}
	
	public static void main(String[] args) {
		new ProgramProduct();
		Product produto;
		String name;
		Double price;
		Long quantity;		
		Scanner sc;
		Integer flag = 0;
		do {
			
			System.out.print("--------------------------- ");
			System.out.println("");
			sc = new Scanner(System.in);
			System.out.println("Entre com o produto:");
			System.out.print(" Nome: ");
			name = sc.nextLine();
			System.out.print("\n Preco: ");
			price = sc.nextDouble();
			System.out.print("\n Quantidade: ");
			quantity = sc.nextLong();
			System.out.println();
			produto = new Product(name,price,quantity);
			System.out.print(produto);
			System.out.printf(" . Total $: %.2f\n",produto.totalValueInStock());
			System.out.println();
			System.out.print("Informe uma quantidade que seja maior que zero caso deseja adicionar ao estoque do produto: ");
			produto.addProduct(sc.nextLong());
			System.out.printf("%s . Total $: %.2f\n",produto.toString(), produto.totalValueInStock());
			System.out.println();
			System.out.print("Informe uma quantidade que seja maior que zero caso deseja remover ao estoque do produto: ");
			produto.removeProduct(sc.nextLong());
			System.out.printf("%s . Total $: %.2f\n",produto.toString(), produto.totalValueInStock());
			System.out.println("");
			try {
				System.out.print("Digite zero (0) para continuar: ");
				flag = sc.nextInt();
			} catch (Exception e) {
				flag = 1;
			}
			produto = null;
		} while (flag.equals(0));
		
		System.out.println("\nFIM");
		sc.close();
	}

}
