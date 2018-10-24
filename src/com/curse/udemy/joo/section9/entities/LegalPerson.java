package com.curse.udemy.joo.section9.entities;

public final class  LegalPerson extends Person {
	private static final long serialVersionUID = 1L;
	private Long numberOfEmployees;
	public Long getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Long numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	
	public LegalPerson(String name, Double annualIncome,Long numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = (numberOfEmployees == null?0l:numberOfEmployees) ;
	}

	@Override
	public Double taxAmount() {
		return (this.annualIncome * (this.numberOfEmployees > 10L?0.14d:0.16d));
	}

	@Override
	public String toString() {
		return "Legal Person: " + super.toString() +  " , number of employees= " + numberOfEmployees +  " , tax amount= " + String.format("%.2f",this.taxAmount()) + "";
	}


}
