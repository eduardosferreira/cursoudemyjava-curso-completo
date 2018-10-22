package com.curse.udemy.joo.classAll.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.curse.udemy.joo.classAll.entities.enums.RequestStatus;

public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Date moment;
	private Long status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public RequestStatus getStatus() {
		return  RequestStatus.toEnum(this.status);
	}
	public void setStatus(RequestStatus status) {
		this.status = status.getId();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private Request() {
		super();
		Locale.setDefault(Locale.US);
	}
	
	public Request(Long id, Date moment, RequestStatus status) {
		this();
		this.id = id;
		this.moment = moment;
		this.status = status.getId();
	}

	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Request [id=" + id + ", moment=" + sdf.format(moment) + ", status=" + RequestStatus.toEnum(this.status).getDescricao() + "]";
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
		Request other = (Request) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
