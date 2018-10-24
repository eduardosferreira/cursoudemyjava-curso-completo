package com.curse.udemy.joo.section9.entities;

public  class OutsourcedEmployee extends Employee {
	private static final long serialVersionUID = 1L;
	private Double additionalCharge;
	public OutsourcedEmployee(String name, 
							  Integer hours, 
							  Double valuePerHour,
							  Double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge =  additionalCharge;
	}
	public Double getAdditionalCharge() {
		return additionalCharge;
	}
	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public final Double valueTotalHour() {
		return (Double) super.valueTotalHour() + this.getAdditionalCharge() * 1.1;
	}

	@Override
	public String toString() {
		return "Employee [name= " + this.getName() + ", hours= " + this.getHours() + ", value Per Hour $= " + String.format("%.2f",this.getValuePerHour()) + ", Additional charge $= " + String.format("%.2f",this.getAdditionalCharge()) + "]. Total $= " + String.format("%.2f",this.valueTotalHour());
	}

}
