package com.curse.udemy.joo.class47.entities;
import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Long nroInstancia = 0L;
	
	public Long getNroInstancia() {
		return Product.nroInstancia;
	}
	
	private String name;
	private Double price;
	private Long quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


	public Product() {
		super();
		nroInstancia++;
	}
	
	public Product(String name, Double price, Long quantity) {
		this();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	
	public Double totalValueInStock() {
		return this.price*this.quantity;
	}

	public void addProduct(Long quantity) {
		if (quantity.longValue()>0L) 
			this.quantity += quantity;
		else 
			this.quantity += 0L;
		
	}
	
	public void removeProduct(Long quantity) {
		if (quantity.longValue()>0L) {
			if ((this.quantity - quantity) > 0L ) 
				this.quantity -= quantity;	
			else
				this.quantity = 0L;
			
		} else {
			this.quantity -= 0L;
		}
	}
	@Override
	public String toString() {
		return "O Produto [nome=" + this.getName()+ ", preço $ =" + String.format("%.2f", this.getPrice()) + ", quantidade = " + this.quantity + "]";
	}
	

}
