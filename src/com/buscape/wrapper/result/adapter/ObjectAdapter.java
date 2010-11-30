package com.buscape.wrapper.result.adapter;

/**
 * Adaptador para um objeto
 * 
 * @author neto
 */
public interface ObjectAdapter {
	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return Um adaptador para uma matriz
	 * @throws Throwable
	 */
	public ArrayAdapter getArray( String key ) throws Throwable;

	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return O valor da propriedade do objeto
	 * @throws Throwable
	 */
	public boolean getBoolean( String key ) throws Throwable;

	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return O valor da propriedade do objeto
	 * @throws Throwable
	 */
	public double getDouble( String key ) throws Throwable;

	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return O valor da propriedade do objeto
	 * @throws Throwable
	 */
	public int getInt( String key ) throws Throwable;

	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return O valor da propriedade do objeto
	 * @throws Throwable
	 */
	public long getLong( String key ) throws Throwable;

	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return O valor da propriedade do objeto
	 * @throws Throwable
	 */
	public ObjectAdapter getObject( String key ) throws Throwable;

	/**
	 * @param key
	 *            Chave que indica a propriedade do objeto
	 * @return O valor da propriedade do objeto
	 * @throws Throwable
	 */
	public String getString( String key ) throws Throwable;

	/**
	 * Verifica se o objeto possui uma propriedade específica
	 * 
	 * @param key
	 *            Nome da propriedade que se deseja verificar
	 * @return TRUE se o objeto possuir tal propriedade
	 */
	public boolean has( String key );
}