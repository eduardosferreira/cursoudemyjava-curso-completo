package com.curse.udemy.joo.classAll;

import java.util.Date;
import java.util.Locale;

import com.curse.udemy.joo.classAll.entities.Request;
import com.curse.udemy.joo.classAll.entities.enums.RequestStatus;

public class ProgramClass96Enumeracoes {

	public ProgramClass96Enumeracoes() {
		Locale.setDefault(Locale.US);
	}
	
	public static void Ex1() {
		Request request = new Request(1080l, new Date(), RequestStatus.PENDING_PAYMENT);
	
		System.out.println(request);
	
	}
	
	public static void Ex2() {
	
		RequestStatus rq1 = RequestStatus.DEVILERED;
		RequestStatus rq2 = RequestStatus.valueOf("DEVILERED");
		RequestStatus rq3 = RequestStatus.toEnum(3l);

		System.out.println(rq1 + " - " + rq1.getDescricao());
		System.out.println(rq2 + " - " + rq2.getDescricao());
		System.out.println(rq3 + " - " + rq3.getDescricao());
	
	}
	
	public static void main(String[] args) {
		new ProgramClass96Enumeracoes();
		Ex1();
		Ex2();
	}

}
