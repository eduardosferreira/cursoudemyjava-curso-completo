package com.curse.udemy.joo.classAll.util;

import java.util.Scanner;

public class CurrencyConverter {

	public static final Double MOEDA_EUROS = 5.1012d;
	public static Scanner sc;
	
	public CurrencyConverter() {
		super();
	}
	
	public static Double ConverterDollar(Long quantity, Double converter) {
		return quantity*converter;
	}
	
	
	

}
