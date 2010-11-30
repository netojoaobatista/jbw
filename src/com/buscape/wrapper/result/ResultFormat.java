package com.buscape.wrapper.result;

/**
 * Formato da resposta de uma consulta
 * 
 * @author neto
 */
public enum ResultFormat {
	/**
	 * JavaScript Object Notation é o padrão para as requisições
	 */
	JSON( "json" ),

	/**
	 * O formato XML
	 */
	XML( "xml" );

	/**
	 * Formato da resposta de uma consulta
	 */
	private String format;

	/**
	 * @param format
	 */
	private ResultFormat( String format ) {
		this.format = format;
	}

	@Override
	public String toString() {
		return format;
	}
}