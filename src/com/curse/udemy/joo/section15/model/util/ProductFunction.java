package com.curse.udemy.joo.section15.model.util;

import java.util.function.Function;

import com.curse.udemy.joo.section15.model.entities.Product;

public class ProductFunction implements Function<Product,Product> {

	@Override
	public Product apply(Product t) {
		return new Product(t.getName().trim().toUpperCase(), t.getPrice() - ((t.getPrice()*10d/100d)));
	}

}
