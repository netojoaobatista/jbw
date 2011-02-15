package com.buscape.wrapper.request;

import com.buscape.wrapper.util.Messages;

/**
 * Tipos de ordenação
 * 
 * @author neto
 */
public enum Sort {
	/**
	 * Ordenação por preço da parcela <b>Descendente</b>
	 */
	D_INSTALLMENT(Messages.getString("Sort.desc-installment")), //$NON-NLS-1$

	/**
	 * Ordenação por número de parcelas <b>Descendente</b>
	 */
	D_NUMBEROFINSTALLMENTS(Messages.getString("Sort.desc-num-installment")), //$NON-NLS-1$

	/**
	 * Ordenação por preço <b>Descendente</b>
	 */
	D_PRICE(Messages.getString("Sort.desc-price")), //$NON-NLS-1$

	/**
	 * Ordenação por avaliação dos usuários <b>Descendente</b>
	 */
	D_RATE(Messages.getString("Sort.desc-rate")), //$NON-NLS-1$

	/**
	 * Ordenação por loja <b>Descendente</b>
	 */
	D_SELLER(Messages.getString("Sort.desc-seller")), //$NON-NLS-1$

	/**
	 * Ordenação por preço da parcela
	 */
	INSTALLMENT(Messages.getString("Sort.installment")), //$NON-NLS-1$

	/**
	 * Ordenação por número de parcelas
	 */
	NUMBEROFINSTALLMENTS(Messages.getString("Sort.num-installment")), //$NON-NLS-1$

	/**
	 * Ordenação por preço
	 */
	PRICE(Messages.getString("Sort.price")), //$NON-NLS-1$

	/**
	 * Ordenação por avaliação dos usuários
	 */
	RATE(Messages.getString("Sort.rate")), //$NON-NLS-1$

	/**
	 * Ordenação por loja
	 */
	SELLER(Messages.getString("Sort.seller")), //$NON-NLS-1$

	/**
	 * Ordenação por selo de empresa reconhecida no BuscaPé
	 */
	TRUSTEDSTORE(Messages.getString("Sort.trusted-store")); //$NON-NLS-1$

	/**
	 * Tipo de ordenação
	 */
	private String sort;

	Sort( String sort ){
		this.sort = sort;
	}

	@Override
	public String toString(){
		return sort;
	}
}