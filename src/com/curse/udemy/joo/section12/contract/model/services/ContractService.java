package com.curse.udemy.joo.section12.contract.model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.curse.udemy.joo.section12.contract.model.entities.Contract;
import com.curse.udemy.joo.section12.contract.model.entities.Installment;
import com.curse.udemy.joo.section12.contract.model.exception.DomainException;

public class ContractService {
	
	
	private OnlinePaymentService onlinePaymentService;
	private OnlinePaymentService getOnlinePaymentService() {
		return this.onlinePaymentService;
	}
	private void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		super();
		this.setOnlinePaymentService(onlinePaymentService);
	}
	
	public void processContract(Contract contract, long months) throws DomainException {
		if (months <= 0) 
			throw new DomainException("Value month invalid! " + months);
		
		List<Installment> list = new ArrayList<>();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(contract.getDate());
		double quota = this.getOnlinePaymentService().quota(contract.getTotalValue(), months);
		for (int i = 1; i <= months; i++) {
			gc.add(Calendar.MONTH, 1);
			list.add(new Installment(gc.getTime(), this.getOnlinePaymentService().paymentFree(this.getOnlinePaymentService().interest(quota, (long)i))));
		}
		contract.setList(list);
		
	}


	
}
