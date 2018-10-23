package com.curse.udemy.joo.section8;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.curse.udemy.joo.section8.entities.Client;
import com.curse.udemy.joo.section8.entities.Order;
import com.curse.udemy.joo.section8.entities.OrderItem;
import com.curse.udemy.joo.section8.entities.Product;
import com.curse.udemy.joo.section8.entities.enums.OrderStatus;

public class ProgramEx3 {

	private ProgramEx3() {
		Locale.setDefault(Locale.US);
		System.out.println();
	}


	public static void main(String[] args) throws Exception {
		new ProgramEx3();
		Scanner sc;
		Integer c = 0;
		do {
			sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter cliente data:");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Birth date (DD/MM/YYYY): ");
			Date birth = Client.sdf.parse(sc.nextLine().trim());			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			Client client = new Client(name, email, birth);
			Double price=0d;
			Long quantity=0l;
			
			System.out.println("Enter order data: ");
			System.out.print("Status (" + 
							"\n 1 - PENDING_PAYMENT(Pagamento Pendente)" + 
							"\n 2 - PROCESSING(Processando)" + 
							"\n 3 - SHIPPED(Pago)" + 
							"\n 4 - DELIVERED(Entregue)" +
							" ): ");
			Long status = sc.nextLong();
			sc.nextLine();
			System.out.println(OrderStatus.toEnum(status));
			System.out.print("How many items to this order? ");
			Long m = sc.nextLong();
			sc.nextLine();
			
			Order order = new Order(new Date(), OrderStatus.toEnum(status), client);
			for (int i = 1; i <= m; i++) {
				System.out.println("Enter #"+ i + " item data:");
				System.out.print("Product name: ");
				name = sc.nextLine();
				System.out.print("Product price: ");
				price = sc.nextDouble();
				sc.nextLine();
				System.out.print("Quantity: ");
				quantity = sc.nextLong();
				sc.nextLine();
				System.out.println();
				order.addItem(new OrderItem(quantity, price, new Product(name, price)));
			}
			
			System.out.println(order);
			System.out.println();
			try {
				System.out.print("Enter 0 for continue: ");
				c = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
			}
			sc.close();
		} while (c.equals(0));
		System.out.println();
		System.out.println("END");

		
	}
	
	
}
