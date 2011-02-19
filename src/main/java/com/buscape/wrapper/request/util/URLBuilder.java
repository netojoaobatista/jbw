package com.buscape.wrapper.request.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.buscape.wrapper.request.Country;
import com.buscape.wrapper.request.EBitMedal;
import com.buscape.wrapper.request.Filter;
import com.buscape.wrapper.request.Parameters;
import com.buscape.wrapper.request.Service;
import com.buscape.wrapper.request.Sort;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.util.Messages;


public final class URLBuilder {
	
	private String hostName;	
	private Service service;
	private String applicationId;
	private Country countryCode;
	private Filter filter;
	private Parameters parameters;
	
	public URLBuilder() {
		hostName = Messages.getString("URLBuilder.main-url"); //$NON-NLS-1$
		filter = new Filter();
		parameters= new Parameters();
	}
	
	public URLBuilder service(Service service) {
		this.service = service;
		return this;
	}
	
	public URLBuilder asCategoryListService() {
		service = Service.LIST_CATEGORY;
		return this;
	}
	
	public URLBuilder asProductListService() {
		service = Service.LIST_PRODUCT;
		return this;
	}
	
	public URLBuilder asOfferListService() {
		service = Service.LIST_OFFER;
		return this;
	}
	
	public URLBuilder asTopProductsService() {
		service = Service.TOP_PRODUCTS;
		return this;
	}
		
	public URLBuilder asUserRatingService() {
		service = Service.USER_RATING;
		return this;
	}
	
	public URLBuilder asProductDetailsService() {
		service = Service.DETAILS_PRODUCT;
		return this;
	}
	
	public URLBuilder asSellerDetailsService() {
		service = Service.DETAILS_SELLER;
		return this;
	}
		
	public URLBuilder applicationId(String applicationId) {
		this.applicationId = applicationId;
		return this;
	}
	
	public URLBuilder countryCode(String countryCode) {
		this.countryCode = Country.valueOf(countryCode);
		return this;
	}
	
	public URLBuilder countryCode(Country countryCode) {
		this.countryCode = countryCode;
		return this;
	}
	
	public URLBuilder filter(Filter filter) {
		this.filter = filter;
		return this;
	}
	
	public URLBuilder parameters(Parameters parameters) {
		this.parameters = parameters;
		return this;
	}
	
	public URLBuilder categoryIdParam(String categoryId) {
		parameters.setCategoryId(Integer.parseInt(categoryId));
		return this;
	}
	
	public URLBuilder categoryIdParam(int categoryId) {
		parameters.setCategoryId(categoryId);
		return this;
	}
	
	public URLBuilder productIdParam(String productId) {
		parameters.setProductId(Integer.parseInt(productId));
		return this;
	}

	public URLBuilder productIdParam(int productId) {
		parameters.setProductId(productId);
		return this;
	}	
	
	public URLBuilder sellerIdParam(String sellerId) {
		parameters.setSellerId(Integer.parseInt(sellerId));
		return this;
	}
	
	public URLBuilder sellerIdParam(int sellerId) {
		parameters.setSellerId(sellerId);
		return this;
	}
	
	public URLBuilder keywordParam(String keyword) {
		parameters.setKeyword(keyword);
		return this;
	}
	
	public URLBuilder barcodeParam(String barcode) {
		parameters.setBarcode(barcode);
		return this;
	}	
	
	public URLBuilder formatFilter(String format) {
		filter.setFormat(ResultFormat.valueOf(format));
		return this;
	}
	
	public URLBuilder formatFilter(ResultFormat format) {
		filter.setFormat(format);
		return this;
	}
	
	public URLBuilder resultsFilter(String results) {
		filter.setResults(Integer.parseInt(results));
		return this;
	}
	
	public URLBuilder resultsFilter(int results) {
		filter.setResults(results);
		return this;
	}
	
	public URLBuilder pageFilter(String page) {
		filter.setPage(Integer.parseInt(page));
		return this;
	}
	
	public URLBuilder pageFilter(int page) {
		filter.setPage(page);
		return this;
	}
	
	public URLBuilder priceMinFilter(String priceMin) {
		filter.setPriceMin(Double.parseDouble(priceMin));
		return this;
	}
	
	public URLBuilder priceMinFilter(double priceMin) {
		filter.setPriceMin(priceMin);
		return this;
	}
	
	public URLBuilder priceMaxFilter(String priceMax) {
		filter.setPriceMax(Double.parseDouble(priceMax));
		return this;
	}
	
	public URLBuilder priceMaxFilter(double priceMax) {
		filter.setPriceMax(priceMax);
		return this;
	}
	
	public URLBuilder sortFilter(String sort) {
		filter.setSort(Sort.valueOf(sort));
		return this;
	}
	
	public URLBuilder sortFilter(Sort sort) {
		filter.setSort(sort);
		return this;
	}
	
	public URLBuilder medalFilter(String medal) {
		filter.setMedal(EBitMedal.valueOf(medal));
		return this;
	}	
	
	public URLBuilder medalFilter(EBitMedal medal) {
		filter.setMedal(medal);
		return this;
	}	

	public String build() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(hostName);
		sb.append("/"); //$NON-NLS-1$
		sb.append(service);
		sb.append("/"); //$NON-NLS-1$
		sb.append(applicationId);
		sb.append("/"); //$NON-NLS-1$
		sb.append(countryCode);
		sb.append("/?"); //$NON-NLS-1$
		sb.append(formatFiltersAndParameters());
		
		return sb.toString();		
	}

	private String formatFiltersAndParameters() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(filter.asMap());
		map.putAll(parameters.asMap());
		StringBuilder sb = new StringBuilder();
		
		if ( map.size() > 0 ) {
			for(Entry<String, Object> entry : map.entrySet()) {
				sb.append("&" + entry.getKey() + "=" + entry.getValue()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		
		return sb.substring(1).toString();
	}
	
}
