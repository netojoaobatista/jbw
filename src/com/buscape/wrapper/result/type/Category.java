package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * O serviço de procura de categorias permite que sejam exibidas informações
 * relativas às categorias. É possível obter categorias, produtos ou ofertas
 * informando apenas um ID de categoria.
 * 
 * @author neto
 */
public class Category {
	/**
	 * ID da categoria
	 */
	private int categoryId;

	/**
	 * Nome da categoria
	 */
	private String name;

	/**
	 * ID da categoria pai
	 */
	private int parentCategoryId;

	/**
	 * TRUE caso haja ofertas para a categoria
	 */
	private boolean hasOffer = false;

	/**
	 * TRUE caso seja uma categoria final
	 */
	private boolean isFinal = false;

	/**
	 * Lista de links
	 */
	private final List<Link> linkList;

	/**
	 * Lista de sub-categorias
	 */
	private final List<Category> subCategoryList;

	/**
	 * Lista de categorias top5
	 */
	private final List<Category> top5CategoryList;

	/**
	 * Imagem da categoria
	 */
	private Thumbnail thumbnail;

	/**
	 * Constroi o objeto da categoria
	 */
	public Category(){
		this( false , false );
	}

	/**
	 * Constroi o objeto da categoria
	 * 
	 * @param isfinal
	 *            TRUE caso seja uma categoria final
	 * @param hasoffer
	 *            TRUE caso haja ofertas para a categoria
	 */
	public Category( boolean isfinal , boolean hasoffer ) {
		linkList = new ArrayList<Link>();
		subCategoryList = new ArrayList<Category>();
		top5CategoryList = new ArrayList<Category>();

		hasOffer = hasoffer;
		isFinal = isfinal;
	}

	/**
	 * Adiciona um link à categoria
	 * 
	 * @param link
	 */
	public void addLink( Link link ) {
		linkList.add( link );
	}

	/**
	 * Adiciona uma sub-categoria à categoria
	 * 
	 * @param category
	 */
	public void addSubCategory( Category category ){
		subCategoryList.add( category );
	}

	/**
	 * Adiciona uma categoria top5 à categoria
	 * 
	 * @param category
	 */
	public void addTop5Category( Category category ){
		top5CategoryList.add( category );
	}

	/**
	 * @return O ID da categoria
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @return Iterator de Links
	 */
	public Iterator<Link> getLinkIterator() {
		return linkList.iterator();
	}

	/**
	 * @return O nome da categoria
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return O ID da categoria pai
	 */
	public int getParentCategoryId() {
		return parentCategoryId;
	}

	/**
	 * @return Iterator de sub-categorias
	 */
	public Iterator<Category> getSubCategoryIterator() {
		return subCategoryList.iterator();
	}

	/**
	 * @return A imagem da categoria
	 */
	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	/**
	 * @return Iterator de categorias Top5
	 */
	public Iterator<Category> getTop5CategoryIterator() {
		return top5CategoryList.iterator();
	}

	/**
	 * @return TRUE se houver ofertas para a categoria
	 */
	public boolean hasOffer() {
		return hasOffer;
	}

	/**
	 * @return TRUE se for uma categoria final
	 */
	public boolean isFinal() {
		return isFinal;
	}

	/**
	 * Define o ID da categoria
	 * 
	 * @param categoryId
	 */
	public void setCategoryId( int categoryId ) {
		this.categoryId = categoryId;
	}

	/**
	 * Define o nome da categoria
	 * 
	 * @param name
	 */
	public void setName( String name ) {
		this.name = name;
	}

	/**
	 * Define o ID da categoria pai
	 * 
	 * @param parentCategoryId
	 */
	public void setParentCategoryID( int parentCategoryId ) {
		this.parentCategoryId = parentCategoryId;
	}

	/**
	 * Define a imagem da categoria
	 * 
	 * @param thumbnail
	 */
	public void setThumbnail( Thumbnail thumbnail ) {
		this.thumbnail = thumbnail;
	}
}