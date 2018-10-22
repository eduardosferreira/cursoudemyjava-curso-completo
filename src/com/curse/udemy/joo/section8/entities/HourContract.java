package com.curse.udemy.joo.section8.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HourContract implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}
	
	
	private Long id;	
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	
	private HourContract() {
		super();
		Locale.setDefault(Locale.US);
		autoIncrementId++;
	}

	
	
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this();
		this.id = HourContract.getAutoIncrementId();
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Long getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}


	public Double totalValue() {
		return (Double) (this.hours*this.valuePerHour);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "HourContract [id= " + id 
				                   + ", date= " + sdf.format(date) 
				                   + ", valuePerHour= " + String.format("%.2f", valuePerHour) 
				                   + ", hours= " + hours
				                   + ", total hours Values= " + String.format("%.2f",this.totalValue())
				+ "]";
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
		HourContract other = (HourContract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
