package com.curse.udemy.joo.section15.model.services;

import java.util.List;
import java.util.function.Predicate;

import com.curse.udemy.joo.section15.model.entities.Product;

public class ProductService {
	
	public Double filteredSum(List<Product> list) {
		Double sum = 0d;
		for (Product product : list) {
			if (product.getName().trim().toUpperCase().charAt(0) == 'T') 
				sum += product.getPrice();
		}
		return sum;
	}

	public Double filteredSum(List<Product> list, Predicate<Product> criteria) {
		Double sum = 0d;
		for (Product product : list) {
			if (criteria.test(product)) 
				sum += product.getPrice();
		}
		return sum;
	}
	
}
