package com.buscape.wrapper;

import com.buscape.wrapper.exception.BuscapeException;
import com.buscape.wrapper.http.HttpRequester;
import com.buscape.wrapper.request.Country;
import com.buscape.wrapper.request.Filter;
import com.buscape.wrapper.request.Service;
import com.buscape.wrapper.request.util.URLBuilder;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.result.parser.AbstractResultParser;
import com.buscape.wrapper.result.type.Result;

/**
 * Wrapper da API do BuscaPé para implementações em Java
 * 
 * @author neto
 */
public class Buscape {

	private final String applicationId;

	private final BuscapeFactory factory;

	private final Country countryCode;

	private final Filter filter;
	
	private final ResultFormat format;

	/**
	 * Constructs a wrapper object to Buscapé API, with <code>BRAZIL</code> as
	 * country and <code>XML</code> as default result format.
	 * 
	 * @param applicationId
	 *            identification of application which will use the API.
	 * @param filter
	 *            default filter for all requests made in API.
	 */
	public Buscape(String applicationId, Filter filter) {
		this(applicationId, filter, Country.BRAZIL, ResultFormat.XML);
	}
	
	/**
	 * Constructs a wrapper object to Buscapé API, with <code>BRAZIL</code> as
	 * country.
	 * 
	 * @param applicationId
	 *            identification of application which will use the API.
	 * @param filter
	 *            default filter for all requests made in API.
	 * @param format 
	 * 			  default result format of requests.
	 */
	public Buscape(String applicationId, Filter filter, ResultFormat format) {
		this(applicationId, filter, Country.BRAZIL, format);
	}

	/**
	 * Constructs a wrapper object to Buscapé API.
	 * 
	 * @param applicationId
	 *            identification of application which will use the API. 
	 * @param filter
	 *            default filter for all requests made in API.
	 * @param countryCode
	 *            code of country where the API will be used.            
	 * @param format 
	 * 			  default result format of requests.
	 */
	public Buscape(String applicationId, Filter filter, Country countryCode, ResultFormat format) {
		super();
		this.applicationId = applicationId;
		this.countryCode = countryCode;
		this.filter = filter;
		this.format = format;
		this.factory = new BuscapeFactory();
	}

	/**
	 * Calls the Category List (<i>findCategoryList</i>) service and return a {@link Result} object
	 * containing the result of this request. 
	 * @param categoryId identification of category which will be listed.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result categoryList(int categoryId) throws BuscapeException {
		Filter f = filter.clone();
		f.setCategoryId(categoryId);
		return callCategoryList(f);
	}
	
	/**
	 * Calls the Category List (<i>findCategoryList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param keyword keyword used to filter the categories.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result categoryList(String keyword) throws BuscapeException {
		Filter f = filter.clone();
		f.setKeyword(keyword);
		return callCategoryList(f);
	}
	
	/**
	 * Calls the Product List (<i>findProductList</i>) service and return a {@link Result} object
	 * containing the result of this request. 
	 * @param categoryId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result productList(int categoryId) throws BuscapeException {
		Filter f = filter.clone();
		f.setCategoryId(categoryId);
		return callProductList(f);
	}
	
	/**
	 * Calls the Product List (<i>findProductList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param keyword keyword used to filter the products.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result productList(String keyword) throws BuscapeException {
		Filter f = filter.clone();
		f.setKeyword(keyword);
		return callProductList(f);
	}
		
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param categoryId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByCategory(int categoryId) throws BuscapeException {
		Filter f = filter.clone();
		f.setCategoryId(categoryId);
		return callOfferList(f);
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param productId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByProduct(int productId) throws BuscapeException {
		Filter f = filter.clone();
		f.setProductId(productId);
		return callOfferList(f);
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param barcode TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByBarcode(String barcode) throws BuscapeException {
		Filter f = filter.clone();
		f.setBarcode(barcode);
		return callOfferList(f);
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param keyword TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerListByKeyword(String keyword) throws BuscapeException {
		Filter f = filter.clone();
		f.setKeyword(keyword);
		return callOfferList(f);
	}
	
	/**
	 * Calls the Offer List (<i>findOfferList</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param categoryId TODO
	 * @param keyword TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result offerList(int categoryId, String keyword) throws BuscapeException {
		Filter f = filter.clone();
		f.setKeyword(keyword);
		f.setCategoryId(categoryId);
		return callOfferList(f);
	}
	
	/**
	 * Calls the Popular Products List (<i>topProducts</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result popularProductList() throws BuscapeException {
		Filter f = filter.clone();
		return callTopProducts(f);
	}
	
	/**
	 * Calls the User Rating (<i>viewUserRatings</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param productId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result userRating(int productId) throws BuscapeException {
		Filter f = filter.clone();
		f.setProductId(productId);
		return callUserRating(f);
	}
	
	/**
	 * Calls the Details of a Product (<i>viewProductDetails</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param productId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result productDetails(int productId) throws BuscapeException {
		Filter f = filter.clone();
		f.setProductId(productId);
		return callProductDetails(f);
	}
	
	/**
	 * Calls the Details of a Seller (<i>viewSellerDetails</i>) service and return a {@link Result} object
	 * containing the result of this request.
	 * @param sellerId TODO
	 * @return a {@link Result} object populated with information of response.
	 * @throws BuscapeException 
	 */
	public Result sellerDetails(int sellerId) throws BuscapeException {
		Filter f = filter.clone();
		f.setSellerId(sellerId);
		return callSellerDetails(f);
	}	
	
	private Result callCategoryList(Filter f) throws BuscapeException {
		return callGenericService(Service.LIST_CATEGORY, f);
	}
	
	private Result callProductList(Filter f) throws BuscapeException {
		return callGenericService(Service.LIST_PRODUCT, f);
	}
	
	private Result callOfferList(Filter f) throws BuscapeException {
		return callGenericService(Service.LIST_OFFER, f);
	}
	
	private Result callTopProducts(Filter f) throws BuscapeException {
		return callGenericService(Service.TOP_PRODUCTS, f);
	}
	
	private Result callUserRating(Filter f) throws BuscapeException {
		return callGenericService(Service.USER_RATING, f);
	}
	
	private Result callProductDetails(Filter f) throws BuscapeException {
		return callGenericService(Service.DETAILS_PRODUCT, f);
	}
	
	private Result callSellerDetails(Filter f) throws BuscapeException {
		return callGenericService(Service.DETAILS_SELLER, f);
	}
	
	private Result callGenericService(Service service, Filter f) throws BuscapeException {
		String url = new URLBuilder().service(service).applicationId(applicationId).countryCode(countryCode).filter(f).build();
		String data = callService(url);
		AbstractResultParser builder = getResultBuilder(data);

		return builder.getResult();
	}

	private String callService(String url) throws BuscapeException {
		try {
			final HttpRequester request = new HttpRequester(url);
			
			return request.getResponse();
		} catch (Exception e) {
			throw new BuscapeException(String.format("Erro on calling service: %s.", url), e);
		}
	}
	
	private AbstractResultParser getResultBuilder(String data) {
		return factory.createParser(data, format);
	}
}