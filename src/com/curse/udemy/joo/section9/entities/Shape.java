package com.curse.udemy.joo.section9.entities;

import com.curse.udemy.joo.section9.entities.enums.Color;

public abstract class Shape {

	private Color color;

	public Color getColor() {
		return color;
	}

	public Shape(Color color) {
		this.color = color;
	}
	
	public abstract Double area();

	@Override
	public String toString() {
		return " [color=" + color + "] Area : " +String.format("%.2f\n", this.area());
	}
	
	
	
}
