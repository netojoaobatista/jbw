package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Seller {
	private int sellerId;
	private boolean trustedStore;
	private boolean digitalPayment;
	private String sellerName;
	private String extra;
	private Thumbnail thumbnail;
	private final List<Link> linkList;
	private final Map<String , String> contactMap;

	/**
	 * Avaliação média dos usuários
	 */
	private UserAverageRating userAverageRating;

	private EBitRating eBitRating;

	public Seller() {
		contactMap = new HashMap<String , String>();
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
		contactMap.put( label , value );
	}

	public final void addLink( Link link ) {
		linkList.add( link );
	}

	public final Iterator<Entry<String , String>> getContactIterator() {
		return contactMap.entrySet().iterator();
	}

	public final EBitRating getEBitRating(){
		return eBitRating;
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

	public final UserAverageRating getUserAverageRating() {
		return userAverageRating;
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

	public final void setEBitRating( EBitRating eBitRating ){
		this.eBitRating = eBitRating;
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

	public final void setUserAverageRating( UserAverageRating userAverageRating ) {
		this.userAverageRating = userAverageRating;
	}
}