package com.buscape.wrapper.result.adapter.json;

import org.json.JSONObject;
import com.buscape.wrapper.result.adapter.ArrayAdapter;
import com.buscape.wrapper.result.adapter.ObjectAdapter;

public class JSONObjectAdapter implements ObjectAdapter {
	private final JSONObject json;

	public JSONObjectAdapter( JSONObject json ) {
		this.json = json;
	}

	public JSONObjectAdapter( String json ) throws Throwable {
		this.json = new JSONObject( json );
	}

	@Override
	public ArrayAdapter getArray( String key ) throws Throwable {
		return new JSONArrayAdapter( json.getJSONArray( key ) );
	}

	@Override
	public boolean getBoolean( String key ) throws Throwable {
		return json.getBoolean( key );
	}

	@Override
	public double getDouble( String key ) throws Throwable {
		return json.getDouble( key );
	}

	@Override
	public int getInt( String key ) throws Throwable {
		return json.getInt( key );
	}

	@Override
	public long getLong( String key ) throws Throwable {
		return json.getLong( key );
	}

	@Override
	public ObjectAdapter getObject( String key ) throws Throwable {
		return new JSONObjectAdapter( json.getJSONObject( key ) );
	}

	@Override
	public String getString( String key ) throws Throwable {
		return json.getString( key );
	}

	@Override
    public boolean has( String key ){
		return json.has( key );
	}

	@Override
	public String toString() {
		return json.toString();
	}
}