package com.buscape.wrapper.result.type;

import com.buscape.wrapper.util.Messages;

/**
 * Status da resposta
 */
public enum Status {
	/**
	 * Resposta bem sucedida
	 */
	SUCCESS(Messages.getString("ResultStatus.success")), //$NON-NLS-1$

	/**
	 * Falha na resposta
	 */
	FAIL(Messages.getString("ResultStatus.fail")); //$NON-NLS-1$

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