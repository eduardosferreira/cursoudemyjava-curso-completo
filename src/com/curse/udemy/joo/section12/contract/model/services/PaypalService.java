package com.curse.udemy.joo.section12.contract.model.services;

import com.curse.udemy.joo.section12.contract.model.util.Util;

public class PaypalService implements OnlinePaymentService {

	private static final double PERCENTAGE_INTEREST = 2d;
	private static final double PERCENTAGE_INTEREST_FIXO = 1d;
	@Override
	public double paymentFree(double ammount) {
		return (double) ammount + ((ammount * PERCENTAGE_INTEREST) / 100.00d);
	}

	@Override
	public double interest(double ammount, long month) {
		return (double) ammount + (((ammount * PERCENTAGE_INTEREST_FIXO)/100.00d) * month);
	}

	@Override
	public double quota(double ammount, long months) {
		return Util.round((double)ammount / months, 2, 0);
	}

	
	
}
