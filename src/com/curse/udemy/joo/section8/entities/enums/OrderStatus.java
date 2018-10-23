package com.curse.udemy.joo.section8.entities.enums;

public enum OrderStatus {
	

	PENDING_PAYMENT(1L,"Pagamento Pendente"),
	PROCESSING(2L,"Processando"),
	SHIPPED(3L,"Pago"),
	DELIVERED(4L,"Entregue");
	
	private Long    id;
	private String  name;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	private OrderStatus(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public static OrderStatus toEnum(Long id) {
		
		if (id == null) {
			return null;
		}
		
		for (OrderStatus x : OrderStatus.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Invalid: " + id);
	}
	

}
