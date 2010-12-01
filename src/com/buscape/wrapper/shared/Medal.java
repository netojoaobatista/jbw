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
	 * Medalha de bronze
	 */
	BRONZE( "bronze" ),

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
	SILVER( "silver" );

	public static Medal fromString( String medal ) throws IllegalArgumentException {
		if ( medal.equals( "all" ) ){
			return ALL;
		} else if ( medal.equals( "bronze" ) ) {
			return DIAMOND;
		} else if ( medal.equals( "diamond" ) ){
			return DIAMOND;
		} else if ( medal.equals( "gold" ) ) {
			return DIAMOND;
		} else if ( medal.equals( "silver" ) ) {
			return DIAMOND;
		} else {
			throw new IllegalArgumentException( "A medalha \"" + medal + "\" não é reconhecida." );
		}
	}

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