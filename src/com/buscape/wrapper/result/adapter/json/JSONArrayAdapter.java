package com.buscape.wrapper.result.adapter.json;

import org.json.JSONArray;
import com.buscape.wrapper.result.adapter.ArrayAdapter;
import com.buscape.wrapper.result.adapter.ObjectAdapter;

/**
 * Adaptador para um JSONArray. <b>Esse objeto depende do pacote org.json</b>
 * 
 * @author neto
 */
public class JSONArrayAdapter implements ArrayAdapter {
	private final JSONArray json;

	public JSONArrayAdapter( JSONArray json ) {
		this.json = json;
	}

	public JSONArrayAdapter( String json ) throws Throwable {
		this.json = new JSONArray( json );
	}

	@Override
	public boolean getBoolean( int index ) throws Throwable {
		return json.getBoolean( index );
	}

	@Override
	public double getDouble( int index ) throws Throwable {
		return json.getDouble( index );
	}

	@Override
	public int getInt( int index ) throws Throwable {
		return json.getInt( index );
	}

	@Override
	public long getLong( int index ) throws Throwable {
		return json.getLong( index );
	}

	@Override
	public ObjectAdapter getObject( int index ) throws Throwable {
		return new JSONObjectAdapter( json.getJSONObject( index ) );
	}

	@Override
	public String getString( int index ) throws Throwable {
		return json.getString( index );
	}

	@Override
	public int length() {
		return json.length();
	}

	@Override
	public String toString() {
		return json.toString();
	}
}