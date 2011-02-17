package com.buscape.wrapper.request;

import com.buscape.wrapper.util.Messages;


/**
 * Identificador de medalhas eBit
 * 
 * @author neto
 */
public enum Medal {
	/**
	 * Qualquer medalha
	 */
	ALL( Messages.getString("Medal.all") ), //$NON-NLS-1$

	/**
	 * Medalha de bronze
	 */
	BRONZE( Messages.getString("Medal.bronze") ), //$NON-NLS-1$

	/**
	 * Medalha de diamante
	 */
	DIAMOND( Messages.getString("Medal.diamond") ), //$NON-NLS-1$

	/**
	 * Medalha de ouro
	 */
	GOLD( Messages.getString("Medal.gold") ), //$NON-NLS-1$

	/**
	 * Medalha de prata
	 */
	SILVER( Messages.getString("Medal.silver") ); //$NON-NLS-1$

	public static Medal fromString( String medal ) throws IllegalArgumentException {
		if ( medal.equals( Messages.getString("Medal.all") ) ){ //$NON-NLS-1$
			return ALL;
		} else if ( medal.equals( Messages.getString("Medal.bronze") ) ) { //$NON-NLS-1$
			return DIAMOND;
		} else if ( medal.equals( Messages.getString("Medal.diamond") ) ){ //$NON-NLS-1$
			return DIAMOND;
		} else if ( medal.equals( Messages.getString("Medal.gold") ) ) { //$NON-NLS-1$
			return DIAMOND;
		} else if ( medal.equals( Messages.getString("Medal.silver") ) ) { //$NON-NLS-1$
			return DIAMOND;
		} else {
			throw new IllegalArgumentException( "A medalha \"" + medal + "\" não é reconhecida." ); //$NON-NLS-1$ //$NON-NLS-2$
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