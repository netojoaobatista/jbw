package com.buscape.wrapper.request;

/**
 * Tipos de ordenação
 * 
 * @author neto
 */
public enum Sort {
	/**
	 * Ordenação por preço da parcela <b>Descendente</b>
	 */
	D_INSTALLMENT("dinstallment"),

	/**
	 * Ordenação por número de parcelas <b>Descendente</b>
	 */
	D_NUMBEROFINSTALLMENTS("dnumberofinstallments"),

	/**
	 * Ordenação por preço <b>Descendente</b>
	 */
	D_PRICE("dprice"),

	/**
	 * Ordenação por avaliação dos usuários <b>Descendente</b>
	 */
	D_RATE("drate"),

	/**
	 * Ordenação por loja <b>Descendente</b>
	 */
	D_SELLER("dseller"),

	/**
	 * Ordenação por preço da parcela
	 */
	INSTALLMENT("installment"),

	/**
	 * Ordenação por número de parcelas
	 */
	NUMBEROFINSTALLMENTS("numberofinstallments"),

	/**
	 * Ordenação por preço
	 */
	PRICE("price"),

	/**
	 * Ordenação por avaliação dos usuários
	 */
	RATE("rate"),

	/**
	 * Ordenação por loja
	 */
	SELLER("seller"),

	/**
	 * Ordenação por selo de empresa reconhecida no BuscaPé
	 */
	TRUSTEDSTORE("trustedstore");

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