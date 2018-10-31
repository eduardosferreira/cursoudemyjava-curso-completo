package com.curse.udemy.joo.section12.contract.model.services;

public interface OnlinePaymentService {

	double paymentFree(double ammount);
	
	double interest(double ammount, long month);
	
	double quota(double ammount, long months);
}
