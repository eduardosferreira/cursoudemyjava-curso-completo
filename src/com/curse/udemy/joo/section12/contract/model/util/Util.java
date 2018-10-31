package com.curse.udemy.joo.section12.contract.model.util;

public class Util {

	//Parâmetros:
	/**
	 *  1 - Valor a arredondar.
	 *  2 - Quantidade de decimal depois da vírgula.
	 *  3 - Arredondar para cima ou para baixo?
	 *          Para cima = 0 (ceil)
	 *          Para baixo = 1 ou qualquer outro inteiro (floor)
	 **/
	public static double round(double value, int decimal, int ceilOrFloor) {
	    double rounded = value;
	    rounded *= (Math.pow(10, decimal));
	    if (ceilOrFloor == 0) {
	        rounded = Math.ceil(rounded);           
	    } else {
	        rounded = Math.floor(rounded);
	    }
	    rounded /= (Math.pow(10, decimal));
	    return rounded;
	}
}
