package com.curse.udemy.joo.section12.rentalcar.model.enums;

import com.curse.udemy.joo.section10.model.exception.DomainAccountRunTimeException;

public enum Color {

	RED(1L,"VERMELHO"),
	BLUE(2L,"AZUL"),
	BLACK(3L,"PRETO"),
	WHITE(2L,"BRANCO");
	
	private Long    id;
	private String  name;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	private Color(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public static Color toEnum(Long id) {
		
		if (id == null) {
			return null;
		}
		
		for (Color x : Color.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new DomainAccountRunTimeException("Id Invalid: " + id);
	}
	
	
	
}
