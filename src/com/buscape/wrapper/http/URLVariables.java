package com.buscape.wrapper.http;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class URLVariables implements Iterable<Entry<String , String>> {
	private final Map<String , String> variables;

	public URLVariables(){
		variables = new HashMap<String , String>();
	}

	public void clear(){
		variables.clear();
	}

	public boolean containsVariable( String variable ){
		return variables.containsKey( variable );
	}

	@Override
	public Iterator<Entry<String , String>> iterator() {
		return variables.entrySet().iterator();
	}

	public void setVariable( String key , String value ){
		variables.put( key , value );
	}

	@Override
	public String toString(){
		if ( variables.size() > 0 ) {
			final Iterator<Entry<String , String>> iterator = variables.entrySet().iterator();

			String url = "";

			while ( iterator.hasNext() ) {
				final Entry<String , String> entry = iterator.next();

				url += "&" + entry.getKey() + "=" + entry.getValue();
			}

			return url;
		}

		return "";
	}

	public void unsetVariable( String key ){
		variables.remove( key );
	}
}