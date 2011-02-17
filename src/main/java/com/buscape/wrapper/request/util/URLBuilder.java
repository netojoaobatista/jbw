package com.buscape.wrapper.request.util;

import java.util.Map;
import java.util.Map.Entry;

import com.buscape.wrapper.request.Country;
import com.buscape.wrapper.request.Filter;
import com.buscape.wrapper.request.Medal;
import com.buscape.wrapper.request.Service;
import com.buscape.wrapper.request.Sort;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.util.Messages;


public class URLBuilder {
	
	private String hostName;	
	private Service service;
	private String applicationId;
	private Country countryCode;
	private Filter filter;
	
	public URLBuilder() {
		hostName = Messages.getString("URLBuilder.main-url"); //$NON-NLS-1$
		filter = new Filter();
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
	
	public URLBuilder filter(Filter parameters) {
		this.filter = parameters;
		return this;
	}
	
	public URLBuilder categoryIdFilter(String categoryId) {
		filter.setCategoryId(Integer.parseInt(categoryId));
		return this;
	}
	
	public URLBuilder categoryIdFilter(int categoryId) {
		filter.setCategoryId(categoryId);
		return this;
	}
	
	public URLBuilder productIdFilter(String productId) {
		filter.setProductId(Integer.parseInt(productId));
		return this;
	}

	public URLBuilder productIdFilter(int productId) {
		filter.setProductId(productId);
		return this;
	}	
	
	public URLBuilder sellerIdFilter(String sellerId) {
		filter.setSellerId(Integer.parseInt(sellerId));
		return this;
	}
	
	public URLBuilder sellerIdFilter(int sellerId) {
		filter.setSellerId(sellerId);
		return this;
	}
	
	public URLBuilder keywordFilter(String keyword) {
		filter.setKeyword(keyword);
		return this;
	}
	
	public URLBuilder barcodeFilter(String barcode) {
		filter.setBarcode(barcode);
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
		filter.setMedal(Medal.valueOf(medal));
		return this;
	}	
	
	public URLBuilder medalFilter(Medal medal) {
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
		sb.append(formatParameters());
		
		return sb.toString();		
	}

	private String formatParameters() {
		Map<String, Object> paramsMap = filter.asMap();
		StringBuilder sb = new StringBuilder();
		
		if ( paramsMap.size() > 0 ) {
			for(Entry<String, Object> entry : paramsMap.entrySet()) {
				sb.append("&" + entry.getKey() + "=" + entry.getValue()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		
		return sb.substring(1).toString();
	}
	
}
