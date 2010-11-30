package com.buscape.wrapper.result.adapter;

/**
 * Adaptador para uma matriz
 * 
 * @author neto
 */
public interface ArrayAdapter {
	/**
	 * Recupera um boolean de uma posição específica
	 * 
	 * @param offset
	 *            A posição de onde se deseja recuperar o valor
	 * @return TRUE ou FALSE
	 * @throws Throwable
	 */
	public boolean getBoolean( int offset ) throws Throwable;

	/**
	 * Recupera um double de uma posição específica
	 * 
	 * @param offset
	 *            A posição de onde se deseja recuperar o valor
	 * @return
	 * @throws Throwable
	 */
	public double getDouble( int offset ) throws Throwable;

	/**
	 * Recupera um int de uma posição específica
	 * 
	 * @param offset
	 *            A posição de onde se deseja recuperar o valor
	 * @return
	 * @throws Throwable
	 */
	public int getInt( int offset ) throws Throwable;

	/**
	 * Recupera um long de uma posição específica
	 * 
	 * @param offset
	 *            A posição de onde se deseja recuperar o valor
	 * @return
	 * @throws Throwable
	 */
	public long getLong( int offset ) throws Throwable;

	/**
	 * Recupera um ObjectAdapter de uma posição específica
	 * 
	 * @param offset
	 *            A posição de onde se deseja recuperar o valor
	 * @return
	 * @throws Throwable
	 */
	public ObjectAdapter getObject( int offset ) throws Throwable;

	/**
	 * Recupera uma String de uma posição específica
	 * 
	 * @param offset
	 *            A posição de onde se deseja recuperar o valor
	 * @return
	 * @throws Throwable
	 */
	public String getString( int offset ) throws Throwable;

	/**
	 * @return Quantidade de itens na matriz
	 */
	public int length();
}