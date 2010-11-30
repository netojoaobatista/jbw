package com.buscape.wrapper.shared;

/**
 * Identificador de medalhas eBit
 * 
 * @author neto
 */
public enum Medal {
	/**
	 * Qualquer medalha
	 */
	ALL( "all" ),

	/**
	 * Medalha de diamante
	 */
	DIAMOND( "diamond" ),

	/**
	 * Medalha de ouro
	 */
	GOLD( "gold" ),

	/**
	 * Medalha de prata
	 */
	SILVER( "silver" ),

	/**
	 * Medalha de bronze
	 */
	BRONZE( "bronze" );

	private String medal;

	Medal( String medal ) {
		this.medal = medal;
	}

	/**
	 * @return Representação em String da medalha
	 */
	@Override
	public String toString() {
		return medal;
	}
}