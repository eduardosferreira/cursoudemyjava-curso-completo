package com.curse.udemy.joo.section8.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Long autoIncrementId=0L;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	private Long id;
	private String name;
	private String email;
	private Date birth;

	private Client() {
		super();
		autoIncrementId++;
	}

	public Client(String name,String email,Date birth) {
		this();
		this.id = Client.getAutoIncrementId();
		this.name = name;
		this.email = email;
		this.birth = birth;
	}

	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirth() {
		return birth;
	}

	
	@Override
	public String toString() {
		return "Client " + this.getName() + " (" + Client.sdf.format(this.getBirth()) + ") " + " - " + this.getEmail();
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
