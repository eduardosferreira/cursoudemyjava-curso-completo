package com.curse.udemy.joo.section15.model.entities;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product>{
	
	private static final long serialVersionUID = 1L;
	private static long  instance = 0l;

	private Long   id;
	private String name;
	private Double price;
	
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
	public Double getPrice() {
		return price;
	}
	
	private void setPrice(Double price) {
		if (price == null || price <= 0) 
			throw new IllegalArgumentException("Invalid Argument!");

		this.price = price;
	}
	
	public void addPercentagePrice(Double percentage) {
		this.setPrice(this.getPrice() + ((Double) (percentage*this.getPrice())/100d));
	}
	
	private Product() {
		super();
		Product.instance++;		
	}

	public Product(String name, Double price) {
		this();
		this.setId(Product.instance);
		this.setName(name);
		this.setPrice(price);
	}

	public Product(Long id, String name, Double price) {
		this();
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
	}
	
	public static boolean staticProductPredicate(Product t) {
		return t.getPrice() >= 80d;
	}

	public boolean nonStaticProductPredicate() {
		return this.getPrice() >= 70d;
	}

	public static void staticProductConsumer(Product t) {
		t.addPercentagePrice(15d);
	}

	public void nonStaticProductConsumer() {
		this.addPercentagePrice(20d);
	}

	public static String staticProductNameFunction(Product t) {
		return t.getName().toUpperCase().trim();
	}

	public static Product staticProductFunction(Product t)  {
		return new Product(t.getName().trim().toUpperCase(), t.getPrice() - ((t.getPrice()*10d/100d)));
	}

	public String nonStaticProductNameFunction() {
		return this.getName().toUpperCase().trim();
	}

	public Product nonStaticProductFunction()  {
		return new Product(this.getName().trim().toUpperCase(), this.getPrice() - ((this.getPrice()*10d/100d)));
	}
	
	
	@Override
	public String toString() {
		return "Product [id= " + id + ", name= " + name + ", price= " + String.format("%.2f", price) + "]";
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int compareTo(Product o) {
		return o.getId().compareTo(this.getId());
	}
	
	
	

}
