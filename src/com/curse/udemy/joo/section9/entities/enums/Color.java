package com.curse.udemy.joo.section9.entities.enums;

public enum Color {
	

	BLACK(1L,"Preto"),
	BLUE(2L,"Azul"),
	RED(3L,"Vermelho");
	
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
		
		throw new IllegalArgumentException("Id Invalid: " + id);
	}
	

}
