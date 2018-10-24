package com.curse.udemy.joo.section9.entities;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}	
	private Employee() {
		super();
		autoIncrementId++;
	}
	public Employee(String name, Integer hours, Double valuePerHour) {
		this();
		this.id = Employee.getAutoIncrementId();
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	private Long id;
	public Long getId() {
		return id;
	}	
	private String  name;
	private Integer hours;
	private Double  valuePerHour;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	
	public Double valueTotalHour() {
		return (Double) valuePerHour*hours;
	}
	
	
	@Override
	public String toString() {
		return "Employee [name= " + name + ", hours= " + hours + ", value Per Hour $= " + String.format("%.2f",valuePerHour) + "]. Total $= " + String.format("%.2f",this.valueTotalHour());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
