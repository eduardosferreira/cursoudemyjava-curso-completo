package com.curse.udemy.joo.section14.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry implements Serializable, Comparable<LogEntry> {

	private static final long serialVersionUID = 1L;
	private static Long   instance= 0L;
	private String userName;
	private Date   moment;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	private LogEntry() {
		LogEntry.instance++;
	}
	
	public LogEntry(String userName, Date moment) {
		this();
		this.setUserName(userName);
		this.setMoment(moment);
	}

	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getMoment() {
		return moment;
	}

	private void setMoment(Date moment) {
		this.moment = moment;
	}

	@Override
	public int compareTo(LogEntry o) {
		// TODO Auto-generated method stub
		return this.getUserName().trim().toUpperCase().compareTo(o.getUserName().trim().toUpperCase());
	}

	@Override
	public String toString() {
		return "LogEntry [userName= " + userName + ", moment= " + LogEntry.sdf.format(moment) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		LogEntry other = (LogEntry) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
	
	
}
