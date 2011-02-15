package com.buscape.wrapper.result.type;

/**
 * Representação de um endereço para um item, categoria, produto e outros
 * 
 * @author neto
 */
public class Link {
	/**
	 * Tipo do link
	 */
	private String type;

	/**
	 * Endereço do link
	 */
	private String url;

	/**
	 * Constroi um novo link
	 */
	public Link(){
	}

	/**
	 * Constroi um novo link
	 * 
	 * @param type
	 *            Tipo do link
	 * @param url
	 *            Endereço do link
	 */
	public Link( String type , String url ) {
		this.type = type;
		this.url = url;
	}

	/**
	 * @return O tipo do link
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @return O endereço do link
	 */
	public final String getUrl() {
		return url;
	}

	/**
	 * Define o tipo do link
	 * 
	 * @param type
	 */
	public final void setType( String type ) {
		this.type = type;
	}

	/**
	 * Define o endereço do link
	 * 
	 * @param url
	 */
	public final void setUrl( String url ) {
		this.url = url;
	}
}