package com.curse.udemy.joo.section8.entities;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Long autoIncrementId=0L;
	private Long id;
	private Long quantity;
	private Double price;
	private Product product;
	
	private OrderItem() {
		super();
		autoIncrementId++;
	}

	public OrderItem(Long quantity,Double price,Product product) {
		this();
		this.id = OrderItem.getAutoIncrementId();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}

	public Long getId() {
		return id;
	}

	public Long getQuantity() {
		return quantity;
	}


	public Double getPrice() {
		return price;
	}


	public Product getProduct() {
		return product;
	}

	public Double subTotal() {
		return (Double) price*quantity;
	}

	
	
	@Override
	public String toString() {
		return this.product.getName() +  ", $" + String.format("%.2f", this.getPrice()) + ", Quantity: " + this.getQuantity() + ", Subtotal: $"+  String.format("%.2f", this.subTotal());
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
