package com.buscape.wrapper.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.buscape.wrapper.result.type.Category;
import com.buscape.wrapper.result.type.Details;
import com.buscape.wrapper.result.type.Offer;
import com.buscape.wrapper.result.type.Product;

/**
 * Resultados de uma requisição à API do BuscaPè
 * 
 * @author neto
 */
public class Result {
	/**
	 * Total de páginas
	 */
	private int totalPages;

	/**
	 * Número da página atual
	 */
	private int page;

	/**
	 * Total de itens retornados
	 */
	private int totalResultsReturned = 0;

	/**
	 * Total de itens disponíveis
	 */
	private int totalResultsAvailable = 0;

	/**
	 * Retorna o tipo de pesquisa por palavra(s)-chave(s) <li>all: Pesquisa
	 * perfeita, toda(s)palavra(s)-chave(s) encontrada(s)</li> <li>any: Pesquisa
	 * parcial, alguma(s) palavra(s)-chave(s) encontrada(s)</li> <li>none:
	 * Pesquisa não encontrada</li>
	 */
	private String match;

	/**
	 * Detalhes da requisição
	 */
	private Details details;

	/**
	 * Dados da categoria atual
	 */
	private Category category;

	/**
	 * Lista de produtos
	 */
	private List<Product> productList;

	/**
	 * Lista de ofertas
	 */
	private List<Offer> offerList;

	/**
	 * Constroi o objeto de resultados
	 */
	public Result(){
		productList = new ArrayList<Product>();
		offerList = new ArrayList<Offer>();
	}

	/**
	 * Constroi o objeto de resultados
	 * 
	 * @param totalResultsAvailable
	 *            Total de resultados disponíveis
	 * @param totalResultsReturned
	 *            Total de resultados retornados
	 */
	public Result( int totalResultsAvailable , int totalResultsReturned ) {
		this.totalResultsAvailable = totalResultsAvailable;
		this.totalResultsReturned = totalResultsReturned;
	}

	/**
	 * Adiciona uma oferta ao resultado
	 * @param offer A oferta que será adicionada
	 */
	public void addOffer( Offer offer ){
		offerList.add( offer );
	}

	/**
	 * Adiciona um produto ao resultado
	 * 
	 * @param product
	 *            O produto que será adicionado
	 */
	public void addProduct( Product product ) {
		productList.add( product );
	}

	/**
	 * @return A página atual
	 */
	public int currentPage(){
		return page;
	}

	/**
	 * @return A caregoria atual
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @return Os detalhes da requisição
	 */
	public Details getDetails() {
		return details;
	}

	/**
	 * @return Iterator de ofertas
	 */
	public Iterator<Offer> getOfferIterator(){
		return offerList.iterator();
	}

	/**
	 * @return Iterator de produtos
	 */
	public Iterator<Product> getProductIterator(){
		return productList.iterator();
	}

	/**
	 * @return O total de páginas
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return O total de resultados disponíveis
	 */
	public int getTotalResultsAvailable() {
		return totalResultsAvailable;
	}

	/**
	 * @return O total de resultados retornados
	 */
	public int getTotalResultsReturned(){
		return totalResultsReturned;
	}

	/**
	 * Retorna o tipo de pesquisa por palavra(s)-chave(s) <li>all: Pesquisa
	 * perfeita, toda(s)palavra(s)-chave(s) encontrada(s)</li> <li>any: Pesquisa
	 * parcial, alguma(s) palavra(s)-chave(s) encontrada(s)</li> <li>none:
	 * Pesquisa não encontrada</li>
	 * 
	 * @return O tipo de pesquisa por palavra(s)-chave(s)
	 */
	public String matchType() {
		return match;
	}

	/**
	 * Define a categoria atual
	 * 
	 * @param category
	 */
	public void setCategory( Category category ) {
		this.category = category;
	}

	/**
	 * Define os detalhes da requisição
	 * 
	 * @param details
	 */
	public void setDetails( Details details ) {
		this.details = details;
	}

	/**
	 * Define o total de resultados disponíveis
	 * 
	 * @param totalResultsAvailable
	 */
	public void setTotalResultsAvailable( int totalResultsAvailable ) {
		this.totalResultsAvailable = totalResultsAvailable;
	}

	/**
	 * Define o total de resultados retornados
	 * 
	 * @param totalResultsReturned
	 */
	public void setTotalResultsReturned( int totalResultsReturned ) {
		this.totalResultsReturned = totalResultsReturned;
	}
}