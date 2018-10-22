package com.curse.udemy.joo.classAll.entities;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date data;
	private Product product;

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order(Date data, Product product) {
		super();
		this.data = data;
		this.product = product;
		
		
		// this.product.nro_private   = 1L; // não tem acesso, pois e protegido
		this.product.nro_default   = 1L; // tem acesso, pois e na mesma package
		this.product.nro_protected = 1L; // tem acesso, mesmo não sendo heranca está na mesma package
		this.product.nro_public    = 1L; // tem acesso, pois e visivel a todos
		
	}
	
	

}
