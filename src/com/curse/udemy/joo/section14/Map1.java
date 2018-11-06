package com.curse.udemy.joo.section14;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.curse.udemy.joo.section14.model.entities.Product;

public class Map1 {

	public Map1() {
		Locale.setDefault(Locale.US);
	}
	
	private static void ex1() {
		System.out.println("***********EX1****************");
		System.out.println();
		Map<String, String> cookies = new TreeMap<>();
		cookies.put("username", "Maria");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "55349812340011");
		cookies.put("cep", "38401668");
		
		System.out.println("ALL COOKIES");
		for (String key: cookies.keySet()) {
			System.out.println(key + " - " + cookies.get(key));			
		}
		System.out.println("Size: " + cookies.size());
		System.out.println("");
		System.out.println("Contain's 'cep' KEY : " + cookies.containsKey("cep"));
		System.out.println("Remove CEP");
		cookies.remove("cep");
		System.out.println("Contain's 'cep' KEY : " + cookies.containsKey("cep"));

		System.out.println();
		System.out.println("Alter PHONE");
		cookies.put("phone", "55349012340000");
		System.out.println("'phone'  : " + cookies.get("phone"));
		System.out.println("'ender'  : " + cookies.get("ender"));
		
		System.out.println();
		System.out.println("ALL COOKIES");
		for (String key: cookies.keySet()) {
			System.out.println(key + " - " + cookies.get(key));			
		}
		System.out.println("Size: " + cookies.size());
		System.out.println();
	}
	
	public static void ex2() {
		System.out.println("***********EX2****************");
		System.out.println();
		Map<Product, Double> stock = new HashMap<>();
		Product p1 = new Product("Tv", 900.0);
		Product p2 = new Product("Notebook", 1200.0);
		Product p3 = new Product("Tablet", 400.0);
		stock.put(p1, 10000.0);
		stock.put(p2, 20000.0);
		stock.put(p3, 15000.0);
		Product ps = new Product("Tv", 900.0);
		System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
		System.out.println();
	}
	
	public static void main(String[] args) {
		new Map1();
		ex1();
		ex2();
	}
}
