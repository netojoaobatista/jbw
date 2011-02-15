package com.buscape.wrapper.result;

import com.buscape.wrapper.util.Messages;

/**
 * Formato da resposta de uma consulta
 * 
 * @author neto
 */
public enum ResultFormat {
	/**
	 * JavaScript Object Notation é o padrão para as requisições
	 */
	JSON( Messages.getString("ResultFormat.json") ), //$NON-NLS-1$

	/**
	 * O formato XML
	 */
	XML( Messages.getString("ResultFormat.xml") ); //$NON-NLS-1$

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