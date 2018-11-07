package com.curse.udemy.joo.section15.model.util;

import java.util.function.Predicate;

import com.curse.udemy.joo.section15.model.entities.Product;

public class ProductPredicate implements Predicate<Product> {

	@Override
	public boolean test(Product t) {
		return t.getPrice() >= 100;
	}

}
