package com.curse.udemy.joo.section9.entities;

public final class ImportedProduct extends Product {

	private Double customsFee;
	public ImportedProduct(String name, Double price,Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	public Double getCustomsFee() {
		return customsFee;
	}
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	public Double totalPrice() {
		return this.getPrice() + this.getCustomsFee();
	}
	@Override
	public String toString() {
		return super.toString() + " customsFee= " + String.format("%.2f", customsFee) + " = " + String.format("%.2f", this.totalPrice());
	}

	
}
