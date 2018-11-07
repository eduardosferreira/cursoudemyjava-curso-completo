package com.curse.udemy.joo.section15.model.util;

import java.util.function.Function;

import com.curse.udemy.joo.section15.model.entities.Product;

public class ProductNameFunction implements Function<Product,String> {

	@Override
	public String apply(Product t) {
		return t.getName().toUpperCase().trim();
	}

}
