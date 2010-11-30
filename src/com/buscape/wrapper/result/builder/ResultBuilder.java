package com.buscape.wrapper.result.builder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import com.buscape.wrapper.result.Result;
import com.buscape.wrapper.result.adapter.ArrayAdapter;
import com.buscape.wrapper.result.adapter.ObjectAdapter;
import com.buscape.wrapper.result.type.Category;
import com.buscape.wrapper.result.type.Details;
import com.buscape.wrapper.result.type.Item;
import com.buscape.wrapper.result.type.Link;
import com.buscape.wrapper.result.type.Offer;
import com.buscape.wrapper.result.type.Parcel;
import com.buscape.wrapper.result.type.Price;
import com.buscape.wrapper.result.type.Product;
import com.buscape.wrapper.result.type.Seller;
import com.buscape.wrapper.result.type.Specification;
import com.buscape.wrapper.result.type.Thumbnail;
import com.buscape.wrapper.result.type.UserAverageRating;

public class ResultBuilder {
	protected Result result;

	public ResultBuilder() {
		result = new Result();
	}

	public Category buildCategory() {
		final Category category = new Category();

		result.setCategory( category );

		return category;
	}

	public Category buildCategory( ObjectAdapter adapter ) throws Throwable {
		final Category category = realBuildCategory( adapter );

		result.setCategory( category );

		return category;
	}

	public Date buildDate( ObjectAdapter adapter ) throws Throwable {
		final long year = adapter.getLong( "year" );
		final long month = adapter.getLong( "month" );
		final long day = adapter.getLong( "day" );
		final long hour = adapter.getLong( "hour" );
		final long minute = adapter.getLong( "minute" );
		final long second = adapter.getLong( "second" );
		final long millisecond = adapter.getLong( "millisecond" );

		final SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.S" );

		return format.parse( year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + "." + millisecond );
	}

	public Details buildDetails( ObjectAdapter adapter ) throws Throwable {
		final Details details = new Details( adapter.getInt( "code" ) , buildDate( adapter.getObject( "date" ) ) , adapter.getInt( "elapsedtime" ) , adapter.getString( "message" ) , adapter.getString( "status" ) );

		result.setDetails( details );

		return details;
	}

	public Item buildItem( ObjectAdapter adapter ) throws Throwable {
		final Item item = new Item( adapter.getString( "label" ) );
		final ArrayAdapter valueArray = adapter.getArray( "value" );

		for ( int i = 0 , t = valueArray.length() ; i < t ; ++i ){
			item.addValue( valueArray.getString( i ) );
		}

		return item;
	}

	public Link buildLink( ObjectAdapter adapter ) throws Throwable {
		final Link link = new Link( adapter.getString( "type" ) , adapter.getString( "url" ) );

		return link;
	}

	public void buildOffer( ArrayAdapter adapter ) throws Throwable {
		for ( int i = 0 , t = adapter.length() ; i < t ; ++i ){
			result.addOffer( realBuildOffer( adapter.getObject( i ).getObject( "offer" ) ) );
		}
	}

	public Parcel buildParcel( ObjectAdapter adapter ) throws Throwable {
		final Parcel parcel = new Parcel( adapter.getDouble( "value" ) , adapter.getInt( "number" ) , adapter.getDouble( "interest" ) );

		return parcel;
	}

	public Price buildPrice( ObjectAdapter adapter ) throws Throwable {
		final Price price = new Price( adapter.getDouble( "value" ) );

		if ( adapter.has( "parcel" ) ) {
			price.setParcel( buildParcel( adapter.getObject( "parcel" ) ) );
		}

		return price;
	}

	public List<Product> buildProduct( ArrayAdapter adapter ) throws Throwable {
		final List<Product> productList = new ArrayList<Product>();

		for ( int i = 0 , t = adapter.length() ; i < t ; ++i ){
			final ObjectAdapter productAdapter = adapter.getObject( i ).getObject( "product" );
			final Product product = realBuildProduct( productAdapter );

			if ( productAdapter.has( "specification" ) ) {
				try {
					product.setSpecification( buildSpecification( productAdapter.getObject( "specification" ) ) );
				} catch ( final JSONException e ) {
					// wtf :-/
				}
			}

			result.addProduct( product );
		}

		return productList;
	}

	public Seller buildSeller( ObjectAdapter adapter ) throws Throwable {
		int i,t;
		final Seller seller = new Seller( adapter.getInt( "id" ) , adapter.getString( "sellername" ) );
		seller.setThumbnail( buildThumbnail( adapter.getObject( "thumbnail" ) ) );
		seller.setExtra( adapter.getString( "extra" ) );
		seller.setUserAverageRating( buildUserAverageRating( adapter.getObject( "rating" ).getObject( "useraveragerating" ) ) );
		seller.setTrustedStore( adapter.getBoolean( "istrustedstore" ) );
		seller.setDigitalPayment( adapter.getBoolean( "pagamentodigital" ) );

		final ArrayAdapter linkArray = adapter.getArray( "links" );

		for ( i = 0 , t = linkArray.length() ; i < t ; ++i ){
			seller.addLink( buildLink( linkArray.getObject( i ).getObject( "link" ) ) );
		}

		final ArrayAdapter contactArray = adapter.getArray( "contacts" );

		for ( i = 0 , t = contactArray.length() ; i < t ; ++i ){
			final ObjectAdapter contact = contactArray.getObject( i ).getObject( "contact" );

			seller.addContact( contact.getString( "label" ) , contact.getString( "value" ) );
		}

		return seller;
	}

