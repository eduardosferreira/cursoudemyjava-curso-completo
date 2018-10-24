package com.curse.udemy.joo.section9.entities;

import com.curse.udemy.joo.section9.entities.enums.Color;

public class Rectangle extends Shape {


	
	private Double width, height;
	
	public Rectangle(Color color,Double width, Double height) {
		super(color);
		this.width=width;
		this.height=height;
	}

	@Override
	public Double area() {
		return this.getHeight()*this.getWidth();
	}

	public Double getWidth() {
		return width;
	}

	public Double getHeight() {
		return height;
	}

}
