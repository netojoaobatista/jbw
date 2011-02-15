package com.buscape.wrapper.request;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.shared.Medal;

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
	private Medal medal;

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public ResultFormat getFormat() {
		return format;
	}

	public void setFormat(ResultFormat format) {
		this.format = format;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public double getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(double priceMin) {
		this.priceMin = priceMin;
	}

	public double getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(double priceMax) {
		this.priceMax = priceMax;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public Medal getMedal() {
		return medal;
	}

	public void setMedal(Medal medal) {
		this.medal = medal;
	}

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
			} catch (SecurityException e) {
				//e.printStackTrace();
			} catch (NoSuchMethodException e) {
				//e.printStackTrace();
			} catch (IllegalArgumentException e) {
				//e.printStackTrace();
			} catch (IllegalAccessException e) {
				//e.printStackTrace();
			} catch (InvocationTargetException e) {
				//e.printStackTrace();
			} catch (NullPointerException e) {
				// TODO: handle exception
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
