package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Média da avaliação dos usuários
 * 
 * @author neto
 */
public class UserAverageRating {
	/**
	 * Número de comentários
	 */
	private int numComments;

	/**
	 * Média da avaliação
	 */
	private double rating;

	/**
	 * Lista de links
	 */
	private final List<Link> linkList;

	/**
	 * Constroi o objeto que representa a média da avaliação dos usuários
	 */
	public UserAverageRating() {
		linkList = new ArrayList<Link>();
	}

	/**
	 * Constroi o objeto que representa a média da avaliação dos usuários
	 * 
	 * @param numComments
	 *            Número de comentários
	 * @param rating
	 *            Avaliação média
	 */
	public UserAverageRating( int numComments , double rating ) {
		this();
		this.numComments = numComments;
		this.rating = rating;
	}

	/**
	 * Adiciona um link
	 * 
	 * @param link
	 */
	public void addLink( Link link ) {
		linkList.add( link );
	}

	/**
	 * @return Iterator de links
	 */
	public Iterator<Link> getLinkIterator() {
		return linkList.iterator();
	}

	/**
	 * @return Número de comentários
	 */
	public int getNumComments() {
		return numComments;
	}

	/**
	 * @return Avaliação média dos usuários
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Define o número de comentários
	 * 
	 * @param numComments
	 */
	public void setNumComments( int numComments ) {
		this.numComments = numComments;
	}

	/**
	 * Define a média da avaliação dos usuários
	 * 
	 * @param rating
	 */
	public void setRating( double rating ) {
		this.rating = rating;
	}
}