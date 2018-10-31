package com.curse.udemy.joo.section12.contract.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.curse.udemy.joo.section12.contract.model.exception.DomainRunTimeException;

public class Installment implements Serializable {

	private static final long serialVersionUID = 1L;
	private static long instance=0l;
	public static long getInstance() {
		return instance;
	}
	private Long   id;
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private Installment() {
		super();
		Installment.instance++;
		this.setId(Installment.instance);
	}

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date   duoDate;
	private Double amount;

	public Date getDuoDate() {
		return duoDate;
	}
	private void setDuoDate(Date duoDate) {
		if ((duoDate == null) )
			throw new DomainRunTimeException("Invalid Date! " + Installment.sdf.format(this.duoDate));
		this.duoDate = duoDate;
	}

	public Double getAmount() {
		return amount;
	}
	private void setAmount(Double amount) {
		if ((amount == null) || (amount <= 0d))
			throw new DomainRunTimeException("Invalid Amount! " + String.format("%.2f", amount));

		this.amount = amount;
	}	
	
	public Installment(Date duoDate, Double amount) {
		this();
		this.setDuoDate(duoDate);
		this.setAmount(amount);
	}

	
	
	@Override
	public String toString() {
		return Installment.sdf.format(this.getDuoDate()) + " - " + String.format("%.2f", this.getAmount()) + "";
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
		Installment other = (Installment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

	
	
}
