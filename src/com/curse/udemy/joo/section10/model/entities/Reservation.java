package com.curse.udemy.joo.section10.model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.curse.udemy.joo.section10.model.exception.DomainReservationException;
import com.curse.udemy.joo.section10.model.exception.DomainReservationRunTimeException;

public final class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}	
	private Reservation() {
		super();
		autoIncrementId++;
	}	

	
	private Long id;
	public Long getId() {
		return id;
	}	
	private Long roomNumber;
	private Date checkIn;
	private Date checkOut;
	

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	
	public Date getCheckOut() {
		return checkOut;
	}

	

	public Reservation( Long roomNumber, Date checkIn, Date checkOut) {
		this();
		this.id = Reservation.getAutoIncrementId();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Reservation(Long id, Long roomNumber, Date checkIn, Date checkOut) throws DomainReservationException {
		this();
		this.changeDateException(checkIn, checkOut);
		this.id = id;
		this.roomNumber = roomNumber;
	}

	public Reservation(Double id, Long roomNumber, Date checkIn, Date checkOut)  {
		this();
		this.changeDateRunTimeException(checkIn, checkOut);
		this.id = id.longValue();
		this.roomNumber = roomNumber;
	}
	
	public Long duration() {
		return TimeUnit.DAYS.convert((this.checkOut.getTime()-this.checkIn.getTime()),TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn,Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public void changeDateException(Date checkIn,Date checkOut) throws DomainReservationException {
		if  (checkIn.after(checkOut))  
			 throw new DomainReservationException("Error in reservation: Check-out date must be after check-in date");
		else if (checkIn.before(new Date())) 
			throw new DomainReservationException("Error in reservation: Reservation dates for update must be future dates");
		else if (checkIn.equals(new Date())) 
			throw new DomainReservationException("Error in reservation: Check-in equal today's date. ");

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	
	public void changeDateRunTimeException(Date checkIn,Date checkOut)  {
		if  (checkIn.after(checkOut))  
			 throw new DomainReservationRunTimeException("Error in reservation: Check-out date must be after check-in date");
		else if (checkIn.before(new Date())) 
			throw new DomainReservationRunTimeException("Error in reservation: Reservation dates for update must be future dates");
		else if (checkIn.equals(new Date())) 
			throw new DomainReservationRunTimeException("Error in reservation: Check-in equal today's date. ");

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}	

	public String validateChangeDates(Date checkIn,Date checkOut) {
		
		
		if  (checkIn.after(checkOut))  
			 return ("Error in reservation: Check-out date must be after check-in date");
		else if (checkIn.before(new Date())) 
			return ("Error in reservation: Reservation dates for update must be future dates");
		else if (checkIn.equals(new Date())) 
			return ("Error in reservation: Check-in equal today's date. ");

	    this.checkIn = checkIn;
	    this.checkOut = checkOut;
		
	    return null;
		
	}
	
	@Override
	public String toString() {
		return "Reservation [Room = " + roomNumber + ", Check In= " + Reservation.sdf.format(checkIn) + ", Check Out= " + Reservation.sdf.format(checkOut) + "]. Duration (nights): " + this.duration();
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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
