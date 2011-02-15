package com.buscape.wrapper.result.adapter;


public interface Adaptable<T> {

	T getDetails();

	T getCategory();

	T getSubcategory();

	T getTop5Category();

	T getProduct();

	T getOffer();

	boolean hasDetails();

	boolean hasCategory();

	boolean hasSubcategory();

	boolean hasTop5Category();

	boolean hasProduct();

	boolean hasOffer();

}