package com.curse.udemy.joo.class63.entities;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Long   nroInstance=0L;
	public static Long getNroInstance() {
		return nroInstance;
	}
	
	private Integer number;
	private String  holder;
	private Double  value= 0d;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}


	public Double getValue() {
		return this.value;
	}
	
	private Account() {
		super();
		nroInstance++;
	}
	
	public Account(Integer number, String holder) {
		this();
		this.number = number;
		this.holder = holder;
	}

	public Account(Integer number, String holder, Double depositValueInitial) {
		this();
		this.number = number;
		this.holder = holder;
		this.deposit(depositValueInitial);;
		
	}
	
	
	public void deposit(Double value) {
		if (value.doubleValue()>0D) 
			this.value += value;
		else 
			this.value += 0L;
		
	}
	
	public void withDra(Double value) {
		if (value.doubleValue() >0D) {
			if ((this.value - value) > 0D ) 
				this.value -= value;	
			else
				this.value = 0D;
			
		} else {
			this.value -= 0D;
		}
	}
	
	@Override
	public String toString() {
		return " Account data: \nAccount [number= " + number + ", holder= " + holder + ", Balance $= " + String.format("%.2f", value) + "] NOTA: Instancia [ " + Account.nroInstance + " ] ";
	}
	
	
}
