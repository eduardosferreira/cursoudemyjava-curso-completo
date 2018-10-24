package com.curse.udemy.joo.section9.entities;

import com.curse.udemy.joo.section9.entities.enums.Color;

public class Circle extends Shape {

	private Double radius;
	
	public Circle(Color color,Double radius) {
		super(color);
		this.radius=radius;
	}

	@Override
	public Double area() {
		return this.getRadius()*Math.PI;
	}

	public Double getRadius() {
		return radius;
	}


}
