package com.buscape.wrapper.request;

/**
 * Código do país que será utilizado na requisição
 * 
 * @author neto
 */
public enum Country {
	/**
	 * Argentina
	 */
	ARGENTINA("AR"),

	/**
	 * Brasil
	 */
	BRAZIL("BR"),

	/**
	 * Chile
	 */
	CHILE("CL"),

	/**
	 * Colômbia
	 */
	COLOMBIA("CO"),

	/**
	 * México
	 */
	MEXICO("ME"),

	/**
	 * Peru
	 */
	PERU("PE"),

	/**
	 * Venezuela
	 */
	VENEZUELA("VE");

	/**
	 * Código do país
	 */
	private String code;

	Country( String code ){
		this.code = code;
	}

	/**
	 * @return O código do país
	 */
	public String code(){
		return code;
	}

	@Override
	public String toString(){
		return code;
	}
}