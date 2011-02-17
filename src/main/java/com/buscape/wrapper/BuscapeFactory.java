package com.buscape.wrapper;

import com.buscape.wrapper.http.HttpRequester;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.result.builder.AbstractResultBuilder;
import com.buscape.wrapper.result.builder.JsonResultBuilder;
import com.buscape.wrapper.result.builder.XmlResultBuilder;

/**
 * Fábrica de objetos utilizados pelo wrapper da API do BuscaPé
 * 
 * @author neto
 */
public class BuscapeFactory {
	/**
	 * Cria uma instância do objeto Builder que é utilizado para construção dos
	 * objetos do retorno
	 * @param data 
	 * 
	 * @return
	 */
	public AbstractResultBuilder createBuilder(String data, ResultFormat format){
		AbstractResultBuilder builder = null;

		switch ( format ) {
			case JSON:
				builder = new JsonResultBuilder(data);
				break;
			case XML:
				builder = new XmlResultBuilder(data);
		}

		return builder;
	}

	/**
	 * Cria uma instância do objeto de requisição HTTP, utilizado para enviar a
	 * requisição à API do BuscaPé
	 * @param url 
	 * 
	 * @return
	 */
	public HttpRequester createRequester(String url) {
		return new HttpRequester(url);
	}
}