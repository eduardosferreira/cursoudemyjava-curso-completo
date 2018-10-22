package com.curse.udemy.joo.classAll.entities.enums;

public enum RequestStatus {

	PENDING_PAYMENT(1L,"Pendencia de Pagamento"),
	PROCESSING(2L,"Processando"),
	SHIPPED(3L,"Enviado"),
	DEVILERED(4L,"Entregue");

	
	private Long    id;
	private String  descricao;
	
	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	private RequestStatus(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public static RequestStatus toEnum(Long id) {
		
		if (id == null) {
			return null;
		}
		
		for (RequestStatus x : RequestStatus.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
	
	
}
