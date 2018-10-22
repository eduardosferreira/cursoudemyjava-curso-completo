package com.curse.udemy.joo.section8.entities.enums;

public enum WorkerLevel {
	
	JUNIOR(1L,"Iniciante[Junior]"),
	MID_LEVEL(2L,"Pleno"),
	SENIOR(3L,"Senior");

	
	private Long    id;
	private String  name;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	private WorkerLevel(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public static WorkerLevel toEnum(Long id) {
		
		if (id == null) {
			return null;
		}
		
		for (WorkerLevel x : WorkerLevel.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Invalid: " + id);
	}
	

}
