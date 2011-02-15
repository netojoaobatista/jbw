package com.buscape.wrapper;

import com.buscape.wrapper.http.HTTPRequest;
import com.buscape.wrapper.http.URLRequest;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.result.adapter.Adaptable;
import com.buscape.wrapper.result.adapter.json.JsonAdapter;
import com.buscape.wrapper.result.builder.AbstractResultBuilder;
import com.buscape.wrapper.result.builder.JsonResultBuilder;

/**
 * Fábrica de objetos utilizados pelo wrapper da API do BuscaPé
 * 
 * @author neto
 */
public class BuscapeFactory {
	/**
	 * Cria uma instância do objeto Builder que é utilizado para construção dos
	 * objetos do retorno
	 * @param adapter 
	 * 
	 * @return
	 */
	public AbstractResultBuilder createBuilder(Adaptable<?> adapter, ResultFormat format){
		AbstractResultBuilder builder = null;

		switch ( format ) {
			case JSON:
				builder = new JsonResultBuilder(adapter);
				break;
			case XML:
				throw new IllegalArgumentException( "O formato de retorno XML não foi implementado" ); //$NON-NLS-1$
		}

		return builder;
	}

	/**
	 * Cria uma instância do objeto de requisição HTTP, utilizado para enviar a
	 * requisição à API do BuscaPé
	 * 
	 * @return
	 */
	public HTTPRequest createHTTPRequest() {
		return new URLRequest();
	}

	/**
	 * Cria uma instância do objeto Adapter, utilizado para abstrair o uso de
	 * bibliotecas de terceiros para o tratamento dos objetos de retorno
	 * 
	 * @param data
	 *            A string retornada pela requisição HTTP
	 * @param format
	 *            O formato da resposta, para criação do objeto Adapter
	 * @return O adaptador abstrato
	 * @throws Throwable
	 */
	public Adaptable<?> createObjectAdapter( String data , ResultFormat format ) throws Throwable {
		Adaptable<?> adapter = null;

		switch ( format ) {
			case JSON:
				adapter = new JsonAdapter(data);
				break;
			case XML:
				throw new IllegalArgumentException( "O formato de retorno XML não foi implementado" ); //$NON-NLS-1$
		}

		return adapter;
	}
}