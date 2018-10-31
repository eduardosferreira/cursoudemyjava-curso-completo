package com.curse.udemy.joo.section12.contract.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.curse.udemy.joo.section12.contract.model.exception.DomainRunTimeException;

public class Contract implements Serializable {

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
	private Contract() {
		super();
		Contract.instance++;
		this.setId(Contract.instance);
	}

	private Long   number;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date   date;
	private Double totalValue;
	private List<Installment> list = new ArrayList<>();
	
	public Long getNumber() {
		return number;
	}
	private void setNumber(Long number) {
		if ((number == null) || (number <= 0d))
			throw new DomainRunTimeException("Invalid Number! " + number);

		this.number = number;
	}
	public Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		if ((date == null) )
			throw new DomainRunTimeException("Invalid Date! " + Contract.sdf.format(this.date));

		this.date = date;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	private void setTotalValue(Double totalValue) {
		if ((totalValue == null) || (totalValue <= 0d))
			throw new DomainRunTimeException("Invalid Total Value! " + String.format("%.2f", totalValue));

		this.totalValue = totalValue;
	}

	public List<Installment> getList() {
		return list;
	}
	public void setList(List<Installment> list) {
		this.list = list;
	}
	
	public Contract(Long number, Date date, Double totalValue) {
		this();
		this.setNumber(number); 
		this.setDate(date);
		this.setTotalValue(totalValue);
	}
	
	public Contract(Long number, Date date, Double totalValue,List<Installment> list) {
		this();
		this.setNumber(number); 
		this.setDate(date);
		this.setTotalValue(totalValue);
		this.setList(list);
	}

	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nInstallments:");
		for (Installment installment : list) {
			sb.append("\n"+ installment);
		}
		return "Contract" 
			  + "\nNumber: " + number 
			  + "\nDate: " + Contract.sdf.format(this.getDate()) 
			  + "\nValue: " + String.format("%.2f", this.getTotalValue()) 
			  + sb.toString();
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
		Contract other = (Contract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
