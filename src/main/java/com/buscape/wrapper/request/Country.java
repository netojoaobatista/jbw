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
	ARGENTINA(Messages.getString("Country.argentina")), //$NON-NLS-1$

	/**
	 * Brasil
	 */
	BRAZIL(Messages.getString("Country.brasil")), //$NON-NLS-1$

	/**
	 * Chile
	 */
	CHILE(Messages.getString("Country.chile")), //$NON-NLS-1$

	/**
	 * Colômbia
	 */
	COLOMBIA(Messages.getString("Country.colombia")), //$NON-NLS-1$

	/**
	 * México
	 */
	MEXICO(Messages.getString("Country.mexico")), //$NON-NLS-1$

	/**
	 * Peru
	 */
	PERU(Messages.getString("Country.peru")), //$NON-NLS-1$

	/**
	 * Venezuela
	 */
	VENEZUELA(Messages.getString("Country.venezuela")); //$NON-NLS-1$

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