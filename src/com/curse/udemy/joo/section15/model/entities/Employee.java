package com.curse.udemy.joo.section15.model.entities;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee>{
	
	private static final long serialVersionUID = 1L;
	private static long  instance = 0l;

	private Long   id;
	private String name;
	private String email;
	private Double salary;
	
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		if (id == null || id <= 0) 
			throw new IllegalArgumentException("Invalid Argument!");
		
		this.id = id;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		if (name == null || name.trim().equals("")) 
			throw new IllegalArgumentException("Invalid Argument!");

		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		if (email == null || email.trim().equals("")) 
			throw new IllegalArgumentException("Invalid Argument!");

		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}
	
	private void setSalary(Double salary) {
		if (salary == null || salary <= 0) 
			throw new IllegalArgumentException("Invalid Argument!");

		this.salary = salary;
	}
	
	public void addPercentageSalary(Double percentage) {
		this.setSalary(this.getSalary() + ((Double) (percentage*this.getSalary())/100d));
	}
	
	private Employee() {
		super();
		Employee.instance++;		
	}

	public Employee(String name, String email, Double salary) {
		this();
		this.setId(Employee.instance);
		this.setName(name);
		this.setEmail(email);
		this.setSalary(salary);
	}

	public Employee(Long id, String name, String email, Double salary) {
		this();
		this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setSalary(salary);
	}
	
	public static boolean staticEmployeePredicate(Employee t) {
		return t.getSalary() >= 80d;
	}

	public boolean nonStaticEmployeePredicate() {
		return this.getSalary() >= 70d;
	}

	public static void staticEmployeeConsumer(Employee t) {
		t.addPercentageSalary(15d);
	}

	public void nonStaticEmployeeConsumer() {
		this.addPercentageSalary(20d);
	}

	public static String staticEmployeeNameFunction(Employee t) {
		return t.getName().toUpperCase().trim();
	}

	public static Employee staticEmployeeFunction(Employee t)  {
		return new Employee(t.getName().trim().toUpperCase(),t.getEmail().trim().toLowerCase() ,  t.getSalary() - ((t.getSalary()*10d/100d)));
	}

	public String nonStaticEmployeeNameFunction() {
		return this.getName().toUpperCase().trim();
	}

	public Employee nonStaticEmployeeFunction()  {
		return new Employee(this.getName().trim().toUpperCase(), this.getEmail().trim().toLowerCase(), this.getSalary() - ((this.getSalary()*10d/100d)));
	}
	
	
	@Override
	public String toString() {
		return "Employee [id= " + this.getId() + ", name= " + this.getName()+ ", email= " + this.getEmail() + ", salary= " + String.format("%.2f", this.getSalary()) + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int compareTo(Employee o) {
		return o.getId().compareTo(this.getId());
	}
	
	
	

}
