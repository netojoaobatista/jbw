package com.buscape.wrapper.request;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.buscape.wrapper.result.ResultFormat;

/**
 * Represents the filters and parameters that can appear in url used to API calls.
 * @author cartagena
 */
public class Filter implements Cloneable {

	private Integer categoryId;
	
	private Integer productId;
	
	private Integer sellerId;
	
	private String keyword;
	
	private String barcode;
	
	private ResultFormat format;
	
	private Integer results;
	
	private Integer page;
	
	private Double priceMin;
	
	private Double priceMax;
	
	private Sort sort;
	
	private EBitMedal medal;

	public Filter() {
	}

	public Filter(Filter base) {
		categoryId = base.categoryId;
		productId = base.productId;
		sellerId = base.sellerId;
		keyword = base.keyword;
		barcode = base.barcode;
		format = base.format;
		results = base.results;
		page = base.page;
		priceMin = base.priceMin;
		priceMax = base.priceMax;
		sort = base.sort;
		medal = base.medal;
	}
	
	
	/**
	 * @return the categoryId
	 */
	public final Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public final void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the productId
	 */
	public final Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public final void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the sellerId
	 */
	public final Integer getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public final void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * @return the keyword
	 */
	public final String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public final void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the barcode
	 */
	public final String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode the barcode to set
	 */
	public final void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the format
	 */
	public final ResultFormat getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public final void setFormat(ResultFormat format) {
		this.format = format;
	}

	/**
	 * @return the results
	 */
	public final Integer getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public final void setResults(Integer results) {
		this.results = results;
	}

	/**
	 * @return the page
	 */
	public final Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public final void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the priceMin
	 */
	public final Double getPriceMin() {
		return priceMin;
	}

	/**
	 * @param priceMin the priceMin to set
	 */
	public final void setPriceMin(Double priceMin) {
		this.priceMin = priceMin;
	}

	/**
	 * @return the priceMax
	 */
	public final Double getPriceMax() {
		return priceMax;
	}

	/**
	 * @param priceMax the priceMax to set
	 */
	public final void setPriceMax(Double priceMax) {
		this.priceMax = priceMax;
	}

	/**
	 * @return the sort
	 */
	public final Sort getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public final void setSort(Sort sort) {
		this.sort = sort;
	}

	/**
	 * @return the medal
	 */
	public final EBitMedal getMedal() {
		return medal;
	}

	/**
	 * @param medal the medal to set
	 */
	public final void setMedal(EBitMedal medal) {
		this.medal = medal;
	}

	/**
	 * Build a {@link Map} that represents this instance. The pair 
	 * key/value of map are the name of fields in object and the values 
	 * of fields, respectively.
	 * @return a {@link Map} populated with the values of this instance.
	 */
	public Map<String, Object> asMap() {
		Map<String, Object> result = new HashMap<String, Object>();

		for (Field field : getClass().getDeclaredFields()) {
			try {
				String fieldName = field.getName();
				Method getter = getClass().getMethod(buildGetterName(fieldName));
				Object fieldValue = getter.invoke(this);
				if (fieldValue != null) {
					result.put(fieldName, fieldValue);
				}
			} catch (Exception ignored) {
			} 
		}

		return result;
	}

	private String buildGetterName(String fieldName) {
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Filter clone() {
		return new Filter(this);
	}

}