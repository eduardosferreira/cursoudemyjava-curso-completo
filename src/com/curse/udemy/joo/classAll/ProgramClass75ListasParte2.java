package com.curse.udemy.joo.classAll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ProgramClass75ListasParte2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public ProgramClass75ListasParte2() {
		super();
		Locale.setDefault(new Locale("pt","br"));
	}
	
	private static void imprimiList(List<String> list) {
		System.out.println("---------------------------------");
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("---------------------------------");
		System.out.println("lista size: " + list.size());
		System.out.println("---------------------------------");
	}
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
					
		list.add("Bob");
		list.add("Beatriz");
		list.add("Edu");
		list.add("Polly");
		list.add("Thy");		
		list.add(2,"Maria");
		list.add(0,"Regina");
		imprimiList(list);
		list.remove(4);
		imprimiList(list);
		list.remove("Edu");
		imprimiList(list);
		list.add("Carlos Eduardo");
		list.add("Carlos");
		list.add("Carla");
		imprimiList(list);		
		list.removeIf(x -> x.charAt(0) == 'C');
		imprimiList(list);
		System.out.println("index of: " + list.indexOf("Bob"));
		System.out.println("index of: " + list.indexOf("XXXXXXX"));
		imprimiList(list);
		list.add("Carlos Eduardo");
		list.add("Carlos");
		list.add("Carla");
		imprimiList(list);
		
		
		List<String> result1 = list.stream().filter(x -> x.charAt(0) == 'C').collect(Collectors.toList());
		imprimiList(result1);
		
		
		String name1 = list.stream().filter(x -> x.charAt(0) == 'C').findFirst().orElse(null);
		System.out.println(name1);
		String name2 = list.stream().filter(x -> x.charAt(0) == 'Z').findFirst().orElse("não existe z");
		System.out.println(name2);
	
		
		
	}

	
	
}