	public Specification buildSpecification( ObjectAdapter adapter ) throws Throwable {
		int i, t;
		final Specification specification = new Specification();
		final ArrayAdapter itemArray = adapter.getArray( "item" );

		for ( i = 0, t = itemArray.length() ; i < t ; ++i ) {
			specification.addItem( buildItem( itemArray.getObject( i ).getObject( "item" ) ) );
		}

		if ( adapter.has( "links" ) ) {
			final ArrayAdapter linkArray = adapter.getArray( "links" );

			for ( i = 0, t = linkArray.length() ; i < t ; ++i ) {
				specification.addLink( buildLink( linkArray.getObject( i ).getObject( "link" ) ) );
			}
		}

		return specification;
	}

	public void buildSubCategoryList( ArrayAdapter adapter ) throws Throwable {
		final Category category = result.getCategory();

		for ( int i = 0 , t = adapter.length() ; i < t ; ++i ){
			final Category subCategory = realBuildCategory( adapter.getObject( i ).getObject( "subcategory" ) );

			if ( subCategory != null ) {
				category.addSubCategory( subCategory );
			}
		}
	}

	public Thumbnail buildThumbnail( ObjectAdapter adapter ) throws Throwable {
		final Thumbnail thumbnail = new Thumbnail();

		thumbnail.setURL( adapter.getString( "url" ) );

		return thumbnail;
	}

	public void buildTop5CategoryList( ArrayAdapter adapter ) throws Throwable {
		final Category category = result.getCategory();

		for ( int i = 0, t = adapter.length() ; i < t ; ++i ) {
			category.addTop5Category( realBuildCategory( adapter.getObject( i ).getObject( "top5category" ) ) );
		}
	}

	public UserAverageRating buildUserAverageRating( ObjectAdapter adapter ) throws Throwable {
		final UserAverageRating userAverageRating = new UserAverageRating();
		final ArrayAdapter linkArray = adapter.getArray( "links" );

		for ( int i = 0, t = linkArray.length() ; i < t ; ++i ) {
			final Link link = buildLink( linkArray.getObject( i ).getObject( "link" ) );

			userAverageRating.addLink( link );
		}

		userAverageRating.setNumComments( adapter.getInt( "numcomments" ) );
		userAverageRating.setRating( adapter.getDouble( "rating" ) );

		return userAverageRating;
	}

	public Result getResult( ObjectAdapter adapter ) throws Throwable {
		result.setTotalResultsAvailable( adapter.getInt( "totalresultsavailable" ) );
		result.setTotalResultsReturned( adapter.getInt( "totalresultsreturned" ) );

		return result;
	}

	private Category realBuildCategory( ObjectAdapter adapter ) throws Throwable {
		final boolean hasoffer = adapter.has( "hasoffer" ) ? adapter.getBoolean( "hasoffer" ) : false;
		final boolean isfinal = adapter.has( "isfinal" ) ? adapter.getBoolean( "isfinal" ) : false;
		final Category category = new Category( isfinal , hasoffer );

		category.setCategoryId( adapter.getInt( "id" ) );
		category.setName( adapter.getString( "name" ) );
		category.setParentCategoryID( adapter.getInt( "parentcategoryid" ) );

		final ArrayAdapter links = adapter.getArray( "links" );

		for ( int i = 0, t = links.length() ; i < t ; ++i ) {
			category.addLink( buildLink( links.getObject( i ).getObject( "link" ) ) );
		}

		category.setThumbnail( buildThumbnail( adapter.getObject( "thumbnail" ) ) );

		return category;
	}

	private Offer realBuildOffer( ObjectAdapter adapter ) throws Throwable {
		final Offer offer = new Offer( adapter.getInt( "id" ) , adapter.getString( "offername" ) );
		offer.setCategoryId( adapter.getInt( "categoryid" ) );
		offer.setPrice( buildPrice( adapter.getObject( "price" ) ) );
		offer.setProductId( adapter.getInt( "productid" ) );
		offer.setThumbnail( buildThumbnail( adapter.getObject( "thumbnail" ) ) );

		return offer;
	}

	public Product realBuildProduct( ObjectAdapter adapter ) throws Throwable {
		int i, t;
		final Product product = new Product( adapter.getInt( "categoryid" ) , adapter.getInt( "id" ) , adapter.getString( "productname" ) );

		product.setTotalSellers( adapter.getInt( "totalsellers" ) );
		product.setPriceMax( adapter.getDouble( "pricemax" ) );
		product.setPriceMax( adapter.getDouble( "pricemin" ) );
		product.setFullDescription( adapter.getBoolean( "fulldescription" ) );

		if ( adapter.has( "productshortname" ) ) {
			product.setProductShortName( adapter.getString( "productshortname" ) );
		}

		final ArrayAdapter linkArray = adapter.getArray( "links" );

		for ( i = 0, t = linkArray.length() ; i < t ; ++i ) {
			final Link link = buildLink( linkArray.getObject( i ).getObject( "link" ) );

			product.addLink( link );
		}

		product.setThumbnail( buildThumbnail( adapter.getObject( "thumbnail" ) ) );
		product.setRating( buildUserAverageRating( adapter.getObject( "rating" ).getObject( "useraveragerating" ) ) );

		if ( adapter.has( "productdetails" ) ) {
			final ArrayAdapter productDetailsArray = adapter.getArray( "productdetails" );

			for ( i = 0, t = productDetailsArray.length() ; i < t ; ++i ) {
				product.addProductDetails( buildSpecification( productDetailsArray.getObject( i ).getObject( "specification" ) ) );
			}
		}

		return product;
	}
}