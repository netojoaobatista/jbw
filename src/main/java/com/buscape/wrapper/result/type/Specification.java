package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Detalhes de um produto
 * 
 * @author neto
 */
public class Specification {
	/**
	 * Lista de links
	 */
	@SerializedName("links")
	private final List<Link> linkList;

	/**
	 * Lista de itens
	 */
	@SerializedName("item")
	private final List<Item> itemList;

	/**
	 * Constroi o objeto de detalhes do produto
	 */
	public Specification() {
		linkList = new ArrayList<Link>();
		itemList = new ArrayList<Item>();
	}

	/**
	 * Adiciona um item da especificação
	 * 
	 * @param item
	 */
	public void addItem( Item item ) {
		itemList.add( item );
	}

	/**
	 * Adiciona um link da especificação
	 * 
	 * @param link
	 */
	public void addLink( Link link ) {
		linkList.add( link );
	}

	/**
	 * @return Iterator de itens
	 */
	public Iterator<Item> getItemIterator() {
		return itemList.iterator();
	}

	/**
	 * @return Iterator de links
	 */
	public Iterator<Link> getLinkIterator(){
		return linkList.iterator();
	}
}
