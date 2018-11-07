package com.curse.udemy.joo.section15.model.util;

import java.util.function.Consumer;

import com.curse.udemy.joo.section15.model.entities.Product;

public class ProductConsumer implements Consumer<Product> {

	@Override
	public void accept(Product t) {
		t.addPercentagePrice(10d);		
	}

}
