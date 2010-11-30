package com.buscape.wrapper;

import com.buscape.wrapper.exception.BuscapeException;
import com.buscape.wrapper.http.HTTPRequest;
import com.buscape.wrapper.request.Country;
import com.buscape.wrapper.request.Filter;
import com.buscape.wrapper.result.Result;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.result.adapter.ObjectAdapter;
import com.buscape.wrapper.result.builder.ResultBuilder;
import com.buscape.wrapper.result.type.Details;
import com.buscape.wrapper.result.type.Status;

/**
 * Wrapper da API do BuscaPé para implementações em Java
 * 
 * @author neto
 */
public class Buscape {
	static final String URL = "http://sandbox.buscape.com/service";

	/**
	 * ID da aplicação
	 */
	private final String applicationID;

	/**
	 * Fábrica de produtos abstratos
	 */
	private final BuscapeFactory factory;

	/**
	 * Adaptador utilizado para manipulação do resultado
	 */
	private ObjectAdapter adapter;

	/**
	 * Código do país que será utilizado na consulta
	 */
	private Country code = Country.BRAZIL;

	/**
	 * Filtros da requisição
	 */
	private Filter filter;

	/**
	 * Constroi o objeto do wrapper da API do BuscaPé
	 * 
	 * @param applicationID
	 *            ID da aplicação
	 */
	public Buscape( String applicationID ) {
		this.applicationID = applicationID;

		factory = new BuscapeFactory();
	}

	/**
	 * Constroi o objeto do wrapper da API do BuscaPé
	 * 
	 * @param applicationID
	 *            ID da aplicação
	 * @param factory
	 *            Fábrica de objetos abstratos
	 */
	public Buscape( String applicationID , BuscapeFactory factory ) {
		this.applicationID = applicationID;
		this.factory = factory;
	}

	/**
	 * Constroi o objeto do wrapper da API do BuscaPé
	 * @param applicationID ID da aplicação
	 * @param code Código do país
	 */
	public Buscape( String applicationID , Country code ){
		this( applicationID );
		this.code = code;
	}

	/**
	 * Constroi o objeto do wrapper da API do BuscaPé
	 * @param applicationID ID da aplicação
	 * @param code Código do país
	 * @param factory Fábrica de objetos abstratos
	 */
	public Buscape( String applicationID , Country code , BuscapeFactory factory ){
		this( applicationID , factory );
		this.code = code;
	}

