package com.buscape.wrapper.result.type;

/**
 * Status da resposta
 */
public enum Status {
	/**
	 * Resposta bem sucedida
	 */
	SUCCESS("success"),

	/**
	 * Falha na resposta
	 */
	FAIL("fail");

	/**
	 * Status da resposta
	 */
	private String status;

	/**
	 * @param status
	 *            O status
	 */
	Status( String status ){
		this.status = status;
	}

	@Override
	public String toString(){
		return status;
	}
}