package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Item de uma especificação de um produto
 * 
 * @author neto
 */
public class Item {
	/**
	 * Nome do item
	 */
	private final String label;

	/**
	 * Lista de valores para esse item
	 */
	private final List<String> valueList;

	/**
	 * Constroi o objeto do item da especificação
	 * 
	 * @param label
	 *            Nome do item
	 */
	public Item( String label ) {
		this.label = label;
		valueList = new ArrayList<String>();
	}

	/**
	 * Adiciona um novo valor ao item
	 * 
	 * @param value
	 */
	public void addValue( String value ) {
		valueList.add( value );
	}

	/**
	 * @return Nome do item
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return Iterator de valores do item
	 */
	public Iterator<String> getValueIterator(){
		return valueList.iterator();
	}
}