package com.curse.udemy.joo.classAll.entities;
import java.io.Serializable;
import java.util.Locale;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Long nroInstancia = 0L;
	
	public Long getNroInstancia() {
		return Product.nroInstancia;
	}
	
	private String name;
	private Double price;
	private Long   quantity=0l;

	
	   	        Long      nro_default; // default
	protected   Long 	  nro_protected;
	public      Long 	  nro_public;
	private     Long 	  nro_private;

	public Long getQuantity() {
		return quantity;
	}
	
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
		Locale.setDefault(new Locale ("pt", "BR"));
		nroInstancia++;
		this.setNro_private(1L); // tem acesso, pois e na mesma classe
		this.nro_default   = 1L; // tem acesso, pois e na mesma package
		this.nro_protected = 1L; // tem acesso, pois e na mesma package que pertence a classe
		this.nro_public    = 1L; // tem acesso, pois e visivel a todos
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
		return "O Produto [nome=" + this.getName()+ ", preço R$ =" + String.format("%.2f", this.getPrice()) + ", quantidade = " + this.quantity + "]. Total: R$ = " + String.format("%.2f\n", this.totalValueInStock());
	}

	public Long getNro_private() {
		return nro_private;
	}

	public void setNro_private(Long nro_private) {
		this.nro_private = nro_private;
	}
	

}
