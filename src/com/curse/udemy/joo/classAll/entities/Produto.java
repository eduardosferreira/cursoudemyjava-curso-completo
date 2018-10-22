package com.curse.udemy.joo.classAll.entities;

public class Produto extends Product{

	private static final long serialVersionUID = 1L;

	public Produto(Product product) {
		product.nro_protected = 1L; // tem acesso, pois e heranca
		
	}

}
