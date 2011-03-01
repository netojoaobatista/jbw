package com.buscape.wrapper;

import com.buscape.wrapper.http.HTTPRequest;
import com.buscape.wrapper.http.URLRequest;
import com.buscape.wrapper.result.ResultFormat;
import com.buscape.wrapper.result.adapter.ObjectAdapter;
import com.buscape.wrapper.result.adapter.json.JSONObjectAdapter;
import com.buscape.wrapper.result.builder.ResultBuilder;

/**
 * Fábrica de objetos utilizados pelo wrapper da API do BuscaPé
 * 
 * @author neto
 */
public class BuscapeFactory {
	/**
	 * Cria uma instância do objeto Builder que é utilizado para construção dos
	 * objetos do retorno
	 * 
	 * @return
	 */
	public ResultBuilder createBuilder(){
		return new ResultBuilder();
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
	public ObjectAdapter createObjectAdapter( String data , ResultFormat format ) throws Throwable {
		ObjectAdapter adapter = null;

		System.out.println( data );

		switch ( format ) {
			case JSON:
				adapter = new JSONObjectAdapter( data );
				break;
			case XML:
				throw new IllegalArgumentException( "O formato de retorno XML não foi implementado" );
		}

		return adapter;
	}
}