package com.buscape.wrapper.result;

import com.buscape.wrapper.util.Messages;

/**
 * Format of API call response.
 * 
 * @author neto
 */
public enum ResultFormat {
	/**
	 * JSON format
	 */
	JSON( Messages.getString("ResultFormat.json") ), //$NON-NLS-1$

	/**
	 * XML format
	 */
	XML( Messages.getString("ResultFormat.xml") ); //$NON-NLS-1$


	private String format;

	private ResultFormat( String format ) {
		this.format = format;
	}

	@Override
	public String toString() {
		return format;
	}
}