package com.curse.udemy.joo.class45.entities;

import com.curse.udemy.joo.class45.interfacce.Area;

public class Triangle implements Area {
	
	private Double a;
	private Double b;
	private Double c;
	public Double getA() {
		return a;
	}
	public void setA(Double a) {
		this.a = a;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
	public Double getC() {
		return c;
	}
	public void setC(Double c) {
		this.c = c;
	}
	public Triangle() {
		super();
	}
	public Triangle(Double a, Double b, Double c) {
		this();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Double areaTriangle() {
		
		Double p;
		
		p = (this.a + this.b + this.c) / 2.0d;

		return Math.sqrt(p * (p-this.a) * (p-this.b) * (p-this.c));
	
	}
	
	@Override
	public Double areaTriangle(Double a, Double b, Double c) {
		
		Double p;
		
		p = (a + b + c) / 2.0d;

		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	
	}
	
	
	
}
