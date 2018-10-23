package com.curse.udemy.joo.section8.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.curse.udemy.joo.section8.entities.enums.OrderStatus;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}	
	private Order() {
		super();
		autoIncrementId++;
	}
	private Long id;
	public Long getId() {
		return id;
	}
	private Date moment;
	private Long status;
	private Client client;	
	List<OrderItem> items = new ArrayList<>();
	
	
	public Order(Date moment, OrderStatus status, Client client) {
		this();
		this.id = Order.getAutoIncrementId();
		this.moment = moment;
		this.status = status.getId();
		this.setClient(client);
	}
	
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return OrderStatus.toEnum(status);
	}
	public void setStatus(OrderStatus status) {
		this.status = status.getId();
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	public Double total() {
		Double sum=0d;
		for (OrderItem orderItem : items) {
			sum += orderItem.subTotal();
		}
		return sum;
	}
	
	
	
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("ORDER SUMMARY: \n");
		s.append("	Order moment: " +  Order.sdf.format(this.getMoment()) + " \n");
		s.append("	Order status: " + this.getStatus()  + " [" + this.getStatus().getName() + "]" +  " \n");
		s.append(" " + this.getClient().toString() + "\n");
		s.append("	Order items: \n");
		for (OrderItem orderItem : this.getItems()) {
			s.append(" " + orderItem.toString() + "\n");
		}
		s.append("	Total price: $"+ String.format("%.2f", this.total()) + "\n");
		
		return s.toString();
		
		
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
