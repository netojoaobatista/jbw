package com.buscape.wrapper.result.type;

/**
 * Representação de uma imagem
 * 
 * @author neto
 */
public class Thumbnail {
	/**
	 * Endereço da imagem
	 */
	private String url;

	/**
	 * Constroi o objeto que representa a imagem
	 */
	public Thumbnail() {
	}

	/**
	 * Constroi o objeto que representa a imagem
	 * 
	 * @param url
	 *            O endereço da imagem
	 */
	public Thumbnail( String url ) {
		this.url = url;
	}

	/**
	 * @return O endereço da imagem
	 */
	public String getURL(){
		return url;
	}

	/**
	 * Define o endereço da imagem
	 * 
	 * @param url
	 */
	public void setURL( String url ) {
		this.url = url;
	}
}