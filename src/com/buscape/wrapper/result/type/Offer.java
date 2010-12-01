package com.buscape.wrapper.result.type;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Offer {
	private int offerId;
	private int categoryId;
	private final List<Link> linkList;
	private boolean lomadeelink;
	private String offerName;
	private Price price;
	private int productId;
	private Seller seller;
	private Thumbnail thumbnail;

	public Offer() {
		linkList = new ArrayList<Link>();
	}

	public Offer( int offerId ) {
		this();
		this.offerId = offerId;
	}

	public Offer( int offerId , String offerName ) {
		this( offerId );
		this.offerName = offerName;
	}

	public final void addLink( Link link ) {
		linkList.add( link );
	}

	public final int getCategoryId() {
		return categoryId;
	}

	public final Iterator<Link> getLinkIterator(){
		return linkList.iterator();
	}

	public final String getName() {
		return offerName;
	}

	public final int getOfferId() {
		return offerId;
	}

	public final Price getPrice() {
		return price;
	}

	public final int getProductId() {
		return productId;
	}

	public final Seller getSeller() {
		return seller;
	}

	public final Thumbnail getThumbnail() {
		return thumbnail;
	}

	public final boolean hasLomadeeLink(){
		return lomadeelink;
	}

	public final void setCategoryId( int categoryId ) {
		this.categoryId = categoryId;
	}

	public final void setHasLomadeeLink( boolean haslomadeelink ){
		lomadeelink = haslomadeelink;
	}

	public final void setOfferId( int offerId ) {
		this.offerId = offerId;
	}

	public final void setOfferName( String offerName ) {
		this.offerName = offerName;
	}

	public final void setPrice( Price price ) {
		this.price = price;
	}

	public final void setProductId( int productId ) {
		this.productId = productId;
	}

	public final void setSeller( Seller seller ) {
		this.seller = seller;
	}

	public final void setThumbnail( Thumbnail thumbnail ) {
		this.thumbnail = thumbnail;
	}
}