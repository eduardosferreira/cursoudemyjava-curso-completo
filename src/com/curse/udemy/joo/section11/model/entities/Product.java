package com.curse.udemy.joo.section11.model.entities;

import java.io.Serializable;

import com.curse.udemy.joo.section11.model.exception.DomainRunTimeException;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private static long instance=0l;
	private Long   id;
	private String name;
	private Double price;
	private Long   quantity;
	
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
	public Long getQuantity() {
		return quantity;
	}
	
	private void setId(Long id) {
		if ((id == null) || (id.longValue() < 0l) ){
			throw new DomainRunTimeException("Ilegal Argument : Invalid Id - > " + id);
		}
		this.id = id;
	}
	private void setName(String name) {
		if ( (name == null) || (name.trim().equals("")) ){
			throw new DomainRunTimeException("Ilegal Argument : Invalid Name - > " + name);
		}

		this.name = name;
	}
	private void setPrice(Double price) {
		if ((price == null) || (price.doubleValue() < 0d) ){
			throw new DomainRunTimeException("Ilegal Argument : Invalid Price - > " + price);
		}
		this.price = price;
	}
	private void setQuantity(Long quantity) {
		if ((quantity == null) || (quantity.longValue() < 0l) ){
			throw new DomainRunTimeException("Ilegal Argument : Invalid quantity - > " + quantity);
		}
		this.quantity = quantity;
	}
	
	private Product() {
		super();
		Product.instance++;
	}
		
		
	public Product(String name, Double price, Long quantity) {
		this();
		this.setId(Product.instance);
		this.setName(name);
		this.setPrice(price);
		this.setQuantity(quantity);
	}
	
	public Double total() {
		return (Double) (this.getQuantity()*this.getPrice());
	}
	
	
	@Override
	public String toString() {
		return " Product [name= " + name 
				+ ", price= " +  String.format("%.2f", price) 
				+ ", quantity= " + quantity + "]. Total: " +  String.format("%.2f", this.total());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
	
}
