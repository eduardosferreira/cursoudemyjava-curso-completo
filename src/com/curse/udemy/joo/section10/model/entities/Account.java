package com.curse.udemy.joo.section10.model.entities;

import java.io.Serializable;

import com.curse.udemy.joo.section10.model.exception.DomainAccountException;
import com.curse.udemy.joo.section10.model.exception.DomainAccountRunTimeException;

public final class  Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private static long instance=0;
	private Integer number;
	private String  holder;
	private Double  balance;
	private Double  withDrawLimit;
	
	public void deposit(Double amount)  {
		this.setBalance((this.getBalance()+amount));
	}
	
	public void withDraw(Double amount) throws DomainAccountException , DomainAccountRunTimeException  {
		Double value = this.getBalance() - this.getWithDrawLimit();
		if (amount > value) {
			throw new DomainAccountException("The amount exceeds withdraw limit");	
		}
		value = this.getBalance() - amount;
		this.setBalance(value);
	}

	private Account() {
		super();
		Account.instance++;
		this.setBalance(0d);
		this.setWithDrawLimit(0d);		
		this.setNumber((int) Account.getInstance()); 
	}

	public Account(String holder) {
		this();
		this.setHolder(holder); 
	}
	
	public Account(String holder, Double balance, Double withDrawLimit) {
		this();
		this.setHolder(holder); 
		this.setBalance(balance); 
		this.setWithDrawLimit(withDrawLimit); 
	}
	
	
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this(holder, balance, withDrawLimit);
		this.setNumber(number); 
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static long getInstance() {
		return instance;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		if (balance == null)
			return 0d;
		else
			return balance;
	}

	public Double getWithDrawLimit() {
		if (withDrawLimit == null)
			return 0d;
		else
			return withDrawLimit;
	}



	private void setNumber(Integer number) {
		if (number == null) {
			throw new DomainAccountRunTimeException("Number: Value can not be null.");
		}
		if (number <= 0) {
			throw new DomainAccountRunTimeException("Number : Value must be greater than zero.");
		}
		
		this.number = number;
	}

	private void setHolder(String holder) {
		if (holder == null) {
			throw new DomainAccountRunTimeException("Holder: Value can not be null.");
		}
		if (holder.trim().equals("")) {
			throw new DomainAccountRunTimeException("Holder: Value can not be empty.");
		}		
		this.holder = holder;
	}

	private void setBalance(Double balance) {
		if (balance == null) {
			throw new DomainAccountRunTimeException("Balance: Value can not be null.");
		}
		if (balance < 0d) {
			throw new DomainAccountRunTimeException("Balance : Value must be greater than zero.");
		}
		if (balance < this.getWithDrawLimit()) {
			throw new DomainAccountRunTimeException("The balance can not be less than the limit.");
		}
		this.balance = balance;
	}

	private void setWithDrawLimit(Double withDrawLimit) {
		if (withDrawLimit == null) {
			throw new DomainAccountRunTimeException("Limite: Value can not be null.");
		}
		if (withDrawLimit < 0d) {
			throw new DomainAccountRunTimeException("Limite: Value must be greater than zero.");
		}
		if (withDrawLimit > this.getBalance()) {
			throw new DomainAccountRunTimeException("The limit can not be greater than the balance.");
		}
		this.withDrawLimit = withDrawLimit;
	}

	
	
	
	@Override
	public String toString() {
		return "Account [number=" + this.getNumber() 
				+ ", holder=" + this.getHolder() 
				+ ", balance=" + String.format("%.2f", this.getBalance()) 
				+ ", withDrawLimit="+  String.format("%.2f", this.getWithDrawLimit()) 
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Account other = (Account) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
}
