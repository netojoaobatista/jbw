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
	AR( "AR" ),

	/**
	 * Brasil
	 */
	BR( "BR" ),

	/**
	 * Chile
	 */
	CL( "CL" ),

	/**
	 * Colômbia
	 */
	CO( "CO" ),

	/**
	 * México
	 */
	MX( "MX" ),

	/**
	 * Peru
	 */
	PE( "PE" ),

	/**
	 * Venezuela
	 */
	VE( "VE" );

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