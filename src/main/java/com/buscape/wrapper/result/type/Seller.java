package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Seller {
	@SerializedName("id")
	private int sellerId;
	@SerializedName("istrustedstore")
	private boolean trustedStore;
	@SerializedName("pagamentodigital")
	private boolean digitalPayment;
	@SerializedName("sellername")
	private String sellerName;
	private String extra;
	private Thumbnail thumbnail;
	@SerializedName("links")
	private final List<Link> linkList;
	@SerializedName("contacts")
	private final List<Contact> contactMap;
	private Rating rating;

	public Seller() {
		contactMap = new ArrayList<Contact>();
		linkList = new ArrayList<Link>();
	}

	public Seller( int sellerId ) {
		this();
		this.sellerId = sellerId;
	}

	public Seller( int sellerId , String sellerName ) {
		this( sellerId );
		this.sellerName = sellerName;
	}

	public final void addContact( String label , String value ) {
		contactMap.add(new Contact(label , value ));
	}

	public final void addLink( Link link ) {
		linkList.add( link );
	}

	public final Iterator<Contact> getContactIterator() {
		return contactMap.iterator();
	}

	public final String getExtra() {
		return extra;
	}

	public final String getName() {
		return sellerName;
	}

	public final int getSellerId() {
		return sellerId;
	}

	public final Thumbnail getThumbnail() {
		return thumbnail;
	}

	public final boolean hasDigitalPayment() {
		return digitalPayment;
	}

	public final boolean isTrustedStore() {
		return trustedStore;
	}

	public final void setDigitalPayment( boolean digitalPayment ){
		this.digitalPayment = digitalPayment;
	}


	public final void setExtra( String extra ) {
		this.extra = extra;
	}

	public final void setSellerId( int sellerId ) {
		this.sellerId = sellerId;
	}

	public final void setSellerName( String sellerName ) {
		this.sellerName = sellerName;
	}

	public final void setThumbnail( Thumbnail thumbnail ) {
		this.thumbnail = thumbnail;
	}

	public final void setTrustedStore( boolean trustedStore ) {
		this.trustedStore = trustedStore;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}