	public Result findCategoryList( int categoryId ) throws BuscapeException {
		return findCategoryList( categoryId , ResultFormat.JSON );
	}	/*/**
	 * O serviço de procura de categorias permite que sejam exibidas informações
	 * relativas às categorias. É possível obter categorias, produtos ou ofertas
	 * informando apenas um ID de categoria.
	 * 
	 * @param categoryId
	 *            O ID da categoria que será buscado
	 * @param format
	 *            O Formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findCategoryList( int categoryId , ResultFormat format ) throws BuscapeException {
		return realFindCategoryList( URL + "/findCategoryList/" + applicationID + "/" + code + "/?categoryId=" + categoryId + "&format=" + format + filter , format );
	}	/*/**
	 * O serviço de procura de categorias permite que sejam exibidas informações
	 * relativas às categorias. É possível obter categorias, produtos ou ofertas
	 * informando apenas um ID de categoria.
	 * 
	 * @param keyword
	 *            Palavra chave que será utilizada para fazer a busca
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findCategoryList( String keyword ) throws BuscapeException {
		return findCategoryList( keyword , ResultFormat.JSON );
	}	/*/**
	 * O serviço de procura de categorias permite que sejam exibidas informações
	 * relativas às categorias. É possível obter categorias, produtos ou ofertas
	 * informando apenas um ID de categoria.
	 * 
	 * @param keyword
	 *            Palavra chave que será utilizada para fazer a busca
	 * @param format
	 *            O Formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findCategoryList( String keyword , ResultFormat format ) throws BuscapeException {
		return realFindCategoryList( URL + "/findCategoryList/" + applicationID + "/" + code + "/?keyword=" + keyword + "&format=" + format + filter , format );
	}	/*/**
	 * Busque todas as ofertas de um determinado produto, filtrando-os por
	 * avaliação da loja, preço ou popularidade
	 * 
	 * @param productId
	 *            O ID do produto
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findOfferList( int productId ) throws BuscapeException {
		return findOfferList( productId , ResultFormat.JSON );
	}	/*/**
	 * Busque todas as ofertas de um determinado produto, filtrando-os por
	 * avaliação da loja, preço ou popularidade
	 * 
	 * @param productId
	 *            O ID do produto
	 * @param format
	 *            O Formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findOfferList( int productId , ResultFormat format ) throws BuscapeException {
		return realFindOfferList( URL + "/findOfferList/" + applicationID + "/" + code + "/?productId=" + productId + "&format=" + format + filter , format );
	}	/*/**
	 * Busque todas as ofertas de um determinado produto, filtrando-os por
	 * avaliação da loja, preço ou popularidade
	 * 
	 * @param productId
	 *            O ID do produto
	 * @param keyword
	 *            Palavra chave que será utilizada em conjunto com o ID do
	 *            produto
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findOfferList( int productId , String keyword ) throws BuscapeException {
		return findOfferList( productId , keyword , ResultFormat.JSON );
	}	/*/**
	 * Busque todas as ofertas de um determinado produto, filtrando-os por
	 * avaliação da loja, preço ou popularidade
	 * 
	 * @param productId
	 *            O ID do produto
	 * @param keyword
	 *            Palavra chave que será utilizada em conjunto com o ID do
	 *            produto
	 * @param format
	 *            O Formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findOfferList( int productId , String keyword , ResultFormat format ) throws BuscapeException {
		return realFindOfferList( URL + "/findOfferList/" + applicationID + "/" + code + "/?productId=" + productId + "&keyword=" + keyword + "&format=" + format + filter , format );
	}	/*/**
	 * Busque todas as ofertas de um determinado produto, filtrando-os por
	 * avaliação da loja, preço ou popularidade
	 * 
	 * @param keyword
	 *            Palavra chave que será utilizada em conjunto com o ID do
	 *            produto
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findOfferList( String keyword ) throws BuscapeException {
		return findOfferList( keyword , ResultFormat.JSON );
	}	/*/**
	 * Busque todas as ofertas de um determinado produto, filtrando-os por
	 * avaliação da loja, preço ou popularidade
	 * 
	 * @param keyword
	 *            Palavra chave que será utilizada em conjunto com o ID do
	 *            produto
	 * @param format
	 *            O Formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findOfferList( String keyword , ResultFormat format ) throws BuscapeException {
		return realFindOfferList( URL + "/findOfferList/" + applicationID + "/" + code + "/?keyword=" + keyword + "&format=" + format + filter , format );
	}	/*/**
	 * Recupera uma lista de produtos utilizando o id da categoria
	 * 
	 * @param categoryId
	 *            O ID da categoria que será utilizado para a busca de produtos
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findProductList( int categoryId ) throws BuscapeException {
		return findProductList( categoryId , ResultFormat.JSON );
	}	/*/**
	 * Recupera uma lista de produtos utilizando o id da categoria
	 * 
	 * @param categoryId
	 *            O ID da categoria que será utilizado para a busca de produtos
	 * @param format
	 *            O formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findProductList( int categoryId , ResultFormat format ) throws BuscapeException {
		return realFindProductList( URL + "/findProductList/" + applicationID + "/" + code + "/?categoryId=" + categoryId + "&format=" + format + filter , format );
	}	/*/**
	 * Recupera uma lista de produtos utilizando o id da categoria e palavra
	 * chave
	 * 
	 * @param categoryId
	 *            O ID da categoria que será utilizado para a busca de produtos
	 * @param keyword
	 *            A palavra chave que será utilizada em conjunto com o ID da
	 *            categoria
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findProductList( int categoryId , String keyword ) throws BuscapeException {
		return findProductList( categoryId , keyword , ResultFormat.JSON );
	}	/*/**
	 * Recupera uma lista de produtos utilizando o id da categoria e palavra
	 * chave
	 * 
	 * @param categoryId
	 *            O ID da categoria que será utilizado para a busca de produtos
	 * @param keyword
	 *            A palavra chave que será utilizada em conjunto com o ID da
	 *            categoria
	 * @param format
	 *            O formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findProductList( int categoryId , String keyword , ResultFormat format ) throws BuscapeException {
		return realFindProductList( URL + "/findProductList/" + applicationID + "/" + code + "/?categoryId=" + categoryId + "&keyword=" + keyword + "&format=" + format + filter , format );
	}	/*/**
	 * Recupera uma lista de produtos por palavra chave
	 * 
	 * @param keyword
	 *            A palavra chave que será utilizada para a busca de produtos
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findProductList( String keyword ) throws BuscapeException {
		return findProductList( keyword , ResultFormat.JSON );
	}	/*/**
	 * Recupera uma lista de produtos por palavra chave
	 * 
	 * @param keyword
	 *            A palavra chave que será utilizada para a busca de produtos
	 * @param format
	 *            O formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result findProductList( String keyword , ResultFormat format ) throws BuscapeException {
		return realFindProductList( URL + "/findProductList/" + applicationID + "/" + code + "/?keyword=" + keyword + "&format=" + format + filter , format );
	}	/*/**
	 * Faz a consulta pelos serviços da API do BuscaPé
	 * 
	 * @param url
	 *            Endereço da consulta
	 * @param format
	 *            Formato da resposta
	 * @return
	 * @throws BuscapeException
	 */
	private ResultBuilder getBuscapeData( String url , ResultFormat format ) throws BuscapeException {
		try {
			final HTTPRequest request = factory.createHTTPRequest();

			request.setURL( url );

			adapter = factory.createObjectAdapter( request.getResponse() , format );

			final ResultBuilder builder = factory.createBuilder();
			final Details details = builder.buildDetails( adapter.getObject( "details" ) );

			if ( details.getStatus() == Status.SUCCESS ) {
				return builder;
			} else {
				throw new BuscapeException( details.getMessage() );
			}
		} catch ( final Throwable e ) {
			throw new BuscapeException( e );
		}
	}	/*/**
	 * Efetivamente faz a busca por categorias
	 * 
	 * @param url
	 *            Endereço da requisição
	 * @param format
	 *            Formato da resposta
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	private Result realFindCategoryList( String url , ResultFormat format ) throws BuscapeException {
		try {
			final ResultBuilder builder = getBuscapeData( url , format );

			if ( adapter.has( "category" ) ) {
				builder.buildCategory( adapter.getObject( "category" ) );
			} else {
				builder.buildCategory();
			}

			if ( adapter.has( "subcategory" ) ) {
				builder.buildSubCategoryList( adapter.getArray( "subcategory" ) );
			}

			if ( adapter.has( "top5category" ) ) {
				builder.buildTop5CategoryList( adapter.getArray( "top5category" ) );
			}

			return builder.getResult( adapter );
		} catch ( final Throwable e ) {
			throw new BuscapeException( e );
		}
	}	/*/**
	 * Efetivamente faz a busca por ofertas
	 * 
	 * @param url
	 *            Endereço da requisição
	 * @param format
	 *            Formato da resposta
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	private Result realFindOfferList( String url , ResultFormat format ) throws BuscapeException {
		try {
			final ResultBuilder builder = getBuscapeData( url , format );

			if ( adapter.has( "category" ) ) {
				builder.buildCategory( adapter.getObject( "category" ) );
			}

			if ( adapter.has( "product" ) ) {
				builder.buildProduct( adapter.getArray( "product" ) );
			}

			if ( adapter.has( "offer" ) ) {
				builder.buildOffer( adapter.getArray( "offer" ) );
			}

			return builder.getResult( adapter );
		} catch ( final Throwable e ) {
			throw new BuscapeException( e );
		}
	}
	/**
	 * Efetivamente faz a busca de produtos
	 * 
	 * @param url
	 *            Endereço da requisição
	 * @param format
	 *            Formato da requisição
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	private Result realFindProductList( String url , ResultFormat format ) throws BuscapeException {
		try {
			final ResultBuilder builder = getBuscapeData( url , format );

			if ( adapter.has( "category" ) ) {
				builder.buildCategory( adapter.getObject( "category" ) );
			}

			if ( adapter.has( "product" ) ) {
				builder.buildProduct( adapter.getArray( "product" ) );
			}

			return builder.getResult( adapter );
		} catch ( final Throwable e ) {
			throw new BuscapeException( e );
		}
	}

	/*/**
	 * Define os filtros da requisição
	 * @param filter
	 */
	public void setFilter( Filter filter ){
		this.filter = filter;
	}	/*/**
	 * O serviço de procura de categorias permite que sejam exibidas informações
	 * relativas às categorias. É possível obter categorias, produtos ou ofertas
	 * informando apenas um ID de categoria.
	 * 
	 * @param categoryId
	 *            O ID da categoria que será buscado
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */

	/**
	 * Este serviço retorna os produtos mais populares do BuscaPé
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result topProducts() throws BuscapeException {
		return topProducts( ResultFormat.JSON );
	}

	/**
	 * Este serviço retorna os produtos mais populares do BuscaPé
	 * @param format O Formato da resposta: JSON ou XML
	 * @return Resultado da consulta
	 * @throws BuscapeException
	 */
	public Result topProducts( ResultFormat format ) throws BuscapeException {
		return realFindProductList( URL + "/topProducts/" + applicationID + "/" + code + "/?format=" + format + filter , format );
	}
}