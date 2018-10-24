package com.curse.udemy.joo.section9.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UsedProduct extends Product {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufactureDate;
	public UsedProduct(String name, Double price,Date manufactureDate) {
		super(name, price);
		this.setManufactureDate(manufactureDate);
	}


	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Manufacture Date= " + UsedProduct.sdf.format(this.getManufactureDate()) + " " ;
	}

	
}
