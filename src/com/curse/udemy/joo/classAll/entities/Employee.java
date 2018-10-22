package com.curse.udemy.joo.classAll.entities;

public class Employee  {
	
	private Long id;
	private String name;
	private Double salary;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void increaseSalary(Double percentage) {
		Double addSalary;
		if (percentage >= 0d) {
			addSalary = (this.salary * percentage)/100;
		} else
			addSalary = 0d;
		
		this.salary += addSalary;
	}
	
	
	public Employee(Long id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	
	@Override
	public String toString() {
		return "Emplyoee [id= " + id + ", name= " + name + ", salary $= " + String.format("%.2f", salary) + "]";
	}
	
	

}
