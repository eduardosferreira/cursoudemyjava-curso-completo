package com.curse.udemy.joo.classAll.entities.sub;

import com.curse.udemy.joo.classAll.entities.Product;

public class Detail  {

	private Product product;
	
	public Detail(Product product) {
		this.product = product;
		
		//this.product.nro_private   = 1L; // nao tem acesso, pois e privado
		//this.product.nro_default   = 1L; // não tem tem acesso, pois não está na mesma pasta, mesmo sendo uma subpasta
		//this.product.nro_protected = 1L; // não tem acesso, pois não existe herança desta classe e não está na mesma pasta 
		this.product.nro_public    = 1L; // tem acesso, pois e visivel a todos
		
	}

}
