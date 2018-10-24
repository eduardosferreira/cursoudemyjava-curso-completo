package com.curse.udemy.joo.section9.entities;

public final class PhysicalPerson extends Person {
	private static final long serialVersionUID = 1L;
	private Double spendingOnHealth;
	public Double getSpendingOnHealth() {
		return spendingOnHealth;
	}

	public void setSpendingOnHealth(Double spendingOnHealth) {
		this.spendingOnHealth = spendingOnHealth;
	}
	
	
	public PhysicalPerson(String name, Double annualIncome,Double spendingOnHealth) {
		super(name, annualIncome);
		this.spendingOnHealth = (spendingOnHealth == null?0d:spendingOnHealth) ;
	}

	@Override
	public Double taxAmount() {
		return (this.annualIncome * (this.annualIncome >= 20_000d?0.25d:0.15d)) - (this.spendingOnHealth * 0.5d);
	}

	@Override
	public String toString() {
		return "Physical Person: " + super.toString() +  " , spending on health= " + String.format("%.2f",spendingOnHealth) +  " , tax amount= " + String.format("%.2f",this.taxAmount()) + "";
	}


}
