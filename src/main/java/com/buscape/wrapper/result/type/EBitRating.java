package com.buscape.wrapper.result.type;


/**
 * Avaliação eBit
 * 
 * @author neto
 */
public class EBitRating {
	/**
	 * Medalha eBit
	 */
	private String rating;

	/**
	 * Número de comentários
	 */
	private int numComments;

	public EBitRating() {
	}

	public EBitRating( int numComments ) {
		this.numComments = numComments;
	}

	public final int getNumComments() {
		return numComments;
	}

	public final String getRating() {
		return rating;
	}

	public final void setNumComments( int numComments ) {
		this.numComments = numComments;
	}

	public final void setRating( String rating ) {
		this.rating = rating;
	}
}