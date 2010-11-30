package com.buscape.wrapper.result.type;

import java.util.Date;

/**
 * Detalhes da resposta
 * 
 * @author neto
 */
public class Details {
	/**
	 * ID da aplicação
	 */
	private String applicationID;

	/**
	 * Endereço da aplicação
	 */
	private String applicationPath;

	/**
	 * Versão da aplicação
	 */
	private String applicationVersion;

	/**
	 * Código da resposta
	 */
	private final int code;

	/**
	 * Data/Hora da requisição
	 */
	private final Date date;

	/**
	 * Tempo de execução da requisição em milisegundos
	 */
	private final int elapsedTime;

	/**
	 * Mensagem da resposta
	 */
	private final String message;

	/**
	 * Status da resposta
	 */
	private final Status status;

	/**
	 * Constroi o objeto de detalhes da resposta
	 * 
	 * @param code
	 *            O Código da resposta
	 * @param date
	 *            Data/Hora da requisição
	 * @param elapsedTime
	 *            Tempo de execução da requisição em milisegundos
	 * @param message
	 *            Mensagem da resposta
	 * @param status
	 *            Status da resposta
	 */
	public Details( int code , Date date , int elapsedTime , String message , String status ) {
		this.code = code;
		this.date = date;
		this.elapsedTime = elapsedTime;
		this.message = message;
		this.status = status.equals( "success" ) ? Status.SUCCESS : Status.FAIL;
	}

	/**
	 * @return O ID da aplicação
	 */
	public final String getApplicationID() {
		return applicationID;
	}

	/**
	 * @return O endereço da aplicação
	 */
	public final String getApplicationPath() {
		return applicationPath;
	}

	/**
	 * @return A versão da aplicação
	 */
	public final String getApplicationVersion() {
		return applicationVersion;
	}

	/**
	 * @return O código da resposta
	 */
	public final int getCode() {
		return code;
	}

	/**
	 * @return A Data/Hora da requisição
	 */
	public final Date getDate() {
		return date;
	}

	/**
	 * @return O Tempo de execução da requisição em milisegundos
	 */
	public final int getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @return A Mensagem da resposta
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @return O Status da resposta
	 */
	public final Status getStatus() {
		return status;
	}

	/**
	 * Define o ID da aplicação
	 * 
	 * @param applicationID
	 */
	public final void setApplicationID( String applicationID ) {
		this.applicationID = applicationID;
	}

	/**
	 * Define o endereço da aplicação
	 * 
	 * @param applicationPath
	 */
	public final void setApplicationPath( String applicationPath ) {
		this.applicationPath = applicationPath;
	}

	/**
	 * Define a versão da aplicação
	 * 
	 * @param applicationVersion
	 */
	public final void setApplicationVersion( String applicationVersion ) {
		this.applicationVersion = applicationVersion;
	}
}
