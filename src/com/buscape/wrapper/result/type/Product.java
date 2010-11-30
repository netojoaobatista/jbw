package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definição de um produto
 * 
 * @author neto
 */
public class Product {
	/**
	 * ID do produto
	 */
	private int productId;

	/**
	 * ID da categoria do produto
	 */
	private int categoryId;

	/**
	 * Total de vendedores desse produto
	 */
	private int totalSellers;

	/**
	 * Indica se existe uma descrição completa para o produto
	 */
	private boolean fullDescription = false;

	/**
	 * Nome curto do produto
	 */
	private String productShortName;

	/**
	 * Nome do produto
	 */
	private String productName;

	/**
	 * Preço mínimo do produto
	 */
	private double priceMin;

	/**
	 * Preço máximo do produto
	 */
	private double priceMax;

	/**
	 * Lista de links do produto
	 */
	private final List<Link> linkList;

	/**
	 * Imagem do produto
	 */
	private Thumbnail thumbnail;

	/**
	 * Avaliação média dos usuários
	 */
	private UserAverageRating userAverageRating;

	/**
	 * Detalhes do produto
	 */
	private Specification specification;

	/**
	 * Detalhes do produto
	 */
	private final List<Specification> productDetailsList;

	/**
	 * Constroi o objeto do produto
	 */
	public Product() {
		linkList = new ArrayList<Link>();
		productDetailsList = new ArrayList<Specification>();
		userAverageRating = new UserAverageRating();
		specification = new Specification();
	}

	/**
	 * Constroi o objeto do produto
	 * 
	 * @param categoryId
	 *            ID da categoria do produto
	 * @param productId
	 *            ID do produto
	 * @param productName
	 *            Nome do produto
	 */
	public Product( int categoryId , int productId , String productName ) {
		this( productId , productName );
		this.categoryId = categoryId;
	}

	/**
	 * Constroi o objeto do produto
	 * 
	 * @param productId
	 *            ID do produto
	 * @param productName
	 *            Nome do produto
	 */
	public Product( int productId , String productName ) {
		this();
		this.productId = productId;
		this.productName = productName;
	}

	/**
	 * Adiciona um link ao produto
	 * 
	 * @param link
	 */
	public void addLink( Link link ) {
		linkList.add( link );
	}

	/**
	 * Adiciona detalhes do produto
	 * 
	 * @param productDetails
	 */
	public void addProductDetails( Specification productDetails ) {
		productDetailsList.add( productDetails );
	}

	/**
	 * @return O ID da categoria do produto
	 */
	public final int getCategoryId() {
		return categoryId;
	}

	/**
	 * @return Iterator de links
	 */
	public final Iterator<Link> getLinkIterator() {
		return linkList.iterator();
	}

	/**
	 * @return Preço máximo do produto
	 */
	public final double getPriceMax() {
		return priceMax;
	}

	/**
	 * @return Preço mínimo do produto
	 */
	public final double getPriceMin() {
		return priceMin;
	}

	/**
	 * @return Iterator com detalhes do produto
	 */
	public Iterator<Specification> getProductDetailsIterator() {
		return productDetailsList.iterator();
	}

	/**
	 * @return ID do produto
	 */
	public final int getProductId() {
		return productId;
	}

	/**
	 * @return Nome do produto
	 */
	public final String getName() {
		return productName;
	}

	/**
	 * @return Nome curto do produto
	 */
	public final String getShortName() {
		return productShortName;
	}

	/**
	 * @return Detalhes do produto
	 */
	public final Specification getSpecification() {
		return specification;
	}

	/**
	 * @return Imagem do produto
	 */
	public final Thumbnail getThumbnail() {
		return thumbnail;
	}

	/**
	 * @return Total de vendedores do produto
	 */
	public final int getTotalSellers() {
		return totalSellers;
	}

	/**
	 * @return Avaliação média dos usuários
	 */
	public final UserAverageRating getUserAverageRating() {
		return userAverageRating;
	}

	/**
	 * Verifica se existe uma descrição completa para o produto
	 * 
	 * @return TRUE se houver uma descrição completa
	 */
	public boolean hasFullDescription() {
		return fullDescription;
	}

	/**
	 * Define o ID da categoria do produto
	 * 
	 * @param categoryId
	 */
	public final void setCategoryId( int categoryId ) {
		this.categoryId = categoryId;
	}

	/**
	 * Define se existe uma descrição completa para o produto
	 * 
	 * @param fullDescription
	 */
	public final void setFullDescription( boolean fullDescription ) {
		this.fullDescription = fullDescription;
	}

	/**
	 * Define o preço máximo do produto
	 * 
	 * @param priceMax
	 */
	public final void setPriceMax( double priceMax ) {
		this.priceMax = priceMax;
	}

	/**
	 * Define o preço mínimo do produto
	 * 
	 * @param priceMin
	 */
	public final void setPriceMin( double priceMin ) {
		this.priceMin = priceMin;
	}

	/**
	 * Define o ID do produto
	 * 
	 * @param productId
	 */
	public final void setProductId( int productId ) {
		this.productId = productId;
	}

	/**
	 * Define o nome do produto
	 * 
	 * @param productName
	 */
	public final void setProductName( String productName ) {
		this.productName = productName;
	}

	/**
	 * Define o nome curto do produto
	 * 
	 * @param productShortName
	 */
	public final void setProductShortName( String productShortName ) {
		this.productShortName = productShortName;
	}

	/**
	 * Define a avaliação média dos usuários para o produto
	 * 
	 * @param rating
	 */
	public final void setRating( UserAverageRating rating ) {
		userAverageRating = rating;
	}

	/**
	 * Define os detalhes do produto
	 * 
	 * @param specification
	 */
	public final void setSpecification( Specification specification ) {
		this.specification = specification;
	}

	/**
	 * Define a imagem do produto
	 * 
	 * @param thumbnail
	 */
	public final void setThumbnail( Thumbnail thumbnail ) {
		this.thumbnail = thumbnail;
	}

	/**
	 * Define o total de vendedores do produto
	 * 
	 * @param totalSellers
	 */
	public final void setTotalSellers( int totalSellers ) {
		this.totalSellers = totalSellers;
	}
}