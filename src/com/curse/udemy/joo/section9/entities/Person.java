package com.curse.udemy.joo.section9.entities;

import java.io.Serializable;

public abstract class  Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}	
	private Person() {
		super();
		autoIncrementId++;
	}
	public Person(String name, Double annualIncome) {
		this();
		this.id = Person.getAutoIncrementId();
		this.name = name;
		this.annualIncome = annualIncome;
	}

	private Long id;
	public Long getId() {
		return id;
	}	
	private String  name;
	protected Double  annualIncome;
	
	
	public String getName() {
		return name;
	}
	
	public Double getAnnualIncome() {
		return annualIncome;
	}

	public abstract Double taxAmount();
	
	
	@Override
	public String toString() {
		return "name= " + name +  
			", annual income $= " + String.format("%.2f",annualIncome) + 
			"";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
