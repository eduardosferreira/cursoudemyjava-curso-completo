package com.curse.udemy.joo.section15.model.entities;

import java.util.Comparator;

// Interface funcional, pois tem somente uma funcao
public class MyComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.getName().trim().toUpperCase().compareTo(o2.getName().trim().toUpperCase());
	}
	
}
